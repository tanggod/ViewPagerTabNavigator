package com.stormintz.viewpagernav.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.ViewGroup;

import com.stormintz.viewpagernav.MyTabListener;
import com.stormintz.viewpagernav.PageChangeListener;
import com.stormintz.viewpagernav.R;

/**
 * @author:Jack Tony
 * @tips :出于使用FragmentPagerAdapter 时，Fragment对象会一直存留在内存中.
 *       所以当有大量的显示页时，就不适合用FragmentPagerAdapter了
 *       ，FragmentPagerAdapter适用于只有少数的page情况。
 *       多的话请考虑使用FragmentStatePagerAdapter，当使用FragmentStatePagerAdapter时，
 *       如果Fragment不显示，那么Fragment对象会被销毁，但在回调onDestroy()方法之前
 *       会回调onSaveInstanceState(Bundle outState)方法来保存Fragment的状态，
 *       下次Fragment显示时通过onCreate(Bundle savedInstanceState)把存储的状态值取出来，
 *       FragmentStatePagerAdapter 比较适合页面比较多的情况，像一个页面的ListView
 * @date :2014-7-30
 */
public class FragmentMainActivity extends ActionBarActivity {
	ActionBar actionBar;
	ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		initView();
		initActionBar();
		viewPager.setAdapter(new MyFragmentPagerAdapter(
				getSupportFragmentManager()));
		//下面是用另一种适配器的方式，其实就是换个名字。主要针对的是很多个fragment的情况
		//viewPager.setAdapter(new MyFragmentStaticAdapter(getSupportFragmentManager()));
		viewPager.setOnPageChangeListener(new PageChangeListener(actionBar));
		
	}

	public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
		private int NUM_ITEMS = 4;

		public MyFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = new DummyFragment();
			Bundle args = new Bundle();
			args.putInt(DummyFragment.BUNDLE_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return NUM_ITEMS;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// 这里Destroy的是Fragment的视图层次，并不是Destroy Fragment对象
			super.destroyItem(container, position, object);
			//Log.i("INFO", "Destroy Item " + position);
		}

	}

	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.viewPager02);
	}

	/**
	 * 初始化actionBar和Tab
	 */
	private void initActionBar() {
		actionBar = getSupportActionBar();
		// 设定有Tab
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ActionBar.Tab tab;
		// 开始添加Tab
		for (int i = 1; i <= 4; i++) {
			tab = actionBar.newTab();
			tab.setText("Tab " + i);
			tab.setTabListener(new MyTabListener(viewPager));
			actionBar.addTab(tab);
		}
	}

	public class MyFragmentStaticAdapter extends FragmentStatePagerAdapter {
		private int NUM_ITEMS = 5;

		public MyFragmentStaticAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = new DummyFragment();
			Bundle args = new Bundle();
			args.putInt(DummyFragment.BUNDLE_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return NUM_ITEMS;
		}

	}
}
