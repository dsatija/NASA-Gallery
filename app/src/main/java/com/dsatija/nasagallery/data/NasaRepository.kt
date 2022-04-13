package com.dsatija.nasagallery.data

import com.dsatija.nasagallery.api.NasaApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NasaRepository @Inject constructor(private val nasaApi: NasaApi) {
}