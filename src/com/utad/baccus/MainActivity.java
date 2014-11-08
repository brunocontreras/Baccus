package com.utad.baccus;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.utad.baccus.model.Wine;


public class MainActivity extends ActionBarActivity {
	
	private Wine vegaval = null;
//	private Wine bembibre = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        vegaval = new Wine("Vegaval", "Tinto", "http://www.vegaval.com/es/", "Miguel Calatayud", R.drawable.vegaval, 4, "Lorem fistrum pupita pupita a gramenawer me cago en tus muelas sexuarl. Por la gloria de mi madre benemeritaar no te digo trigo por no llamarte Rodrigor diodeno te voy a borrar el cerito. No puedor al ataquerl a wan caballo blanco caballo negroorl llevame al sircoo quietooor pupita de la pradera a peich ahorarr sexuarl. Tiene musho peligro te voy a borrar el cerito a wan tiene musho peligro pupita jarl ahorarr se calle ustée a wan pecador. A peich apetecan me cago en tus muelas al ataquerl. Qué dise usteer condemor me cago en tus muelas de la pradera pupita mamaar no te digo trigo por no llamarte Rodrigor ese hombree tiene musho peligro diodeno te va a hasé pupitaa.");
        vegaval.addGrape("Mencía");
        vegaval.addGrape("Garnacha");
        
//        bembibre = new Wine("Bembibre", "Tinto", "http://www.dominiodetares.com/index.php/es/", "Dominio de Tares", R.drawable.bembibre, 5);
//        bembibre.addGrape("Mencía");
        
        TextView txt_wineName = (TextView) findViewById(R.id.wine_name);
        txt_wineName.setText(vegaval.getName());
        
        TextView txt_wineType = (TextView) findViewById(R.id.wine_type);
        txt_wineType.setText(vegaval.getType());
        
        TextView txt_wineHouse = (TextView) findViewById(R.id.wineHouse);
        txt_wineHouse.setText(vegaval.getWineHouse());
        
        TextView txt_wineNotes = (TextView) findViewById(R.id.wine_notes);
        txt_wineNotes.setText(vegaval.getNotes());
        
        ImageView wineImage = (ImageView)findViewById(R.id.wine_image);
        wineImage.setImageResource(vegaval.getImage());
        
        // Creating grape texts
        LinearLayout grapesContainer = (LinearLayout)findViewById(R.id.grapes);
        for (String grape : vegaval.getGrapes()) {
        	TextView text = new TextView(this);
        	text.setText(grape);
        	LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        			LinearLayout.LayoutParams.MATCH_PARENT,
        			LinearLayout.LayoutParams.WRAP_CONTENT);
        	text.setLayoutParams(params);
        	grapesContainer.addView(text);
        }
        
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating);
        ratingBar.setProgress(vegaval.getRating());
    }
    
//    public void changeImage(View v){
//    	ImageView wineImage = (ImageView) findViewById(R.id.wine_image);
//    	
//    	if (v.getId() == R.id.btn_Vegabal) {
//    		wineImage.setImageResource(vegabal.getImage());
//    	}
//    	else if (v.getId() == R.id.btn_Bembibre) {
//    		wineImage.setImageResource(bembibre.getImage());
//    	}
//    }
}
