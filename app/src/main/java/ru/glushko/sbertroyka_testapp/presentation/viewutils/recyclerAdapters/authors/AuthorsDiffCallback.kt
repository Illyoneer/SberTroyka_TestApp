package ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.authors

import androidx.recyclerview.widget.DiffUtil
import ru.glushko.sbertroyka_testapp.domain.model.Author

class AuthorsDiffCallback : DiffUtil.ItemCallback<Author>() {
    override fun areItemsTheSame(oldItem: Author, newItem: Author): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Author, newItem: Author): Boolean {
        return oldItem == newItem
    }
}