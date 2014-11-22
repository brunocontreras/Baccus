package com.utad.baccus.controller.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;

import com.utad.baccus.R;
import com.utad.baccus.controller.adapter.WineFragmentAdapter;

public class WinehouseActivity extends ActionBarActivity {

	private WineFragmentAdapter mAdapter = null;
	private ActionBar mActionBar = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_winehouse);
		
		final ViewPager pager = (ViewPager) findViewById(R.id.pager);
		
		mAdapter = new WineFragmentAdapter(getSupportFragmentManager());
		mActionBar = getSupportActionBar();
		
		pager.setAdapter(mAdapter);
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int index) {
				updateActionBar(index);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) { }
			
			@Override
			public void onPageScrollStateChanged(int arg0) { }
		});
		
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		for (int i = 0; i < mAdapter.getCount(); i++) {
			Tab tab = mActionBar.newTab();
			tab.setText(mAdapter.getPageTitle(i));
			tab.setTabListener(new TabListener() {
				
				@Override
				public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {}
				
				@Override
				public void onTabSelected(Tab tab, FragmentTransaction trx) {
					pager.setCurrentItem(tab.getPosition());
				}
				
				@Override
				public void onTabReselected(Tab arg0, FragmentTransaction arg1) {}
			});
			mActionBar.addTab(tab);
		}
		
		updateActionBar(0);
	}
	
	public void updateActionBar(int index) {
		mActionBar.setSubtitle(mAdapter.getPageTitle(index));
		mActionBar.setIcon(mAdapter.getImage(index));
		mActionBar.setSelectedNavigationItem(index);
	}
}
