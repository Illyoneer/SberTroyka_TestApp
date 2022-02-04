package ru.glushko.sbertroyka_testapp.domain.usecases

import ru.glushko.sbertroyka_testapp.domain.model.DataList
import ru.glushko.sbertroyka_testapp.domain.repository.DataRepository

class GetAllDataUseCase(private val _dataRepository: DataRepository) {
    suspend fun getAllData(): DataList = _dataRepository.getAllData()
}