package ru.glushko.sbertroyka_testapp.data.api

import retrofit2.http.GET
import ru.glushko.sbertroyka_testapp.domain.model.DataList

interface DataAPIService {
    @GET("api/excursions/v1.0")
    suspend fun getAllData(): DataList
}