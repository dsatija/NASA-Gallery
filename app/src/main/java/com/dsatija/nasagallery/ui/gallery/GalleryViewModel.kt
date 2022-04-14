package com.dsatija.nasagallery.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.dsatija.nasagallery.data.NasaRepository

class GalleryViewModel @ViewModelInject constructor(
    private val repository: NasaRepository
) : ViewModel() {
    private val currentQuery = MutableLiveData(DEFAUL_QUERY)
    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }

    companion object{
        private const val DEFAUL_QUERY = "cats"
    }
}