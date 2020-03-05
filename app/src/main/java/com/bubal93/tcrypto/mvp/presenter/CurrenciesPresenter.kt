package com.bubal93.tcrypto.mvp.presenter

import com.bubal93.tcrypto.adapter.CurrenciesAdapter
import com.bubal93.tcrypto.di.App
import com.bubal93.tcrypto.formatThousands
import com.bubal93.tcrypto.mvp.contract.CurrenciesContract
import com.bubal93.tcrypto.rest.CoinGeckoApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CurrenciesPresenter : CurrenciesContract.Presenter() {
    //inject data source
    @Inject
    lateinit var geckoApi: CoinGeckoApi

    //initialise Dagger components
    init {
        App.appComponent.inject(this)
    }

    //create a list and load data with RxJava
    override fun makeList() {
        view.showProgress()
        //subscribe to data flow
        subscribe(geckoApi.getCoinMarket()
            //separate thread for sending data
            .subscribeOn(Schedulers.io())
            //get data in the main thread
            .observeOn(AndroidSchedulers.mainThread())
            //convert List<GeckoCoin> to Observable<GeckoCoin>
            .flatMap { Observable.fromIterable(it) }
            //fill item with data for adapter
            .doOnNext {
                view.addCurrency(
                    CurrenciesAdapter.Currency(
                        it.id,
                        it.symbol,
                        it.name,
                        it.image,
                        it.current_price,
                        it.market_cap.formatThousands(),
                        it.market_cap_rank,
                        it.total_volume,
                        it.price_change_percentage_24h,
                        it.market_cap_change_percentage_24h,
                        it.circulating_supply,
                        it.total_supply,
                        it.ath,
                        it.ath_change_percentage
                    )
                )
            }
            .doOnComplete {
                view.hideProgress()
            }
            //subscribe Observer to Observable
            .subscribe({
                view.hideProgress()
                view.notifyAdapter()
            }, {
                view.showErrorMessage(it.message)
                view.hideProgress()
                it.printStackTrace()
            })
        )
    }

    //refresh the list
    override fun refreshList() {
        view.refresh()
        makeList()
    }
}