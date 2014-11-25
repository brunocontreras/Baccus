package com.utad.baccus.controller.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.utad.baccus.R;
import com.utad.baccus.controller.fragment.WebFragment;
import com.utad.baccus.model.Wine;

public class WebActivity extends ActionBarActivity {

	public static final String EXTRA_URL = "URL";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_container);

		FragmentManager manager = getSupportFragmentManager();
        
        if (manager.findFragmentById(R.id.fragment_placeholder) == null) {
			
        	WebFragment fragment = new WebFragment();
			Bundle arguments = new Bundle();
			arguments.putString(fragment.ARG_URL, getIntent().getStringExtra(EXTRA_URL));
			fragment.setArguments(arguments);
			
			manager
				.beginTransaction()
				.add(R.id.fragment_placeholder, fragment)
				.commit();
        }
        
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean defaultValue = super.onOptionsItemSelected(item);
		
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		else {
			return defaultValue;
		}
	}
	
	
	
}
