package ru.glushko.sbertroyka_testapp.domain.model

data class Route(
    val galleries: List<Gallery>,
    val media: List<Media>,
    val textContents: List<TextContent>,
    val title: String,
)