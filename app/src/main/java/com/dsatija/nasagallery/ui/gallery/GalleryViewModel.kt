package com.dsatija.nasagallery.ui.gallery

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.dsatija.nasagallery.data.NasaRepository

class GalleryViewModel @ViewModelInject constructor(
    private val repository: NasaRepository,
    //Handling process death
    @Assisted state: SavedStateHandle
) : ViewModel() {

    private val currentQuery = state.getLiveData(CURRENT_QUERY,DEFAULT_QUERY)
    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }
    fun searchPhotos(query : String) {
        currentQuery.value = query
    }
    companion object{
        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = "mars"
    }
}