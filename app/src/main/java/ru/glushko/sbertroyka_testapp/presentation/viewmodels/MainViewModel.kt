package ru.glushko.sbertroyka_testapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.glushko.sbertroyka_testapp.domain.model.Data
import ru.glushko.sbertroyka_testapp.domain.model.DataList
import ru.glushko.sbertroyka_testapp.domain.usecases.GetAllDataUseCase

class MainViewModel(private val _getAllDataUseCase: GetAllDataUseCase): ViewModel() {

    val localDataList: MutableLiveData<DataList> = MutableLiveData()
    val localData: MutableLiveData<Data> = MutableLiveData()

    fun getAllDataFromAPI() = viewModelScope.launch {
        localDataList.postValue(_getAllDataUseCase.getAllData())
    }

    fun getLocalData(): LiveData<Data> = localData

}