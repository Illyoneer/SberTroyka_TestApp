package ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.authors

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.glushko.sbertroyka_testapp.databinding.AuthorsRecyclerItemBinding
import ru.glushko.sbertroyka_testapp.domain.model.Author

class AuthorsRecyclerAdapter : ListAdapter<Author, AuthorsViewHolder>(AuthorsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AuthorsRecyclerItemBinding.inflate(inflater, parent, false)
        return AuthorsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AuthorsViewHolder, position: Int) {
        val itemElement = getItem(position)

        with(holder.authorsRecyclerItem) {
            frescoImageView.setImageURI(Uri.parse(itemElement.img))
            authorName.text = itemElement.title
            authorDescription.text = itemElement.description
        }
    }
}