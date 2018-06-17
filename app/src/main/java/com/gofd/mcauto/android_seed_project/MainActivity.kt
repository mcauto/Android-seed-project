package com.gofd.mcauto.android_seed_project

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.ionicons_typeface_library.Ionicons
import devlight.io.library.ntb.NavigationTabBar
import devlight.io.library.ntb.NavigationTabBar.Model.Builder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  private lateinit var viewPagerAdapter: MainTabPagerAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initUI()
  }

  private fun initUI() {
    initPages()
    initNavigationBar()
  }

  private fun initPages() {
    viewPagerAdapter = MainTabPagerAdapter(supportFragmentManager)
    viewPagerAdapter.addFragment(SampleFragment().newInstance())
    viewPagerAdapter.addFragment(Fragment())
    viewPager.adapter = viewPagerAdapter
  }

  private fun initNavigationBar() {
    val activeColor = resources.getColor(R.color.tab_active)
    val inactiveColor = resources.getColor(R.color.tab_inactive)
    navTab.bgColor = Color.WHITE
    navTab.activeColor = activeColor
    navTab.inactiveColor = inactiveColor
    navTab.setIsTitled(true)

    navTab.models = initNavTabs()
    navTab.setViewPager(viewPager)
    navTab.isBehaviorEnabled = true
    navTab.badgeSize = 20f
    navTab.bringToFront()
  }

  private fun initNavTabs(): ArrayList<NavigationTabBar.Model> {
    val tabs: ArrayList<NavigationTabBar.Model> = ArrayList()
    val listIcon: Drawable = IconicsDrawable(this, Ionicons.Icon.ion_ios_folder_outline).sizeDp(24)
    val settingIcon: Drawable = IconicsDrawable(this).icon(FontAwesome.Icon.faw_cog).sizeDp(24)
    val listTitle = getString(R.string.main_nav_first)
    val cogTitle = getString(R.string.main_nav_second)
    val listTab = Builder(listIcon, Color.WHITE).title(listTitle).build()
    val settingTab = Builder(settingIcon, Color.WHITE).title(cogTitle).build()

    tabs.add(listTab)
    tabs.add(settingTab)

    return tabs
  }
}
