package ru.glushko.sbertroyka_testapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import ru.glushko.sbertroyka_testapp.databinding.FragmentWalkInfoBinding
import ru.glushko.sbertroyka_testapp.presentation.activity.MainActivity
import ru.glushko.sbertroyka_testapp.presentation.viewmodels.MainViewModel
import ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.authors.AuthorsRecyclerAdapter
import ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.routes.RoutesRecyclerAdapter

class WalkInfoFragment : Fragment() {

    private lateinit var _walkInfoFBinding: FragmentWalkInfoBinding
    private val _mainViewModel: MainViewModel by sharedViewModel()
    private val _authorsRecyclerAdapter = AuthorsRecyclerAdapter()
    private val _routesRecyclerAdapter = RoutesRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _walkInfoFBinding = FragmentWalkInfoBinding.inflate(inflater, container, false)

        setupRecyclersView()

        return _walkInfoFBinding.root
    }

    private fun setupRecyclersView() {
        _walkInfoFBinding.authorsRecyclerView.adapter = _authorsRecyclerAdapter
        _walkInfoFBinding.routesRecyclerView.adapter = _routesRecyclerAdapter
    }

    override fun onStart() {
        super.onStart()
        _mainViewModel.localData.observe(viewLifecycleOwner) {
            (activity as MainActivity).supportActionBar?.title = it.title
            _walkInfoFBinding.descriptionText.text = it.description
            _walkInfoFBinding.walkTime.text = it.duration.toString()
            _authorsRecyclerAdapter.submitList(it.authors)
            _routesRecyclerAdapter.submitList(it.routes)
        }
    }

}