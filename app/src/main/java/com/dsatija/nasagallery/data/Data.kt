package com.dsatija.nasagallery.data

import java.io.Serializable

data class Data(
    val date_created: String,
    val description: String,
    val media_type: String,
    val nasa_id: String,
    val title: String,
): Serializable