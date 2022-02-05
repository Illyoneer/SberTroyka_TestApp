package ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.galery

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.glushko.sbertroyka_testapp.databinding.GalleryRecyclerItemBinding

class GalleryRecyclerAdapter : ListAdapter<String, GalleryViewHolder>(GalleryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GalleryRecyclerItemBinding.inflate(inflater, parent, false)
        return GalleryViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holderRoutes: GalleryViewHolder, position: Int) {
        val itemElement = getItem(position)
        val uri = Uri.parse(itemElement)

        with(holderRoutes.galleryRecyclerItem) {
            frescoImageView.setImageURI(uri)
        }
    }
}