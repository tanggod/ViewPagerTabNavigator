package com.stormintz.viewpagernav.tab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.astuetz.PagerSlidingTabStrip;
import com.stormintz.viewpagernav.R;

public class TabMainActivity extends ActionBarActivity {
	private ChatFragment chatFragment;
	private FoundFragment foundFragment;
	private ContactsFragment contactsFragment;

	/**
	 * PagerSlidingTabStrip的实例
	 */
	private PagerSlidingTabStrip tabs;
	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_main);
		initView();

		//initTabs();  //用代码来设置tab的样式，因为我在xml中已经设置了，所以就不在代码中写了
		viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
		tabs.setViewPager(viewPager);

	}

	/**
	 * @author:Jack Tony
	 * @tips :定义适配器，返回一个fragment对象
	 * @date :2014-7-30
	 */
	public class MyPagerAdapter extends FragmentPagerAdapter {

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		private final String[] titles = { "聊天", "发现", "通讯录" };

		@Override
		public CharSequence getPageTitle(int position) {
			return titles[position];
		}

		@Override
		public int getCount() {
			return titles.length;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				if (chatFragment == null) {
					chatFragment = new ChatFragment();
				}
				return chatFragment;
			case 1:
				if (foundFragment == null) {
					foundFragment = new FoundFragment();
				}
				return foundFragment;
			case 2:
				if (contactsFragment == null) {
					contactsFragment = new ContactsFragment();
				}
				return contactsFragment;
			default:
				return null;
			}
		}

	}

	/**
	 *定义的属性，参考：https://github.com/astuetz/PagerSlidingTabStrip 
	 */
	private void initTabs() {
		/**
		 * 获取当前屏幕的密度
		 */
		DisplayMetrics dm;
		dm = getResources().getDisplayMetrics();
		// 设置Tab是自动填充满屏幕，也就是均分屏幕宽度，每个tab的weight都是一致的	app:pstsShouldExpand="true"
		tabs.setShouldExpand(true);
		// 设置Tab的分割线是透明的 	app:pstsDividerColor="@android:color/transparent"
		tabs.setDividerColor(Color.TRANSPARENT);
		// 设置Tab底部与下面分割的细线的高度	app:pstsUnderlineHeight="1dp"
		tabs.setUnderlineHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 1, dm));
		// 设置Tab 指示器的高度		app:pstsIndicatorHeight="4dp"
		tabs.setIndicatorHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, dm));
		// 设置Tab标题文字的大小		app:pstsTabTextSize="16sp"
		tabs.setTextSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 16, dm));
		// 设置Tab Indicator的颜色		app:pstsIndicatorColor="#45c01a"
		tabs.setIndicatorColor(Color.parseColor("#45c01a"));
		// 设置选中Tab文字的颜色 		app:pstsSelectedTabTextColor="#45c01a"
		tabs.setSelectedTextColor(Color.parseColor("#45c01a"));
		// 取消点击Tab时的背景色		app:pstsTabBackground="0"
		tabs.setTabBackground(0);
	}

	private void initView() {
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		viewPager = (ViewPager) findViewById(R.id.viewPager03);
	}
}
