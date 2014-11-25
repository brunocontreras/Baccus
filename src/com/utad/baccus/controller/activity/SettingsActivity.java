package com.utad.baccus.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.RadioGroup;

import com.utad.baccus.R;
import com.utad.baccus.controller.fragment.SettingsFragment;

public class SettingsActivity extends FragmentActivity {
	
	public static final int REQUEST_SELECT_SCALE_TYPE = 0;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_container);
		
		FragmentManager manager = getSupportFragmentManager();
        
        if (manager.findFragmentById(R.id.fragment_placeholder) == null) {
			SettingsFragment fragment = new SettingsFragment();
			
			manager
				.beginTransaction()
				.add(R.id.fragment_placeholder, fragment)
				.commit();
        }
	}
}
