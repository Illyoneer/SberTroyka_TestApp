package ru.glushko.sbertroyka_testapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.glushko.sbertroyka_testapp.domain.model.Data
import ru.glushko.sbertroyka_testapp.domain.model.Route
import ru.glushko.sbertroyka_testapp.domain.usecases.TransferDataUseCase

class WalkInfoViewModel(private val _transferDataUseCase: TransferDataUseCase) : ViewModel() {
    fun getSelectedData(): LiveData<Data> = _transferDataUseCase.getData()
    fun setSelectedRoutes(routes: List<Route>) {
        _transferDataUseCase.setRoutes(routes)
    }
}