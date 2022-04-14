package com.dsatija.nasagallery.data

import java.io.Serializable

data class AssetLink(
    val href: String,
    val rel: String,
    val render: String
) : Serializable