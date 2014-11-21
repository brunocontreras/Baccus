package com.utad.baccus.controller;

import com.utad.baccus.R;
import com.utad.baccus.model.Wine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class WineFragment extends Fragment {

	private Wine mWine = null;
	private ImageView mWineImage = null;
	
	public static final String ARG_WINE = "WINE";
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View root = inflater.inflate(R.layout.fragment_wine, container, false);
		
		mWine = (Wine) getArguments().getSerializable(ARG_WINE);
        
        TextView txt_wineName = (TextView) root.findViewById(R.id.wine_name);
        txt_wineName.setText(mWine.getName());
        
        TextView txt_wineType = (TextView) root.findViewById(R.id.wine_type);
        txt_wineType.setText(mWine.getType());
        
        TextView txt_wineHouse = (TextView) root.findViewById(R.id.winehouse);
        txt_wineHouse.setText(mWine.getWineHouse());
        
        TextView txt_wineNotes = (TextView) root.findViewById(R.id.wine_notes);
        txt_wineNotes.setText(mWine.getNotes());
        
        mWineImage = (ImageView) root.findViewById(R.id.wine_image);
        mWineImage.setImageResource(mWine.getImage());
        
        // Creating grape texts
        LinearLayout grapesContainer = (LinearLayout) root.findViewById(R.id.grapes);
        for (String grape : mWine.getGrapes()) {
        	TextView text = new TextView(getActivity());
        	text.setText(grape);
        	LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        			LinearLayout.LayoutParams.MATCH_PARENT,
        			LinearLayout.LayoutParams.WRAP_CONTENT);
        	text.setLayoutParams(params);
        	grapesContainer.addView(text);
        }
        
        RatingBar ratingBar = (RatingBar) root.findViewById(R.id.rating);
        ratingBar.setProgress(mWine.getRating());
        
		return root;
	}
}
