package com.dsatija.nasagallery.data

import androidx.paging.PagingSource
import com.dsatija.nasagallery.api.NasaApi
import retrofit2.HttpException
import java.io.IOException

/**
 * Data set for paging.
 */
private const val NASA_STARTING_PAGE_INDEX = 1

class NasaPagingSource(
    private val nasaApi: NasaApi,
    private val query: String
) : PagingSource<Int, Item>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        val position = params.key ?: NASA_STARTING_PAGE_INDEX

        return try {
            val response = nasaApi.searchPhotos(position,query)
            val photos = response.collection.items

            LoadResult.Page(
                data = photos,
                prevKey = if (position == NASA_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

}