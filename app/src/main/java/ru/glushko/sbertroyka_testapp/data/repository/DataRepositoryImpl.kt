package ru.glushko.sbertroyka_testapp.data.repository

import retrofit2.Response
import ru.glushko.sbertroyka_testapp.domain.model.DataList
import ru.glushko.sbertroyka_testapp.domain.repository.DataRepository

class DataRepositoryImpl: DataRepository {
    override suspend fun getAllData(): Response<DataList> {
        TODO("Not yet implemented")
    }
}