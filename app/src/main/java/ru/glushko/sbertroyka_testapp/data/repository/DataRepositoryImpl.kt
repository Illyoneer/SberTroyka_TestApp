package ru.glushko.sbertroyka_testapp.data.repository

import ru.glushko.sbertroyka_testapp.app.TroykaTestApp
import ru.glushko.sbertroyka_testapp.domain.model.DataList
import ru.glushko.sbertroyka_testapp.domain.repository.DataRepository

class DataRepositoryImpl : DataRepository {
    override suspend fun getAllData(): DataList = TroykaTestApp.instance.dataAPI.getAllData()
}