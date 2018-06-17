package com.gofd.mcauto.android_seed_project;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.ionicons_typeface_library.Ionicons;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import devlight.io.library.ntb.NavigationTabBar;

public class MainActivity extends AppCompatActivity {
  @BindView(R.id.ntb_horizontal)
  NavigationTabBar navTab;
  private ViewPager viewPager;
  private MainTabPagerAdapter viewPagerAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_main);
    ButterKnife.bind (this);
    initUI ();
  }

  private void initUI() {
    viewPager = findViewById (R.id.vp_horizontal_ntb);
    viewPagerAdapter = new MainTabPagerAdapter (getSupportFragmentManager ());
    initPages ();
    viewPager.setAdapter (viewPagerAdapter);
    initNavigationBar ();
  }

  private void initPages() {
    viewPagerAdapter.addFragment (SampleFragment.newInstance ());
    viewPagerAdapter.addFragment (new Fragment ());
  }

  private void initNavigationBar() {

    int activeColor = getResources ().getColor (R.color.tab_active);
    int inactiveColor = getResources ().getColor (R.color.tab_inactive);

    navTab.setBgColor (Color.WHITE);
    navTab.setActiveColor (activeColor);
    navTab.setInactiveColor (inactiveColor);
    navTab.setIsTitled (true);

    final ArrayList<NavigationTabBar.Model> models = new ArrayList<> ();

    Drawable iList = new IconicsDrawable (this, Ionicons.Icon.ion_ios_folder_outline).sizeDp (24);
    Drawable iCog = new IconicsDrawable (this).icon (FontAwesome.Icon.faw_cog).sizeDp (24);
    String modelBgColor = "#ffffff";
    models.add (
            new NavigationTabBar.Model.Builder (
                    iList,
                    Color.parseColor (modelBgColor))
                    .title (getString (R.string.main_nav_first))
                    .build ()
    );
    models.add (
            new NavigationTabBar.Model.Builder (
                    iCog,
                    Color.parseColor (modelBgColor))
                    .title (getString (R.string.main_nav_second))
                    .build ()
    );


    navTab.setModels (models);
    navTab.setViewPager (viewPager, 0);

    navTab.setBehaviorEnabled (true);
    navTab.setBadgeSize (20);

    navTab.setOnTabBarSelectedIndexListener (new NavigationTabBar.OnTabBarSelectedIndexListener () {
      @Override
      public void onStartTabSelected(final NavigationTabBar.Model model, final int index) {

      }

      @Override
      public void onEndTabSelected(final NavigationTabBar.Model model, final int index) {

      }
    });

    navTab.setOnPageChangeListener (new ViewPager.OnPageChangeListener () {
      @Override
      public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

      }

      @Override
      public void onPageSelected(final int position) {

      }

      @Override
      public void onPageScrollStateChanged(final int state) {

      }
    });
    navTab.bringToFront ();
  }
}