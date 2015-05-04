package com.stormintz.viewpagernav;


import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;

/**
 * @author:Jack Tony
 * @tips  :设置tab的监听器，控制viewpager的显示
 * @date  :2014-7-30
 */
public class MyTabListener implements TabListener {
	ViewPager viewPager;
	public MyTabListener(ViewPager viewPager) {
		this.viewPager =viewPager;
	}

	@Override
	public void onTabReselected(ActionBar.Tab arg0, FragmentTransaction arg1) {
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		if (viewPager != null && viewPager.getCurrentItem() != tab.getPosition()){
			viewPager.setCurrentItem(tab.getPosition());
		}
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		
	}
	
}