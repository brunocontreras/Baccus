package com.utad.baccus.controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.utad.baccus.R;
import com.utad.baccus.model.Wine;


public class WineActivity extends ActionBarActivity {
	
	private int mOptionSelected;
	
	public static final String EXTRA_WINE = "WINE";
	public static final String CURRENT_SCALETYPE = "CURRENT_SCALETYPE";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_fragment_container);
        
        WineFragment fragment = new WineFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable(WineFragment.ARG_WINE, getIntent().getSerializableExtra(EXTRA_WINE));
        fragment.setArguments(arguments);
        
        FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
        trx.add(R.id.wine_fragment_placeholder, fragment);
        trx.commit();
        
        // Carga la web del modelo
    	if (savedInstanceState != null && savedInstanceState.containsKey(CURRENT_SCALETYPE)) {
        	mOptionSelected = savedInstanceState.getInt(CURRENT_SCALETYPE);
        	ChangeScaleType(mOptionSelected);
        }
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean defaultValue = super.onOptionsItemSelected(item);
		
		if (item.getItemId() == R.id.action_settings) {
			Intent settingsIntent = new Intent(this, SettingsActivity.class);
			startActivityForResult(settingsIntent, SettingsActivity.REQUEST_SELECT_SCALE_TYPE);
			return true;
		}
		else {
			return defaultValue;
		}
	}
	
    @Override
	protected void onActivityResult(int requestCode, int result, Intent intent) {
		super.onActivityResult(requestCode, result, intent);
		
		if (requestCode == SettingsActivity.REQUEST_SELECT_SCALE_TYPE && result == RESULT_OK) {
			mOptionSelected = intent.getIntExtra(SettingsActivity.OPTION_SELECTED, -1); 
			ChangeScaleType(mOptionSelected);
		}
	}

	public void showWeb(View v) {
    	if (v.getId() == R.id.btn_gotoweb) {
    		Intent webIntent = new Intent(this, WebActivity.class);
    		Wine mWine = (Wine) getIntent().getSerializableExtra(EXTRA_WINE); 
    		webIntent.putExtra(WebActivity.EXTRA_URL, mWine.getURL());
    		startActivity(webIntent);
    	}
    }

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(CURRENT_SCALETYPE, mOptionSelected);
	}
	
	public void ChangeScaleType(int optionSelected) {
		ImageView mWineImage = (ImageView) findViewById(R.id.wine_image);
		
		if (optionSelected != -1 && optionSelected == SettingsActivity.OPTION_NORMAL) {
			mWineImage.setScaleType(ScaleType.FIT_CENTER);
		}
		else if (optionSelected != -1 && optionSelected == SettingsActivity.OPTION_FIT) {
			mWineImage.setScaleType(ScaleType.FIT_XY);
		}
	}
}
