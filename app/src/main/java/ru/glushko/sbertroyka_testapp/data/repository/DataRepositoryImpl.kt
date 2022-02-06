package ru.glushko.sbertroyka_testapp.data.repository

import ru.glushko.sbertroyka_testapp.data.api.DataAPIService
import ru.glushko.sbertroyka_testapp.domain.model.DataList
import ru.glushko.sbertroyka_testapp.domain.repository.DataRepository

class DataRepositoryImpl(private val _dataAPI: DataAPIService) : DataRepository {
    override suspend fun getAllData(): DataList = _dataAPI.getAllData()
}