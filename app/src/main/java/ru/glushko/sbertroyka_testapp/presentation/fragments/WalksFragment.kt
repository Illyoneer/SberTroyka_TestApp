package ru.glushko.sbertroyka_testapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.glushko.sbertroyka_testapp.databinding.FragmentWalksBinding
import ru.glushko.sbertroyka_testapp.presentation.viewmodels.WalksViewModel
import ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.walks.WalksRecyclerAdapter
import java.io.IOException

class WalksFragment : Fragment() {

    private lateinit var _walksFBinding: FragmentWalksBinding

    private val _walksRecyclerAdapter = WalksRecyclerAdapter()

    private val _walksViewModel: WalksViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _walksFBinding = FragmentWalksBinding.inflate(inflater, container, false)

        try {
            _walksViewModel.getAllDataFromAPI()
        } catch (e: IOException) {
            Toast.makeText(requireContext(), "Ошибка!", Toast.LENGTH_SHORT).show()
        }
        setupRecyclerView()

        return _walksFBinding.root
    }

    override fun onStart() {
        super.onStart()
        _walksViewModel.getDownloadedData().observe(viewLifecycleOwner) {
            _walksRecyclerAdapter.submitList(it.data)
        }
    }

    private fun setupRecyclerView() {
        _walksFBinding.recyclerView.adapter = _walksRecyclerAdapter
        setupOnHolderViewClick(_walksRecyclerAdapter)
    }


    private fun setupOnHolderViewClick(walksRecyclerAdapter: WalksRecyclerAdapter) {
        walksRecyclerAdapter.onHolderViewClickListener = { data ->
            _walksViewModel.setSelectedData(selectedData = data)
            val action =
                WalksFragmentDirections.actionWalksFragmentToWalkInfoFragment(data.routes.toTypedArray())
            findNavController().navigate(action)
        }
    }
}