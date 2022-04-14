package com.dsatija.nasagallery.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.dsatija.nasagallery.api.NasaApi
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository to handle network call with pagination.
 */
@Singleton
class NasaRepository @Inject constructor(private val nasaApi: NasaApi) {

    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {NasaPagingSource(nasaApi, query) }
        ).liveData
}