package com.dsatija.nasagallery.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dsatija.nasagallery.R
import com.dsatija.nasagallery.data.Item
import com.dsatija.nasagallery.databinding.ItemNasaPhotoBinding

class NasaPhotoAdapter :
    PagingDataAdapter<Item, NasaPhotoAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            ItemNasaPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false);
        return PhotoViewHolder(binding);
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position);
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class PhotoViewHolder(private val binding: ItemNasaPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Item) {
            binding.apply {
                Glide.with(itemView)
                    .load(photo.links.get(0).href)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(imageView)

                textViewTitle.text = photo.data?.get(0)?.title
                textviewDescription.text = photo.data?.get(0)?.description
            }
        }
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(
                oldItem: Item,
                newItem: Item
            ): Boolean =
                oldItem.data.get(0).nasa_id == newItem.data.get(0).nasa_id

            override fun areContentsTheSame(oldItem: Item, newItem: Item) =
                oldItem == newItem
        }
    }
}
