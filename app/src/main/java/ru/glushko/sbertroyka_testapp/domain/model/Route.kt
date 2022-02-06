package ru.glushko.sbertroyka_testapp.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Route(
    val galleries: List<Gallery>,
    val media: List<Media>,
    val textContents: List<TextContent>,
    val title: String
) : Parcelable