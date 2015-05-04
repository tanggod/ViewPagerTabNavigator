package com.stormintz.viewpagernav;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

public class PageChangeListener implements ViewPager.OnPageChangeListener {

	private ActionBar actionBar;

	public PageChangeListener(ActionBar actionBar) {
		this.actionBar = actionBar;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void onPageSelected(int position) {
		//System.out.println("position:" + position);
		actionBar.setSelectedNavigationItem(position);

	}
}
