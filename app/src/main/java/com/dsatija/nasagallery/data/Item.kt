package com.dsatija.nasagallery.data

import java.io.Serializable

data class Item(
     val data: List<Data>,
     val links: List<AssetLink>
): Serializable