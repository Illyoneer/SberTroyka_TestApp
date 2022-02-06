package ru.glushko.sbertroyka_testapp.di

import org.koin.dsl.module
import ru.glushko.sbertroyka_testapp.domain.usecases.GetAllDataFromApiUseCase
import ru.glushko.sbertroyka_testapp.domain.usecases.TransferDataUseCase

val domainModule = module {
    factory {
        GetAllDataFromApiUseCase(_dataRepository = get())
    }

    single {
        TransferDataUseCase()
    }
}