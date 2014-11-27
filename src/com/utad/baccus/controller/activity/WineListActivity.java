package com.utad.baccus.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.internal.widget.AdapterViewCompat.OnItemClickListener;
import android.view.View;
import android.widget.FrameLayout;

import com.utad.baccus.R;
import com.utad.baccus.controller.fragment.WineListFragment;
import com.utad.baccus.controller.fragment.WinehouseFragment;

public class WineListActivity extends ActionBarActivity {

	private WinehouseFragment mWinehouseFragment = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wine_list);
		
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		
        if (findViewById(R.id.list_fragment) != null) { 
        	if (manager.findFragmentById(R.id.list_fragment) == null) {
        		WineListFragment fragment = new WineListFragment();
        		transaction.add(R.id.list_fragment, fragment);
        	}
        }
        
        if (findViewById(R.id.winehouse_fragment) != null) {
	        if (manager.findFragmentById(R.id.winehouse_fragment) == null) {
	        	mWinehouseFragment = new WinehouseFragment();
	        	
	        	Bundle arguments = new Bundle();
	        	arguments.putInt(WinehouseFragment.ARG_WINE_INDEX, 0);
	        	mWinehouseFragment.setArguments(arguments);
	        	
	        	transaction.add(R.id.winehouse_fragment, mWinehouseFragment);
	        }
        }
        
        transaction.commit();
	}

//	@Override
//	public void onItemClick(AdapterViewCompat<?> parent, View view, int position, long id) {
//		
//		if (mWinehouseFragment != null) {
//			Bundle arguments = new Bundle();
//    		arguments.putInt(WinehouseFragment.ARG_WINE_INDEX, 0);
//    		mWinehouseFragment.setArguments(arguments);
//		}
//		else {
//			Intent intent = new Intent(this, WinehouseActivity.class);
//			intent.putExtra(WinehouseActivity.EXTRA_WINE_INDEX, position);
//			startActivity(intent);
//		}
//	}

	
}
