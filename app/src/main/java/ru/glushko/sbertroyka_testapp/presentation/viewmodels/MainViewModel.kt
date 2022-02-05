package ru.glushko.sbertroyka_testapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.glushko.sbertroyka_testapp.domain.model.Data
import ru.glushko.sbertroyka_testapp.domain.model.DataList
import ru.glushko.sbertroyka_testapp.domain.model.Route
import ru.glushko.sbertroyka_testapp.domain.usecases.GetAllDataUseCase

class MainViewModel(private val _getAllDataUseCase: GetAllDataUseCase) : ViewModel() {

    val localDataList: MutableLiveData<DataList> = MutableLiveData()
    val selectedWalkData: MutableLiveData<Data> = MutableLiveData()
    val selectedWalkRoutes: MutableLiveData<List<Route>> = MutableLiveData()

    fun getAllDataFromAPI() = viewModelScope.launch {
        localDataList.postValue(_getAllDataUseCase.getAllData())
    }
}