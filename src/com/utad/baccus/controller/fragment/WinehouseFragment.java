package com.utad.baccus.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.utad.baccus.R;
import com.utad.baccus.controller.adapter.WineFragmentAdapter;

public class WinehouseFragment extends Fragment {

	private WineFragmentAdapter mAdapter = null;
	private ActionBar mActionBar = null;
	private ViewPager mPager = null;
	
	private static final int MENU_PREV = 0;
	private static final int MENU_NEXT = 1;
	
	public static final String ARG_WINE_INDEX = "WINE_INDEX";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View root = inflater.inflate(R.layout.fragment_winehouse, container, false);
		
		mPager = (ViewPager) root.findViewById(R.id.pager);
		mAdapter = new WineFragmentAdapter(getFragmentManager());
		
		mPager.setAdapter(mAdapter);
		mPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int index) {
				updateActionBar(index);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) { }
			
			@Override
			public void onPageScrollStateChanged(int arg0) { }
		});

		mActionBar = ((ActionBarActivity)getActivity()).getSupportActionBar();
		
		int position = getArguments().getInt(ARG_WINE_INDEX, 0);
		showWine(position);
		
		return root;
	}
	
	public void updateActionBar(int index) {
		mActionBar.setSubtitle(mAdapter.getPageTitle(index));
	}
	
	public void showWine(int index) {
		updateActionBar(index);
		mPager.setCurrentItem(index);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

		MenuItem prev = menu.add(Menu.NONE, MENU_PREV, 0, R.string.prev);
		MenuItemCompat.setShowAsAction(prev, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
		
		MenuItem next = menu.add(Menu.NONE, MENU_NEXT, 1, R.string.next);
		MenuItemCompat.setShowAsAction(next, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
		
		int index = mPager.getCurrentItem();
		next.setEnabled(index < mAdapter.getCount() - 1);
		prev.setEnabled(index > 0);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean defaultValue = super.onOptionsItemSelected(item);		
		
		switch (item.getItemId()) {

			case MENU_PREV:
				if (mPager.getCurrentItem() > 0) {
					int wineIndex = mPager.getCurrentItem() - 1;
					showWine(wineIndex);
				}
				return true;
	
			case MENU_NEXT:
				if (mPager.getCurrentItem() < mAdapter.getCount() - 1) {
					int wineIndex = mPager.getCurrentItem() + 1;
					showWine(wineIndex);
				}
				return true;
				
			default:
				return defaultValue;
		}
	}	
}
