package com.utad.baccus.controller;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.utad.baccus.R;
import com.utad.baccus.model.Wine;

public class WebActivity extends ActionBarActivity {

//	
//	
	public static final String EXTRA_URL = "URL";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_fragment_container);

		WebFragment fragment = new WebFragment();
		Bundle arguments = new Bundle();
		arguments.putString(fragment.ARG_URL, getIntent().getStringExtra(EXTRA_URL));
		fragment.setArguments(arguments);
		
		getSupportFragmentManager()
			.beginTransaction()
			.add(R.id.web_fragment_placeholder, fragment)
			.commit();
	}
	
}
