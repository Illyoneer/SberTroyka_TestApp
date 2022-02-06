package ru.glushko.sbertroyka_testapp.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Gallery(
    val ordering: Int, //Очередность изображений
    val value: List<String> //Ссылки на изображения
) : Parcelable