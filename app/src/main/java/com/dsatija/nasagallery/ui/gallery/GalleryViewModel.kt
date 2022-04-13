package com.dsatija.nasagallery.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.dsatija.nasagallery.data.NasaRepository

class GalleryViewModel @ViewModelInject constructor(
    private val repository: NasaRepository
) : ViewModel() {
}