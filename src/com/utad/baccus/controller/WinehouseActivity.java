package com.utad.baccus.controller;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.utad.baccus.R;
import com.utad.baccus.model.Wine;
import com.utad.baccus.model.Wines;

public class WinehouseActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_winehouse);
		
		TabHost tabHost = getTabHost();
		
		Wines wines = new Wines();

		for (Wine wine : wines.getList()) {
			
			Intent intent = new Intent(this, WineActivity.class);
			intent.putExtra(WineActivity.WINE, wine);
			TabSpec tab = tabHost.newTabSpec(wine.getName());
			tab.setIndicator(wine.getName());
			tab.setContent(intent);
			
			tabHost.addTab(tab);
			
		}
		
		
//		Intent vegavalIntent = new Intent(this, WineActivity.class);
//		vegavalIntent.putExtra(WineActivity.WINE, vegaval);
//		TabSpec tabVegaval = tabHost.newTabSpec("Vegaval");
//		tabVegaval.setIndicator("Vegaval");
//		tabVegaval.setContent(vegavalIntent);
		
//		Intent bembibreIntent = new Intent(this, WineActivity.class);
//		bembibreIntent.putExtra(WineActivity.WINE, bembibre);
//		TabSpec tabBembibre = tabHost.newTabSpec("Bembibre");
//		tabBembibre.setIndicator("Bembibre");
//		tabBembibre.setContent(bembibreIntent);
		
//		tabHost.addTab(tabVegaval);
//		tabHost.addTab(tabBembibre);
	}

}
