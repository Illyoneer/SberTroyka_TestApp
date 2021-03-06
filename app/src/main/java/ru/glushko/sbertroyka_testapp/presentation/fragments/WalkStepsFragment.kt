package ru.glushko.sbertroyka_testapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import ru.glushko.sbertroyka_testapp.databinding.FragmentWalkStepsBinding
import ru.glushko.sbertroyka_testapp.domain.model.Route
import ru.glushko.sbertroyka_testapp.presentation.viewutils.viewPagerAdapters.StepViewPagerAdapter

class WalkStepsFragment : Fragment() {

    private lateinit var _walkStepsFBinding: FragmentWalkStepsBinding
    private lateinit var _localRoutesList: List<Route>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _walkStepsFBinding = FragmentWalkStepsBinding.inflate(inflater, container, false)

        val safeArgs: WalkStepsFragmentArgs by navArgs()

        val countOfSteps = safeArgs.countOfPage
        _localRoutesList = safeArgs.selectedWalkRoutes.toList()

        val pagerAdapter = StepViewPagerAdapter(this, countOfSteps)

        with(_walkStepsFBinding) {

            walkStepsViewpager.adapter = pagerAdapter
            walkProgress.max = countOfSteps - 1

            walkStepsViewpager.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    _walkStepsFBinding.stepTitle.text = _localRoutesList[position].title
                    _walkStepsFBinding.walkProgress.progress = position
                    super.onPageSelected(position)
                }
            })

            stepsCloseButton.setOnClickListener { requireActivity().onBackPressed() }

            pageNext.setOnClickListener { onNext(countOfSteps) }

            pageBack.setOnClickListener { onBack() }
        }
        return _walkStepsFBinding.root
    }

    override fun onResume() {
        super.onResume()
        if (!_localRoutesList.isNullOrEmpty())
            _walkStepsFBinding.stepTitle.text =
                _localRoutesList[_walkStepsFBinding.walkStepsViewpager.currentItem].title
        else
            _walkStepsFBinding.stepTitle.text = "?????????? ???????????? ??????!"
    }

    private fun onNext(position: Int) {
        _walkStepsFBinding.walkStepsViewpager.currentItem++
        if (_walkStepsFBinding.walkStepsViewpager.currentItem == position - 1)
            showCancelWalkDialog()
    }

    private fun onBack() {
        _walkStepsFBinding.walkStepsViewpager.currentItem--
    }

    private fun showCancelWalkDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("???? ?????????????????? ????????????????")
            .setMessage("???? ???????????? ???????????? ?????????????? ???? ?????? ???????????? ?????? ??????.")
            .setCancelable(false)
            .setPositiveButton("?????? ??????") { _, _ ->
                _walkStepsFBinding.walkStepsViewpager.currentItem = 0
            }
            .setNegativeButton("??????????????") { _, _ ->
                requireActivity().onBackPressed()
            }
            .show()
    }

    companion object {
        private const val ARG_PARAM1 = "count"

        @JvmStatic
        fun newInstance(count: Int) =
            WalkStepsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, count)
                }
            }
    }
}