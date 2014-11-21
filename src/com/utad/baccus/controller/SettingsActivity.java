package com.utad.baccus.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.utad.baccus.R;

public class SettingsActivity extends FragmentActivity {
	
	public static final String OPTION_SELECTED = "OPTION_SELECTED";
	public static final int OPTION_NORMAL = 0;
	public static final int OPTION_FIT = 1;
	public static final int REQUEST_SELECT_SCALE_TYPE = 0;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings_fragment_container);
		
		SettingsFragment fragment = new SettingsFragment();
		
		getSupportFragmentManager()
			.beginTransaction()
			.add(R.id.settings_fragment_placeholder, fragment)
			.commit();
	}
	
	public void cancel(View v) {
		setResult(RESULT_CANCELED);
		finish();
	}
	
	public void save(View v) {
		Intent intent = getIntent();
		RadioGroup mRadios = (RadioGroup) findViewById(R.id.radio_options);
		if (mRadios.getCheckedRadioButtonId() == R.id.radio_normal) {
			intent.putExtra(OPTION_SELECTED, OPTION_NORMAL);
		}
		else {
			intent.putExtra(OPTION_SELECTED, OPTION_FIT);
		}
		setResult(RESULT_OK, intent);
		finish();
	}
}
