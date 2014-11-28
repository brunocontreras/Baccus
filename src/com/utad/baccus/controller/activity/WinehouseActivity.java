package com.utad.baccus.controller.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import com.utad.baccus.R;
import com.utad.baccus.controller.fragment.WinehouseFragment;

public class WinehouseActivity extends ActionBarActivity {

	public static final String EXTRA_WINE_INDEX = "WINE_INDEX";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_container);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		FragmentManager manager = getSupportFragmentManager();
		if (manager.findFragmentById(R.id.fragment_placeholder) == null) {
			Fragment fragment = new WinehouseFragment();
			Bundle arguments = new Bundle();
			arguments.putSerializable(WinehouseFragment.ARG_WINE_INDEX, getIntent().getIntExtra(EXTRA_WINE_INDEX, 0));
			fragment.setArguments(arguments);
			
			manager
				.beginTransaction()
				.add(R.id.fragment_placeholder, fragment)
				.commit();
		}
	}

	
	
	
//	private WineFragmentAdapter mAdapter = null;
//	private ActionBar mActionBar = null;
//	private ViewPager mPager = null;
//	
//	private static final int MENU_PREV = 0;
//	private static final int MENU_NEXT = 1;
//	
//	public static final String EXTRA_WINE_INDEX = "WINE_INDEX";
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_winehouse);
//		
//		mPager = (ViewPager) findViewById(R.id.pager);
//		mAdapter = new WineFragmentAdapter(getSupportFragmentManager());
//		
//		mPager.setAdapter(mAdapter);
//		mPager.setOnPageChangeListener(new OnPageChangeListener() {
//			
//			@Override
//			public void onPageSelected(int index) {
//				updateActionBar(index);
//			}
//			
//			@Override
//			public void onPageScrolled(int arg0, float arg1, int arg2) { }
//			
//			@Override
//			public void onPageScrollStateChanged(int arg0) { }
//		});
//
//	mActionBar = getSupportActionBar();
//	mActionBar.setDisplayHomeAsUpEnabled(true);
//	mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//	for (int i = 0; i < mAdapter.getCount(); i++) {
//		Tab tab = mActionBar.newTab();
//		tab.setText(mAdapter.getPageTitle(i));
//		tab.setTabListener(new TabListener() {
//			
//			@Override
//			public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {}
//			
//			@Override
//			public void onTabSelected(Tab tab, FragmentTransaction trx) {
//				mPager.setCurrentItem(tab.getPosition());
//			}
//			
//			@Override
//			public void onTabReselected(Tab arg0, FragmentTransaction arg1) {}
//		});
//		mActionBar.addTab(tab);
//	}
//	
//		int position = getIntent().getIntExtra(EXTRA_WINE_INDEX, 0);
//		
//		updateActionBar(position);
//	}
//	
//	public void updateActionBar(int index) {
//		mActionBar.setSubtitle(mAdapter.getPageTitle(index));
//		mActionBar.setIcon(mAdapter.getImage(index));
//		mActionBar.setSelectedNavigationItem(index);
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		super.onCreateOptionsMenu(menu);
//
//		MenuItem prev = menu.add(Menu.NONE, MENU_PREV, 0, R.string.prev);
//		MenuItemCompat.setShowAsAction(prev, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
//		
//		MenuItem next = menu.add(Menu.NONE, MENU_NEXT, 1, R.string.next);
//		MenuItemCompat.setShowAsAction(next, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
//		
//		int index = mActionBar.getSelectedNavigationIndex();
//		next.setEnabled(index < mAdapter.getCount() - 1);
//		prev.setEnabled(index > 0);
//		
//		return true;
//	}
//
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean defaultValue = super.onOptionsItemSelected(item);		
		
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				return true;
				
			default:
				return defaultValue;
		}
	}	
	
}
