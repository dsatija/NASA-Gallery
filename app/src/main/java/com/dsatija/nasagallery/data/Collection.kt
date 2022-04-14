package com.dsatija.nasagallery.data

import java.util.*

data class Collection(
    val href: String,
    val items: LinkedList<Item>,
    val metadata: Metadata,
)