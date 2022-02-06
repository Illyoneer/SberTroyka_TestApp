package ru.glushko.sbertroyka_testapp.domain.usecases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.glushko.sbertroyka_testapp.domain.model.Data
import ru.glushko.sbertroyka_testapp.domain.model.Route

class TransferDataUseCase {
    private val _selectedWalkData: MutableLiveData<Data> = MutableLiveData()
    private val _selectedRoutes: MutableLiveData<List<Route>> = MutableLiveData()

    fun setData(data: Data) {
        _selectedWalkData.postValue(data)
    }

    fun getData(): LiveData<Data> = _selectedWalkData

    fun setRoutes(routes: List<Route>) {
        _selectedRoutes.postValue(routes)
    }

    fun getRoutes(): LiveData<List<Route>> = _selectedRoutes
}