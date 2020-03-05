package com.bubal93.tcrypto.di

import com.bubal93.tcrypto.YearValueFormatter
import com.bubal93.tcrypto.chart.LatestChart
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ChartModule {
    @Provides
    @Singleton
    fun provideLatestChart() = LatestChart()


    @Provides
    @Singleton
    fun provideYearFormatter() = YearValueFormatter()
}