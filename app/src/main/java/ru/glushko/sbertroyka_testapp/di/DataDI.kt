package ru.glushko.sbertroyka_testapp.di

import org.koin.dsl.module
import ru.glushko.sbertroyka_testapp.data.repository.DataRepositoryImpl
import ru.glushko.sbertroyka_testapp.domain.repository.DataRepository

val dataModule = module {
    single<DataRepository> {
        DataRepositoryImpl()
    }
}
