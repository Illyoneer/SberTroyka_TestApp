package ru.glushko.sbertroyka_testapp.di


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.glushko.sbertroyka_testapp.presentation.viewmodels.StepViewModel
import ru.glushko.sbertroyka_testapp.presentation.viewmodels.WalkInfoViewModel
import ru.glushko.sbertroyka_testapp.presentation.viewmodels.WalksViewModel


val presentationModule = module {
    viewModel {
        WalksViewModel(_getAllDataFromApiUseCase = get(), _transferDataUseCase = get())
    }

    viewModel {
        WalkInfoViewModel(_transferDataUseCase = get())
    }

    viewModel {
        StepViewModel(_transferDataUseCase = get())
    }
}