package com.bubal93.tcrypto.di

import com.bubal93.tcrypto.MainActivity
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
}