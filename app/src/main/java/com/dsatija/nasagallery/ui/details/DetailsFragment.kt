package com.dsatija.nasagallery.ui.details

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.dsatija.nasagallery.R
import com.dsatija.nasagallery.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(R.layout.fragment_details){
    private val args by navArgs<DetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailsBinding.bind(view)

        binding.apply {
            val photo = args.photo
            Glide.with(this@DetailsFragment)
                .load(photo.links.get(0).href)
                .error(R.drawable.ic_error)
                .listener(object : RequestListener<Drawable> {
                    //to make sure the image loads first and then description
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.isVisible = false
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.isVisible = false
                        textViewDate.isVisible = true
                        textViewTitle.isVisible = photo.data.get(0).title != null
                        textViewDescription.isVisible = photo.data.get(0).description != null
                        return false
                    }
                })
                .into(imageView)

            textViewDate.text = photo.data.get(0).date_created
            textViewTitle.text = photo.data.get(0).title
            textViewDescription.text = photo.data.get(0).description
        }
    }
}