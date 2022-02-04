package ru.glushko.sbertroyka_testapp.di

import org.koin.dsl.module
import ru.glushko.sbertroyka_testapp.domain.usecases.GetAllDataUseCase

val domainModule = module {
    factory {
        GetAllDataUseCase(_dataRepository = get())
    }
}