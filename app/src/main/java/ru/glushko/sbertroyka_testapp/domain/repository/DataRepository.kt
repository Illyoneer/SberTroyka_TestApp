package ru.glushko.sbertroyka_testapp.domain.repository

import retrofit2.Response
import ru.glushko.sbertroyka_testapp.domain.model.DataList

interface DataRepository {
    suspend fun getAllData(): Response<DataList>
}