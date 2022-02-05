package ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.galery

import androidx.recyclerview.widget.DiffUtil

class GalleryDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}