package ru.glushko.sbertroyka_testapp.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.glushko.sbertroyka_testapp.di.dataModule
import ru.glushko.sbertroyka_testapp.di.domainModule
import ru.glushko.sbertroyka_testapp.di.presentationModule

class TroykaTestApp  : Application() {
    companion object {
        var instance = TroykaTestApp()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidContext(this@TroykaTestApp)
            modules(listOf(presentationModule, domainModule, dataModule))
        }
    }
}