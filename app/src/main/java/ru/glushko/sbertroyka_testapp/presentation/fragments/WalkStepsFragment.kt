package ru.glushko.sbertroyka_testapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import ru.glushko.sbertroyka_testapp.databinding.FragmentWalkStepsBinding
import ru.glushko.sbertroyka_testapp.domain.model.Route
import ru.glushko.sbertroyka_testapp.presentation.viewmodels.MainViewModel
import ru.glushko.sbertroyka_testapp.presentation.viewutils.viewPagerAdapters.StepViewPagerAdapter

class WalkStepsFragment : Fragment() {

    private lateinit var _walkStepsFBinding: FragmentWalkStepsBinding
    private val _mainViewModel: MainViewModel by sharedViewModel()
    private lateinit var _localRoutesList: List<Route>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _walkStepsFBinding = FragmentWalkStepsBinding.inflate(inflater, container, false)

        val countOfSteps = arguments?.getInt(ARG_PARAM1)

        val pagerAdapter = StepViewPagerAdapter(this, countOfSteps!!)
        _walkStepsFBinding.walkStepsViewpager.adapter = pagerAdapter

        _walkStepsFBinding.walkStepsViewpager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                _walkStepsFBinding.stepTitle.text = _localRoutesList[position].title
                if (position == countOfSteps - 1)
                    Toast.makeText(requireContext(), "Вы дошли до конца!", Toast.LENGTH_SHORT)
                        .show() //TODO: Сделать диалог.
                super.onPageSelected(position)
            }
        })

        _walkStepsFBinding.pageNext.setOnClickListener {
            onNext()
        }

        _walkStepsFBinding.pageBack.setOnClickListener {
            onBack()
        }

        return _walkStepsFBinding.root
    }

    override fun onStart() {
        super.onStart()
        _mainViewModel.selectedWalkRoutes.observe(viewLifecycleOwner) {
            _localRoutesList = it
        }

    }

    override fun onResume() {
        super.onResume()
        if (!_localRoutesList.isNullOrEmpty())
            _walkStepsFBinding.stepTitle.text =
                _localRoutesList[_walkStepsFBinding.walkStepsViewpager.currentItem].title
        else
            _walkStepsFBinding.stepTitle.text = "Здесь ничего нет!"
    }

    private fun onNext() {
        _walkStepsFBinding.walkProgress.progress++
        _walkStepsFBinding.walkStepsViewpager.currentItem++
    }

    private fun onBack() {
        _walkStepsFBinding.walkProgress.progress--
        _walkStepsFBinding.walkStepsViewpager.currentItem--
    }

    companion object {
        private const val ARG_PARAM1 = "param1"

        @JvmStatic
        fun newInstance(count: Int) =
            WalkStepsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, count)
                }
            }
    }
}