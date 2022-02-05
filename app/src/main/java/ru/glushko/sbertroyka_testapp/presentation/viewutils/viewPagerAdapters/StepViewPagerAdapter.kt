package ru.glushko.sbertroyka_testapp.presentation.viewutils.viewPagerAdapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.glushko.sbertroyka_testapp.presentation.fragments.StepFragment

class StepViewPagerAdapter(fragment: Fragment, private val count: Int) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return count
    }

    override fun createFragment(position: Int): Fragment {
        return StepFragment.newInstance(position)
    }
}