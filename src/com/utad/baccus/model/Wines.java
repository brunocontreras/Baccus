package com.utad.baccus.model;

import java.util.LinkedList;
import java.util.List;

import com.utad.baccus.R;

public class Wines {

	private List<Wine> mList;

	public List<Wine> getList() {
		return mList;
	}

	public void setList(List<Wine> mList) {
		this.mList = mList;
	}
	
	public Wines() {

		// Inicializa la lista
		mList = new LinkedList<Wine>();
		
		// Vegaval
		Wine vegaval = new Wine("Vegaval", "Tinto", "http://www.vegaval.com/es/", "Miguel Calatayud", R.drawable.vegaval, 4, "Lorem fistrum pupita pupita a gramenawer me cago en tus muelas sexuarl. Por la gloria de mi madre benemeritaar no te digo trigo por no llamarte Rodrigor diodeno te voy a borrar el cerito. No puedor al ataquerl a wan caballo blanco caballo negroorl llevame al sircoo quietooor pupita de la pradera a peich ahorarr sexuarl. Tiene musho peligro te voy a borrar el cerito a wan tiene musho peligro pupita jarl ahorarr se calle ustée a wan pecador. A peich apetecan me cago en tus muelas al ataquerl. Qué dise usteer condemor me cago en tus muelas de la pradera pupita mamaar no te digo trigo por no llamarte Rodrigor ese hombree tiene musho peligro diodeno te va a hasé pupitaa.");
		vegaval.addGrape("Mencía");
		vegaval.addGrape("Garnacha");
		mList.add(vegaval);
		
		// Bembibre
        Wine bembibre = new Wine("Bembibre", "Tinto", "http://www.dominiodetares.com/index.php/es/", "Dominio de Tares", R.drawable.bembibre, 5, "Lorem fistrum pupita pupita a gramenawer me cago en tus muelas sexuarl. Por la gloria de mi madre benemeritaar no te digo trigo por no llamarte Rodrigor diodeno te voy a borrar el cerito. No puedor al ataquerl a wan caballo blanco caballo negroorl llevame al sircoo quietooor pupita de la pradera a peich ahorarr sexuarl. Tiene musho peligro te voy a borrar el cerito a wan tiene musho peligro pupita jarl ahorarr se calle ustée a wan pecador. A peich apetecan me cago en tus muelas al ataquerl. Qué dise usteer condemor me cago en tus muelas de la pradera pupita mamaar no te digo trigo por no llamarte Rodrigor ese hombree tiene musho peligro diodeno te va a hasé pupitaa.");
        bembibre.addGrape("Mencía");
        mList.add(bembibre);
	}
}
