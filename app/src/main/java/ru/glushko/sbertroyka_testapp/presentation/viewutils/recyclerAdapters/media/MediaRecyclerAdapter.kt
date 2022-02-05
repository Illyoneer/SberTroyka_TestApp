package ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.media

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.glushko.sbertroyka_testapp.databinding.MediaRecyclerItemBinding
import ru.glushko.sbertroyka_testapp.domain.model.Media

class MediaRecyclerAdapter : ListAdapter<Media, MediaViewHolder>(MediaDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MediaRecyclerItemBinding.inflate(inflater, parent, false)
        return MediaViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holderRoutes: MediaViewHolder, position: Int) {
        val itemElement = getItem(position)

        with(holderRoutes.mediaRecyclerItem) {
            if (itemElement.type != "VIDEO")
                frescoImageView.setImageURI(Uri.parse(itemElement.value))
        }
    }
}