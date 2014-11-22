package com.utad.baccus.controller.adapter;

import com.utad.baccus.controller.fragment.WineFragment;
import com.utad.baccus.model.Winehouse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class WineFragmentAdapter extends FragmentPagerAdapter {

	private Winehouse mWines = null;
	
	public WineFragmentAdapter(FragmentManager fm) {
		super(fm);
		mWines = Winehouse.getInstance();
	}
	
	@Override
	public Fragment getItem(int index) {
		WineFragment fragment = new WineFragment();
		
		Bundle arguments = new Bundle();
		arguments.putSerializable(WineFragment.ARG_WINE, mWines.getWine(index));
		fragment.setArguments(arguments);
		
		return fragment;
	}

	@Override
	public int getCount() {
		return mWines.getWineCount();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		super.getPageTitle(position);
		return mWines.getWine(position).getName();
	}
	
}
