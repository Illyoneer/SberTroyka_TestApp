package ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.walks

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.glushko.sbertroyka_testapp.databinding.WalksRecyclerItemBinding
import ru.glushko.sbertroyka_testapp.domain.model.Data

class WalksRecyclerAdapter : ListAdapter<Data, WalksViewHolder>(WalksDiffCallback()) {

    var onHolderViewClickListener: ((Data) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = WalksRecyclerItemBinding.inflate(inflater, parent, false)
        return WalksViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WalksViewHolder, position: Int) {
        val itemElement = getItem(position)

        with(holder.walksRecyclerItem) {
            frescoImageView.setImageURI(Uri.parse(itemElement.img))
            title.text = itemElement.title

            root.setOnClickListener {
                onHolderViewClickListener?.invoke(itemElement)
            }
        }
    }
}