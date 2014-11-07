package com.utad.baccus;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import com.utad.baccus.model.Wine;


public class MainActivity extends ActionBarActivity {
	
	private Wine vegabal = null;
	private Wine bembibre = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        vegabal = new Wine("Vegabal", "Tinto", "http://www.vegabal.com/es/", "Miguel Calatayud", R.drawable.vegabal, 4);
        vegabal.addGrape("Mencía");
        
        bembibre = new Wine("Bembibre", "Tinto", "http://www.dominiodetares.com/index.php/es/", "Dominio de Tares", R.drawable.bembibre, 5);
        bembibre.addGrape("Mencía");
    }
    
    public void changeImage(View v){
    	ImageView wineImage = (ImageView) findViewById(R.id.wine_image);
    	
    	if (v.getId() == R.id.btn_Vegabal) {
    		wineImage.setImageResource(vegabal.getImage());
    	}
    	else if (v.getId() == R.id.btn_Bembibre) {
    		wineImage.setImageResource(bembibre.getImage());
    	}
    }
}
