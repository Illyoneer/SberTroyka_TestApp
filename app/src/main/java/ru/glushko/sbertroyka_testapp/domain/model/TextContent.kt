package ru.glushko.sbertroyka_testapp.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TextContent(
    val ordering: Int,
    val type: String,
    val value: String
) : Parcelable