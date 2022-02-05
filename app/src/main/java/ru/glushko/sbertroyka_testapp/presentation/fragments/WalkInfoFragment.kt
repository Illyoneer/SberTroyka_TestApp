package ru.glushko.sbertroyka_testapp.presentation.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import ru.glushko.sbertroyka_testapp.R
import ru.glushko.sbertroyka_testapp.databinding.FragmentWalkInfoBinding
import ru.glushko.sbertroyka_testapp.presentation.viewmodels.MainViewModel
import ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.authors.AuthorsRecyclerAdapter
import ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.routes.RoutesRecyclerAdapter

class WalkInfoFragment : Fragment() {

    private lateinit var _walkInfoFBinding: FragmentWalkInfoBinding

    private val _mainViewModel: MainViewModel by sharedViewModel()

    private val _authorsRecyclerAdapter = AuthorsRecyclerAdapter()
    private val _routesRecyclerAdapter = RoutesRecyclerAdapter()

    private var _countOfPages = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _walkInfoFBinding = FragmentWalkInfoBinding.inflate(inflater, container, false)

        setupRecyclersView()

        _walkInfoFBinding.startWalkButton.setOnClickListener {
            val walkStepsFragment = WalkStepsFragment.newInstance(_countOfPages)
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, walkStepsFragment)
                .addToBackStack("start_walk")
                .commit()
        }

        _walkInfoFBinding.walkInfoCloseButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        return _walkInfoFBinding.root
    }

    private fun setupRecyclersView() {
        with(_walkInfoFBinding) {
            authorsRecyclerView.adapter = _authorsRecyclerAdapter
            routesRecyclerView.adapter = _routesRecyclerAdapter
        }
    }

    override fun onStart() {
        super.onStart()
        _mainViewModel.selectedWalkData.observe(viewLifecycleOwner) {
            with(_walkInfoFBinding) {
                walkInfoTitle.text = it.title
                descriptionText.text = it.description
                walkTime.text = it.duration.toString()
                walkAuthor.text = it.authorCompany.title
                _walkInfoFBinding.walkAuthorIcon.setImageURI(Uri.parse(it.authorCompany.img))
                if (it.type == "PEDESTRIAN")
                    walkType.text = "Пешеходная"
                else
                    walkType.text = "На транспорте"
            }
            _authorsRecyclerAdapter.submitList(it.authors)
            _routesRecyclerAdapter.submitList(it.routes)
            _countOfPages = it.routes.size
        }
    }

}