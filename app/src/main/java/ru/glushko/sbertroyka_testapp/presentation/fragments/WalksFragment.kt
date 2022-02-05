package ru.glushko.sbertroyka_testapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import ru.glushko.sbertroyka_testapp.R
import ru.glushko.sbertroyka_testapp.databinding.FragmentWalksBinding
import ru.glushko.sbertroyka_testapp.presentation.viewmodels.MainViewModel
import ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.walks.WalksRecyclerAdapter

class WalksFragment : Fragment() {

    private lateinit var _walksFBinding: FragmentWalksBinding
    private val _walksRecyclerAdapter = WalksRecyclerAdapter()
    private val _mainViewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _walksFBinding =  FragmentWalksBinding.inflate(inflater, container, false)

        _mainViewModel.getAllDataFromAPI()
        setupRecyclerView()

        return _walksFBinding.root
    }

    override fun onStart() {
        super.onStart()
        _mainViewModel.localDataList.observe(viewLifecycleOwner) {
            _walksRecyclerAdapter.submitList(it.data)
        }
    }

    private fun setupRecyclerView() {
        _walksFBinding.recyclerView.adapter = _walksRecyclerAdapter
        setupOnHolderViewClick(_walksRecyclerAdapter)
    }

    private fun setupOnHolderViewClick(walksRecyclerAdapter: WalksRecyclerAdapter) {
        walksRecyclerAdapter.onHolderViewClickListener = { data ->
            _mainViewModel.selectedWalkData.postValue(data)
            _mainViewModel.selectedWalkRoutes.postValue(data.routes)
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, WalkInfoFragment())
                .addToBackStack("info")
                .commit()
        }
    }
}