package com.utad.baccus.controller;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.utad.baccus.R;

public class WebFragment extends Fragment {

	private String mURL = null;
	private WebView mBrowser = null;
	
	public static final String ARG_URL = "URL";
	private static final String CURRENT_URL = "com.utad.baccus.controller.CURRENT_URL";
	private static final int MENU_RELOAD = 0;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		super.onCreateView(inflater, container, savedInstanceState);
		View root = inflater.inflate(R.layout.fragment_web, container, false);
		
		// Recojo el modelo
		mURL = getArguments().getString(ARG_URL);
		
        final ProgressBar loading = (ProgressBar) root.findViewById(R.id.loading);
        
        mBrowser = (WebView) root.findViewById(R.id.browser);
        mBrowser.setWebViewClient(new WebViewClient() {
			
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
        
        // Carga la web del modelo
        if (savedInstanceState != null && savedInstanceState.containsKey(CURRENT_URL)) {
        	mBrowser.loadUrl(savedInstanceState.getString(CURRENT_URL));
        }
        else {
        	mBrowser.loadUrl(mURL);
        }
        
        return root;
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		String currentURL = mBrowser.getUrl();
		outState.putString(CURRENT_URL, currentURL);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		menu.add(Menu.NONE, MENU_RELOAD, 0, R.string.reload);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean defaultValue = super.onOptionsItemSelected(item);
		if (item.getItemId() == MENU_RELOAD) {
			mBrowser.reload();
			return true;
		}
		else {
			return defaultValue;
		}
	}
}
