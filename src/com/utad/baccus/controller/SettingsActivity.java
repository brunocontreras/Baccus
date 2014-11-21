package com.utad.baccus.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.utad.baccus.R;

public class SettingsActivity extends FragmentActivity {
	
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
}
