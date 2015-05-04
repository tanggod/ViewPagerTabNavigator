package com.stormintz.viewpagernav.view;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyPagerAdapter extends PagerAdapter {
	private ArrayList<View> mViewList;
	private int pagerNum = 0;

	public MyPagerAdapter(ArrayList<View> viewList) {
		mViewList = viewList;
	}

	public int getPagerNum() {
		return pagerNum;
	}

	@Override
	public int getCount() {
		return mViewList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(View arg0, int arg1, Object arg2) {
		if (mViewList.get(arg1) != null) {
			((ViewPager) arg0).removeView(mViewList.get(arg1));
		}
	}

	@Override
	public Object instantiateItem(View arg0, int arg1) {
		try {
			if (mViewList.get(arg1).getParent() == null) {
				((ViewPager) arg0).addView(mViewList.get(arg1), 0);
			} else {
				/*
				 * 很难理解新添加进来的view会自动绑定一个父类，由于一个儿子view不能与两个父类相关， 所以得解绑不这样做否则会产生
				 * viewpager java.lang.IllegalStateException: The specified
				 * child already has a parent. You must call removeView() on the
				 * child's parent first.
				 */
				((ViewGroup) mViewList.get(arg1).getParent())
						.removeView(mViewList.get(arg1));
				((ViewPager) arg0).addView(mViewList.get(arg1), 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pagerNum = arg1;
		}
		return mViewList.get(arg1);
	}

}
