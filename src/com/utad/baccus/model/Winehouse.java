package com.utad.baccus.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.utad.baccus.R;

public class Winehouse {

	private static Winehouse sInstance = null;
	private static final String WINES_URL = "http://baccusapp.herokuapp.com/wines";
	private List<Wine> mWines;

	public List<Wine> getList() {
		return mWines;
	}

	public static Winehouse getInstance() {
		if (sInstance == null) {
			sInstance = new Winehouse();
		}
		return sInstance;
	}
	
	public void setList(List<Wine> mWines) {
		this.mWines = mWines;
	}

	public Winehouse() {
		try {
			URLConnection conn = new URL(WINES_URL).openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			
			mWines = new LinkedList<Wine>();
			
			JSONArray jsonRoot = new JSONArray(sb.toString());
			for (int i = 0; i < jsonRoot.length(); i++) {
				JSONObject jsonWine = jsonRoot.getJSONObject(i);
				
				if (jsonWine.has("name")) {
					String id = jsonWine.getString("_id");
					String name = jsonWine.getString("name");
					String type = jsonWine.getString("type");
					String url = jsonWine.getString("wine_web");
					String winehouse = jsonWine.getString("company");
					String imageUrl = jsonWine.getString("picture");
					int rating = jsonWine.getInt("rating");
					String notes = jsonWine.getString("notes");
					
					Wine wine = new Wine(id, name, type, url, winehouse, rating, notes, imageUrl);
					
				    JSONArray jsonGrapes = jsonWine.getJSONArray("grapes");
				    for (int j = 0; j < jsonGrapes.length(); j++) {
				    	JSONObject grape = (JSONObject) jsonGrapes.getJSONObject(j);
				    	wine.addGrape(grape.getString("grape"));
					}
					mWines.add(wine);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// Métodos para obtener un vino a partir de un índice
	public Wine getWine(int index) {
		return mWines.get(index);
	}
	
	public int getWineCount() {
		return mWines.size();
	}
	
	public List<Wine> cloneWineList() {
		List<Wine> copy = new LinkedList<Wine>();
		for (Wine wine : mWines) {
			copy.add(wine);
		}
		return copy;
	}
}
