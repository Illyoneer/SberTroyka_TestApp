package ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.routes

import androidx.recyclerview.widget.DiffUtil
import ru.glushko.sbertroyka_testapp.domain.model.Route

class RoutesDiffCallback : DiffUtil.ItemCallback<Route>() {
    override fun areItemsTheSame(oldItem: Route, newItem: Route): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Route, newItem: Route): Boolean {
        return oldItem == newItem
    }
}