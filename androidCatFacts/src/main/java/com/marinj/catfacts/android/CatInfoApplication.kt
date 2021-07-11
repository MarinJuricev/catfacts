package com.marinj.catfacts.android

import android.app.Application
import com.marinj.catfacts.android.feature.catinfo.di.catInfoModule
import com.marinj.catfacts.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class CatInfoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@CatInfoApplication)
            modules(catInfoModule)
        }
    }
}