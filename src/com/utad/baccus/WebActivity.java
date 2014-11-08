package com.utad.baccus;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.utad.baccus.model.Wine;
import android.widget.ProgressBar;

public class WebActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_web);
		
		// Creo el modelo
		Wine vegaval = new Wine("Vegaval", "Tinto", "http://www.vegaval.com/es/", "Miguel Calatayud", R.drawable.vegaval, 4, "Lorem fistrum pupita pupita a gramenawer me cago en tus muelas sexuarl. Por la gloria de mi madre benemeritaar no te digo trigo por no llamarte Rodrigor diodeno te voy a borrar el cerito. No puedor al ataquerl a wan caballo blanco caballo negroorl llevame al sircoo quietooor pupita de la pradera a peich ahorarr sexuarl. Tiene musho peligro te voy a borrar el cerito a wan tiene musho peligro pupita jarl ahorarr se calle ustée a wan pecador. A peich apetecan me cago en tus muelas al ataquerl. Qué dise usteer condemor me cago en tus muelas de la pradera pupita mamaar no te digo trigo por no llamarte Rodrigor ese hombree tiene musho peligro diodeno te va a hasé pupitaa.");
        vegaval.addGrape("Mencía");
        vegaval.addGrape("Garnacha");
		
        final ProgressBar loading = (ProgressBar) findViewById(R.id.loading);
        
		WebView browser = (WebView) findViewById(R.id.browser);
		browser.setWebViewClient(new WebViewClient() {
			
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				loading.setVisibility(View.VISIBLE);
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				loading.setVisibility(View.GONE);
			}
			
		});
		browser.loadUrl(vegaval.getURL());
	}
}
