package ru.glushko.sbertroyka_testapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.glushko.sbertroyka_testapp.domain.model.Data
import ru.glushko.sbertroyka_testapp.domain.model.DataList
import ru.glushko.sbertroyka_testapp.domain.usecases.GetAllDataFromApiUseCase
import ru.glushko.sbertroyka_testapp.domain.usecases.TransferDataUseCase

class WalksViewModel(
    private val _getAllDataFromApiUseCase: GetAllDataFromApiUseCase,
    private val _transferDataUseCase: TransferDataUseCase
) : ViewModel() {

    private val _localDataList: MutableLiveData<DataList> = MutableLiveData()

    fun getAllDataFromAPI() = viewModelScope.launch {
        _localDataList.postValue(_getAllDataFromApiUseCase.getAllData())
    }

    fun getDownloadedData(): LiveData<DataList> = _localDataList

    fun setSelectedData(selectedData: Data) {
        _transferDataUseCase.setData(data = selectedData)
    }

}