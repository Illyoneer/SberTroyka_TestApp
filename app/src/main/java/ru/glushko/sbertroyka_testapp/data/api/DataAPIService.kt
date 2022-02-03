package ru.glushko.sbertroyka_testapp.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.glushko.sbertroyka_testapp.data.model.APIDataList
import ru.glushko.sbertroyka_testapp.domain.model.DataList

interface DataAPIService {
    @GET("api/excursions/v1.0")
    suspend fun getAllData(): Response<DataList> //Заменить на API класс для сохранения Clean Arch.
}