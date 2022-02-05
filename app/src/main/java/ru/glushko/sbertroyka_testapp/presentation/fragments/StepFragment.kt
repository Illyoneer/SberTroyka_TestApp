package ru.glushko.sbertroyka_testapp.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import ru.glushko.sbertroyka_testapp.databinding.FragmentStepBinding
import ru.glushko.sbertroyka_testapp.domain.model.Route
import ru.glushko.sbertroyka_testapp.domain.model.TextContent
import ru.glushko.sbertroyka_testapp.presentation.viewmodels.MainViewModel
import ru.glushko.sbertroyka_testapp.presentation.viewutils.recyclerAdapters.galery.GalleryRecyclerAdapter

class StepFragment : Fragment() {

    private var param1: String? = null

    private lateinit var _stepFBinding: FragmentStepBinding
    private lateinit var _localRouteTextContent: List<TextContent>
    private lateinit var _localRoutes: List<Route>
    private val _mainViewModel: MainViewModel by sharedViewModel()
    private val _galleryRecyclerAdapter = GalleryRecyclerAdapter()
    private var contentValue: String = "Здесь нет описания."
    private var _positionNumber = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _stepFBinding = FragmentStepBinding.inflate(inflater, container, false)

        _stepFBinding.galleryRecyclerView.adapter = _galleryRecyclerAdapter

        if (arguments?.getInt(ARG_PARAM1) != null)
            _positionNumber = arguments?.getInt(ARG_PARAM1)!!

        return _stepFBinding.root
    }

    override fun onStart() {
        super.onStart()
        _mainViewModel.selectedWalkRoutes.observe(viewLifecycleOwner) {
            _localRoutes = it
            _localRouteTextContent = it[_positionNumber].textContents
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        if (_localRouteTextContent.isNotEmpty() && _stepFBinding.textBody.text.isEmpty())
            _localRouteTextContent.onEach { content ->
                when (content.type) {
                    "TEXT_TITLE" -> _stepFBinding.textTitle.text = content.value
                    "TEXT_CAPTION" -> _stepFBinding.textCaption.text =
                        "${_stepFBinding.textCaption.text}" + "\n${content.value}"
                    else -> _stepFBinding.textBody.text =
                        "${_stepFBinding.textBody.text}" + "\n${content.value}"
                }
            }


    }

    companion object {
        private const val ARG_PARAM1 = "param1"

        @JvmStatic
        fun newInstance(position: Int) =
            StepFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, position)
                }
            }
    }
}