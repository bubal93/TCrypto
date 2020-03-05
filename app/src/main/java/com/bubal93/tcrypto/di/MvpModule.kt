package com.bubal93.tcrypto.di

import com.bubal93.tcrypto.mvp.presenter.CurrenciesPresenter
import com.bubal93.tcrypto.mvp.presenter.LatestChartPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MvpModule {
    @Provides
    @Singleton
    fun provideCurrenciesPresenter(): CurrenciesPresenter = CurrenciesPresenter()

    @Provides
    @Singleton
    fun provideLatestChartPresenter(): LatestChartPresenter = LatestChartPresenter()
}