package com.bubal93.tcrypto.di

import com.bubal93.tcrypto.activities.MainActivity
import com.bubal93.tcrypto.fragments.CurrenciesListFragment
import com.bubal93.tcrypto.mvp.presenter.CurrenciesPresenter
import com.bubal93.tcrypto.mvp.presenter.LatestChartPresenter
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = arrayOf(
        AppModule::class, RestModule::class,
        MvpModule::class, ChartModule::class
    )
)
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(fragment: CurrenciesListFragment)

    fun inject(presenter: CurrenciesPresenter)
    fun inject(presenter: LatestChartPresenter)

}