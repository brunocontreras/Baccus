package com.utad.baccus.controller.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.widget.TabHost.TabSpec;

import com.utad.baccus.R;
import com.utad.baccus.controller.adapter.WineFragmentAdapter;
import com.utad.baccus.model.Wine;
import com.utad.baccus.model.Winehouse;

public class WinehouseActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_winehouse);
		
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(new WineFragmentAdapter(getSupportFragmentManager()));
	}
}
