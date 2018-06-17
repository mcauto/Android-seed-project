package com.gofd.mcauto.android_seed_project


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


class MainTabPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
  private var fragmentList: MutableList<Fragment> = ArrayList()

  override fun getCount(): Int {
    return fragmentList.size
  }

  override fun getItem(position: Int): Fragment {
    return fragmentList[position]
  }

  fun setFragmentList(fragmentList: MutableList<Fragment>) {
    this.fragmentList = fragmentList
    notifyDataSetChanged()
  }

  fun addFragment(fragment: Fragment) {
    fragmentList.add(fragment)
    notifyDataSetChanged()
  }

}