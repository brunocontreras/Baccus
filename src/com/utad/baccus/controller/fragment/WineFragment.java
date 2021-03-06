package com.utad.baccus.controller.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.utad.baccus.R;
import com.utad.baccus.controller.activity.WebActivity;
import com.utad.baccus.model.Constants;
import com.utad.baccus.model.Wine;

public class WineFragment extends Fragment {

	private Wine mWine = null;
	private ImageView mWineImage = null;
	private View mRoot = null;
	
	public static final String ARG_WINE = "WINE";
	public static final String CURRENT_SCALETYPE = "CURRENT_SCALETYPE";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		mRoot = inflater.inflate(R.layout.fragment_wine, container, false);
		
		mWine = (Wine) getArguments().getSerializable(ARG_WINE);
        
        TextView txt_wineName = (TextView) mRoot.findViewById(R.id.wine_name);
        txt_wineName.setText(mWine.getName());
        
        TextView txt_wineType = (TextView) mRoot.findViewById(R.id.wine_type);
        txt_wineType.setText(mWine.getType());
        
        TextView txt_wineHouse = (TextView) mRoot.findViewById(R.id.winehouse);
        txt_wineHouse.setText(mWine.getWinehouse());
        
        TextView txt_wineNotes = (TextView) mRoot.findViewById(R.id.wine_notes);
        txt_wineNotes.setText(mWine.getNotes());
        
        mWineImage = (ImageView) mRoot.findViewById(R.id.wine_image);
        mWineImage.setVisibility(View.INVISIBLE);
        
        final Handler dowloadImageHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				if (mWineImage != null) {
					mWineImage.setImageBitmap((Bitmap)msg.obj);
					mWineImage.setVisibility(View.VISIBLE);
					mRoot.findViewById(R.id.loading).setVisibility(View.GONE);
				}
			}
        };
        
        Thread downloader = new Thread(new Runnable() {
			@Override
			public void run() {
				Message msg = new Message();
				msg.obj = mWine.getBitmap(getActivity());
				dowloadImageHandler.sendMessage(msg);				
			}
		});
        
        downloader.start();
        
        if (savedInstanceState != null && savedInstanceState.containsKey(CURRENT_SCALETYPE)) {
        	mWineImage.setScaleType((ScaleType) savedInstanceState.getSerializable(CURRENT_SCALETYPE));
        }
        else {
        	SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        	ImageView.ScaleType scaleType = ImageView.ScaleType.valueOf(pref.getString(Constants.PREF_SCALE_TYPE, ImageView.ScaleType.FIT_CENTER.toString()));
        	mWineImage.setScaleType(scaleType);
        }
        
        // Creating grape texts
        LinearLayout grapesContainer = (LinearLayout) mRoot.findViewById(R.id.grapes);
        for (String grape : mWine.getGrapes()) {
        	TextView text = new TextView(getActivity());
        	text.setText(grape);
        	LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        			LinearLayout.LayoutParams.MATCH_PARENT,
        			LinearLayout.LayoutParams.WRAP_CONTENT);
        	text.setLayoutParams(params);
        	
        	text.setTextColor(Color.WHITE);
        	text.setTextSize(getResources().getDimension(R.dimen.baccus_text_size) / getResources().getDisplayMetrics().density);
        	grapesContainer.addView(text);
        }
        
        RatingBar ratingBar = (RatingBar) mRoot.findViewById(R.id.rating);
        ratingBar.setProgress(mWine.getRating());
        
        Button webButton = (Button) mRoot.findViewById(R.id.btn_gotoweb);
        webButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				AlertDialog.Builder alert = new Builder(getActivity());
				alert.setTitle("¿Ande vas?");
				alert.setMessage("Ojo-cuidado, que nos vamos fuera de la aplicación, tú verás lo que haces.");
				alert.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent webIntent = new Intent(getActivity(), WebActivity.class); 
			    		webIntent.putExtra(WebActivity.EXTRA_URL, mWine.getURL());
			    		startActivity(webIntent);
					}
				});
				alert.setNegativeButton("No",  new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				alert.show();
			}
		});
        
		return mRoot;
	}
	
    
    @Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.main, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean defaultValue = super.onOptionsItemSelected(item);
		
		if (item.getItemId() == R.id.action_settings) {
			SettingsFragment dialog = new SettingsFragment();
			dialog.setTargetFragment(this, SettingsFragment.REQUEST_SELECT_SCALE_TYPE);
			dialog.show(getFragmentManager(), null);
			return true;
		}
		else {
			return defaultValue;
		}
	}
	
	@Override
	public void onActivityResult(int requestCode, int result, Intent intent) {
		super.onActivityResult(requestCode, result, intent);
		
		if (requestCode == SettingsFragment.REQUEST_SELECT_SCALE_TYPE && result == Activity.RESULT_OK) {
			int optionSelected = intent.getIntExtra(SettingsFragment.OPTION_SELECTED, -1); 
			if (optionSelected != -1 && optionSelected == SettingsFragment.OPTION_NORMAL) {
				mWineImage.setScaleType(ScaleType.FIT_CENTER);
			}
			else if (optionSelected != -1 && optionSelected == SettingsFragment.OPTION_FIT) {
				mWineImage.setScaleType(ScaleType.FIT_XY);
			}
		}
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (mWineImage != null) {
			outState.putSerializable(CURRENT_SCALETYPE, mWineImage.getScaleType());
		}
	}
}
