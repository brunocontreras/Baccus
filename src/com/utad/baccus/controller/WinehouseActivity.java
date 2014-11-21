package com.utad.baccus.controller;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.utad.baccus.R;
import com.utad.baccus.model.Wine;
import com.utad.baccus.model.Winehouse;

public class WinehouseActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_winehouse);
		
		TabHost tabHost = getTabHost();
		
		Winehouse winehouse = Winehouse.getInstance();
		for (int i = 0; i < winehouse.getWineCount(); i++) {
			Intent wineIntent = new Intent(this, WineActivity.class);
			Wine currentWine = winehouse.getWine(i);
			wineIntent.putExtra(WineActivity.EXTRA_WINE, currentWine);
			TabSpec tab = tabHost.newTabSpec(currentWine.getName());
			tab.setIndicator(currentWine.getName());
			tab.setContent(wineIntent);
			
			tabHost.addTab(tab);
		}
	}
}
