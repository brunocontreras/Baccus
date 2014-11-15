package com.utad.baccus.controller;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.utad.baccus.R;
import com.utad.baccus.model.Wine;

public class WinehouseActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_winehouse);
		
		TabHost tabHost = getTabHost();
		
		
		Wine vegaval = new Wine("Vegaval", "Tinto", "http://www.vegaval.com/es/", "Miguel Calatayud", R.drawable.vegaval, 4, "Lorem fistrum pupita pupita a gramenawer me cago en tus muelas sexuarl. Por la gloria de mi madre benemeritaar no te digo trigo por no llamarte Rodrigor diodeno te voy a borrar el cerito. No puedor al ataquerl a wan caballo blanco caballo negroorl llevame al sircoo quietooor pupita de la pradera a peich ahorarr sexuarl. Tiene musho peligro te voy a borrar el cerito a wan tiene musho peligro pupita jarl ahorarr se calle ustée a wan pecador. A peich apetecan me cago en tus muelas al ataquerl. Qué dise usteer condemor me cago en tus muelas de la pradera pupita mamaar no te digo trigo por no llamarte Rodrigor ese hombree tiene musho peligro diodeno te va a hasé pupitaa.");
		vegaval.addGrape("Mencía");
		vegaval.addGrape("Garnacha");
		
        Wine bembibre = new Wine("Bembibre", "Tinto", "http://www.dominiodetares.com/index.php/es/", "Dominio de Tares", R.drawable.bembibre, 5, "Lorem fistrum pupita pupita a gramenawer me cago en tus muelas sexuarl. Por la gloria de mi madre benemeritaar no te digo trigo por no llamarte Rodrigor diodeno te voy a borrar el cerito. No puedor al ataquerl a wan caballo blanco caballo negroorl llevame al sircoo quietooor pupita de la pradera a peich ahorarr sexuarl. Tiene musho peligro te voy a borrar el cerito a wan tiene musho peligro pupita jarl ahorarr se calle ustée a wan pecador. A peich apetecan me cago en tus muelas al ataquerl. Qué dise usteer condemor me cago en tus muelas de la pradera pupita mamaar no te digo trigo por no llamarte Rodrigor ese hombree tiene musho peligro diodeno te va a hasé pupitaa.");
        bembibre.addGrape("Mencía");

		Intent vegavalIntent = new Intent(this, WineActivity.class);
		vegavalIntent.putExtra(WineActivity.WINE, vegaval);
		TabSpec tabVegaval = tabHost.newTabSpec("Vegaval");
		tabVegaval.setIndicator("Vegaval");
		tabVegaval.setContent(vegavalIntent);
		
		Intent bembibreIntent = new Intent(this, WineActivity.class);
		bembibreIntent.putExtra(WineActivity.WINE, bembibre);
		TabSpec tabBembibre = tabHost.newTabSpec("Bembibre");
		tabBembibre.setIndicator("Bembibre");
		tabBembibre.setContent(bembibreIntent);
		
		tabHost.addTab(tabVegaval);
		tabHost.addTab(tabBembibre);
	}
}
