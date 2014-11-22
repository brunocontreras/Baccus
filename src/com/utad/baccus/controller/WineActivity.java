package com.utad.baccus.controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
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
	
	public static final String EXTRA_WINE = "WINE";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_fragment_container);
        
        FragmentManager manager = getSupportFragmentManager();
        
        if (manager.findFragmentById(R.id.wine_fragment_placeholder) == null) {
	        WineFragment fragment = new WineFragment();
	        Bundle arguments = new Bundle();
	        arguments.putSerializable(WineFragment.ARG_WINE, getIntent().getSerializableExtra(EXTRA_WINE));
	        fragment.setArguments(arguments);
	        
	        manager
	        	.beginTransaction()
	        	.add(R.id.wine_fragment_placeholder, fragment)
	        	.commit();
        }
    }
}
