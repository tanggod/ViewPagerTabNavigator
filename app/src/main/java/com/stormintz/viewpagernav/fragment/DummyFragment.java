package com.stormintz.viewpagernav.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DummyFragment extends Fragment {

	public static final String BUNDLE_SECTION_NUMBER = "section_number";

	// 该返回值就是这个Fragment显示的view组件
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		TextView textView = new TextView(getActivity());
		textView.setGravity(Gravity.CENTER);
		// 获取创建该Fragment时传入的参数的Bundle
		Bundle bundle = getArguments();
		textView.setText("Fragment 0" + bundle.getInt(BUNDLE_SECTION_NUMBER));
		textView.setTextSize(50);
		return textView;
	}
}
