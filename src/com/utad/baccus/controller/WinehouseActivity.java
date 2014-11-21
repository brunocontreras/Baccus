package com.utad.baccus.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.widget.TabHost.TabSpec;

import com.utad.baccus.R;
import com.utad.baccus.model.Wine;
import com.utad.baccus.model.Winehouse;

public class WinehouseActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_winehouse);
		
		FragmentTabHost tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		tabHost.setup(this,  getSupportFragmentManager(), android.R.id.tabcontent);
		
		Winehouse winehouse = Winehouse.getInstance();
		for (int i = 0; i < winehouse.getWineCount(); i++) {

			Wine currentWine = winehouse.getWine(i);
			
			Bundle arguments = new Bundle();
			arguments.putSerializable(WineFragment.ARG_WINE, currentWine);
			
			TabSpec tab = tabHost.newTabSpec(currentWine.getName());
			tab.setIndicator(currentWine.getName());
			
			tabHost.addTab(tab, WineFragment.class, arguments);
		}
	}
}
