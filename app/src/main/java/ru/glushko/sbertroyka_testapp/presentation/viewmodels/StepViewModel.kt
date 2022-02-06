package ru.glushko.sbertroyka_testapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.glushko.sbertroyka_testapp.domain.model.Route
import ru.glushko.sbertroyka_testapp.domain.usecases.TransferDataUseCase

class StepViewModel(private val _transferDataUseCase: TransferDataUseCase) : ViewModel() {
    fun getSelectedRoutes(): LiveData<List<Route>> = _transferDataUseCase.getRoutes()
}