package ru.glushko.sbertroyka_testapp.domain.repository

import ru.glushko.sbertroyka_testapp.domain.model.DataList

interface DataRepository {
    suspend fun getAllData(): DataList
}