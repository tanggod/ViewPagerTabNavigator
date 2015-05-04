package com.stormintz.viewpagernav.view;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.stormintz.viewpagernav.MyTabListener;
import com.stormintz.viewpagernav.PageChangeListener;
import com.stormintz.viewpagernav.R;

import java.util.ArrayList;

public class ViewMainActivity extends ActionBarActivity {
	private ActionBar actionBar;
	private ArrayList<View> viewList;
	ViewPager viewPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_main);
		initView();
		initActionBar();
		
		viewList = new ArrayList<View>();
		//得到填充器，准备获得对象
		LayoutInflater mLayoutInflater = getLayoutInflater();  
		//给适配器准备好数据，添加进list中
		for (int i = 0; i < 3; i++) {
			TextView tv  = (TextView)(mLayoutInflater.inflate(R.layout.view_item, null))
					.findViewById(R.id.viewItem_textView);
			tv.setText("No "+(i+1));
			viewList.add(tv);
		}	
		viewList.add(mLayoutInflater.inflate(R.layout.view_item, null));//也可以直接用布局做一个视图
		//内容准备好后，设置适配器
		viewPager.setAdapter(new MyPagerAdapter(viewList));
		viewPager.setOnPageChangeListener(new PageChangeListener(getSupportActionBar()));
		
	}

	/**
	 *初始化actionBar和Tab 
	 */
	private void initActionBar() {
		actionBar = getSupportActionBar();
		//设定有Tab
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ActionBar.Tab tab;
		//开始添加Tab
        for (int i = 1; i <= 4; i++) {
            tab = actionBar.newTab();
            tab.setText("Tab " + i);
            tab.setTabListener(new MyTabListener(viewPager));
            actionBar.addTab(tab);
        }
	}
	
	private void initView() {
		viewPager = (ViewPager)findViewById(R.id.viewPager01);
	}



}
