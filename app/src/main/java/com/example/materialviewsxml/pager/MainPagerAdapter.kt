package com.example.materialviewsxml.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.materialviewsxml.fragment.ComponentFragment
import com.example.materialviewsxml.fragment.OtherFragment
import com.example.materialviewsxml.fragment.BaseComponentFragment

class MainPagerAdapter(
    fa: FragmentActivity,
) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> BaseComponentFragment()
            1 -> ComponentFragment()
            2 -> OtherFragment()
            else -> BaseComponentFragment()
        }
    }

}