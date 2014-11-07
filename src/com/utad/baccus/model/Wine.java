package com.utad.baccus.model;

import java.util.LinkedList;
import java.util.List;

public class Wine {
	
	private String mName;
	private String mType;
	private String mURL;
	private String mWineHouse;
	private List<String> mGrapes;
	private int mImage;
	private int mRating;
	
	public Wine(String name, String type, String uRL, String wineHouse,
			int image, int rating) {
		super();
		mName = name;
		mType = type;
		mURL = uRL;
		mWineHouse = wineHouse;
		mImage = image;
		mRating = rating;
		mGrapes = new LinkedList<String>();
	}
	
	public String getName() {
		return mName;
	}
	public void setName(String name) {
		mName = name;
	}
	public String getType() {
		return mType;
	}
	public void setType(String type) {
		mType = type;
	}
	public String getURL() {
		return mURL;
	}
	public void setURL(String uRL) {
		mURL = uRL;
	}
	public String getWineHouse() {
		return mWineHouse;
	}
	public void setWineHouse(String wineHouse) {
		mWineHouse = wineHouse;
	}
	public List<String> getGrapes() {
		return mGrapes;
	}
	public int getImage() {
		return mImage;
	}
	public void setImage(int image) {
		mImage = image;
	}
	public int getRating() {
		return mRating;
	}
	public void setRating(int rating) {
		mRating = rating;
	}
	public void addGrape(String grape) {
		mGrapes.add(grape);
	}
}