package com.bubal93.tcrypto.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//main context class
@Module
class AppModule(private val app: App) {
    @Provides
    @Singleton
    fun provideContext(): Context = app
}