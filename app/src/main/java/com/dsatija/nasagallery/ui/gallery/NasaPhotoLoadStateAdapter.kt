package com.dsatija.nasagallery.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dsatija.nasagallery.databinding.NasaPhotoLoadStateFooterBinding

/**
 * Adapter for displaying a RecyclerView footer based on LoadState,
 * to show loading spinner followed by a retry error button.
 */
class NasaPhotoLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<NasaPhotoLoadStateAdapter.LoadStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding = NasaPhotoLoadStateFooterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return LoadStateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    inner

    class LoadStateViewHolder(private val binding: NasaPhotoLoadStateFooterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnRetry.setOnClickListener {
                retry.invoke()
            }
        }

        fun bind(loadState: LoadState) {
            binding.apply {
                progressBar.isVisible = loadState is LoadState.Loading
                btnRetry.isVisible = loadState !is LoadState.Loading
                textViewError.isVisible = loadState !is LoadState.Loading

            }
        }

    }
}