package com.utad.baccus.controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
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
	
	private Wine mWine = null;
	private ImageView mWineImage = null;
	private int mOptionSelected;
	
	public static final String WINE = "WINE";
	public static final String CURRENT_SCALETYPE = "CURRENT_SCALETYPE";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mWine = (Wine) getIntent().getSerializableExtra(WINE);
        
        TextView txt_wineName = (TextView) findViewById(R.id.wine_name);
        txt_wineName.setText(mWine.getName());
        
        TextView txt_wineType = (TextView) findViewById(R.id.wine_type);
        txt_wineType.setText(mWine.getType());
        
        TextView txt_wineHouse = (TextView) findViewById(R.id.winehouse);
        txt_wineHouse.setText(mWine.getWineHouse());
        
        TextView txt_wineNotes = (TextView) findViewById(R.id.wine_notes);
        txt_wineNotes.setText(mWine.getNotes());
        
        mWineImage = (ImageView)findViewById(R.id.wine_image);
        mWineImage.setImageResource(mWine.getImage());
        
        // Creating grape texts
        LinearLayout grapesContainer = (LinearLayout)findViewById(R.id.grapes);
        for (String grape : mWine.getGrapes()) {
        	TextView text = new TextView(this);
        	text.setText(grape);
        	LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        			LinearLayout.LayoutParams.MATCH_PARENT,
        			LinearLayout.LayoutParams.WRAP_CONTENT);
        	text.setLayoutParams(params);
        	grapesContainer.addView(text);
        }
        
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating);
        ratingBar.setProgress(mWine.getRating());
        
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
		if (optionSelected != -1 && optionSelected == SettingsActivity.OPTION_NORMAL) {
			mWineImage.setScaleType(ScaleType.FIT_CENTER);
		}
		else if (optionSelected != -1 && optionSelected == SettingsActivity.OPTION_FIT) {
			mWineImage.setScaleType(ScaleType.FIT_XY);
		}
	}
}
