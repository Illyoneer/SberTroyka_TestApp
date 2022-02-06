package ru.glushko.sbertroyka_testapp.di

import org.koin.dsl.module
import ru.glushko.sbertroyka_testapp.app.TroykaTestApp

val appModule = module {
    single {
        TroykaTestApp()
    }
}