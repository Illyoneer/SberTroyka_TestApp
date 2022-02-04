package ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.walks

import androidx.recyclerview.widget.DiffUtil
import ru.glushko.sbertroyka_testapp.domain.model.Data

class WalksDiffCallback : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}