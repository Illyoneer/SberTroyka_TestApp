package ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.media

import androidx.recyclerview.widget.DiffUtil
import ru.glushko.sbertroyka_testapp.domain.model.Media

class MediaDiffCallback : DiffUtil.ItemCallback<Media>() {
    override fun areContentsTheSame(oldItem: Media, newItem: Media): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Media, newItem: Media): Boolean {
        return oldItem.value == newItem.value
    }
}