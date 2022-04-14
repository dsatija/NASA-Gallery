package com.dsatija.nasagallery.api

import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {
    companion object {
        const val NASA_BASE_URL = "https://images-api.nasa.gov/"
    }

    @GET("/search")
    suspend fun searchPhotos(
        @Query("page") page: Int,
        @Query("q") request: String,
        @Query("media_type") type: String = "image"
    ): NasaApiResponse

}
