package com.utad.baccus.controller.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

import com.utad.baccus.R;
import com.utad.baccus.controller.fragment.WineListFragment;
import com.utad.baccus.controller.fragment.WineListFragment.OnWineSelectedListener;
import com.utad.baccus.controller.fragment.WinehouseFragment;
import com.utad.baccus.model.Constants;

public class WineListActivity extends ActionBarActivity implements OnWineSelectedListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wine_list);
		
		FragmentManager manager = getSupportFragmentManager();
		
        if (findViewById(R.id.list_fragment) != null) { 
        	WineListFragment wineListFragment = (WineListFragment) manager.findFragmentById(R.id.list_fragment);
        	if (wineListFragment == null) {
        		wineListFragment = new WineListFragment();
        		manager.beginTransaction()
        			.add(R.id.list_fragment, wineListFragment)
        			.commit();
        	}
        	wineListFragment.setOnWineSelectedListener(this);
        }
        
        if (findViewById(R.id.winehouse_fragment) != null) {
	        if (manager.findFragmentById(R.id.winehouse_fragment) == null) {
	        	WinehouseFragment fragment = new WinehouseFragment();
	        	
	        	Bundle arguments = new Bundle();
	        	SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
	        	arguments.putInt(WinehouseFragment.ARG_WINE_INDEX, pref.getInt(Constants.PREF_LAST_WINE, 0));
	        	fragment.setArguments(arguments);
	        	
	        	manager.beginTransaction()
	        		.add(R.id.winehouse_fragment, fragment)
	        		.commit();
	        }
        }
	}

	@Override
	public void onWineSelected(int position) {
		if (findViewById(R.id.winehouse_fragment) != null) {
			FragmentManager manager = getSupportFragmentManager();
			WinehouseFragment fragment = (WinehouseFragment) manager.findFragmentById(R.id.winehouse_fragment);
    		fragment.showWine(position);
		}
		else {
			Intent intent = new Intent(this, WinehouseActivity.class);
			intent.putExtra(WinehouseActivity.EXTRA_WINE_INDEX, position);
			startActivity(intent);
		}
	}

	
}
