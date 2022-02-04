package ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.routes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.glushko.sbertroyka_testapp.databinding.RoutesRecyclerItemBinding
import ru.glushko.sbertroyka_testapp.domain.model.Route

class RoutesRecyclerAdapter : ListAdapter<Route, RoutesAuthorsViewHolder>(RoutesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutesAuthorsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RoutesRecyclerItemBinding.inflate(inflater, parent, false)
        return RoutesAuthorsViewHolder(binding)
    }

    override fun onBindViewHolder(holderRoutes: RoutesAuthorsViewHolder, position: Int) {
        val itemElement = getItem(position)

        with(holderRoutes.routesRecyclerItem) {
            routePointText.text = itemElement.title
        }
    }
}