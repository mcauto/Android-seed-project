package com.gofd.mcauto.android_seed_project;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainTabPagerAdapter extends FragmentStatePagerAdapter {
  private List<Fragment> fragmentList = new ArrayList<> ();

  public MainTabPagerAdapter(FragmentManager fragmentManager) {
    super (fragmentManager);
  }

  @Override
  public int getCount() {
    return fragmentList.size ();
  }

  @Override
  public Fragment getItem(int position) {
    return fragmentList.get (position);
  }

  public void setFragmentList(List<Fragment> fragmentList) {
    this.fragmentList = fragmentList;
    notifyDataSetChanged ();
  }

  public void addFragment(Fragment fragment) {
    fragmentList.add (fragment);
    notifyDataSetChanged ();
  }
}