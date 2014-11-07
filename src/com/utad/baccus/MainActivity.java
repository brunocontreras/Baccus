package com.utad.baccus;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import com.utad.baccus.model.Wine;


public class MainActivity extends ActionBarActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void changeImage(View v){
    	ImageView wineImage = (ImageView) findViewById(R.id.wine_image);
    	
    	if (v.getId() == R.id.btn_Vegabal) {
    		wineImage.setImageResource(R.drawable.vegabal);
    	}
    	else if (v.getId() == R.id.btn_Bembibre) {
    		wineImage.setImageResource(R.drawable.bembibre);
    	}
    }
}
