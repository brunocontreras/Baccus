package com.utad.baccus.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class Wine implements Serializable {

	private static final long serialVersionUID = 1L;
	private String mId;
	private String mName;
	private String mType;
	private String mURL;
	private String mWineHouse;
	private List<String> mGrapes;
	private int mImage;
	private String mImageURL;
	private int mRating;
	private String mNotes;

	
	public Wine(String id, String name, String type, String uRL, String wineHouse,
			int rating, String notes, String imageURL) {
		super();
		mId = id;
		mName = name;
		mType = type;
		mURL = uRL;
		mWineHouse = wineHouse;
//		mImage = image;
		mRating = rating;
		mGrapes = new LinkedList<String>();
		mNotes = notes;
		mImageURL = imageURL;
	}
	
	public String getId() {
		return mId;
	}
	public void setId(String id) {
		mId = id;
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
	public String getNotes() {
		return mNotes;
	}
	public void setNotes(String notes) {
		mNotes = notes;
	}
	public void addGrape(String grape) {
		mGrapes.add(grape);
	}
	public String getImageURL() {
		return mImageURL;
	}
	public void setImageURL(String imageURL) {
		mImageURL = imageURL;
	}
	
	public Bitmap getBitmap(Context context) {
		return getBitmapFromURL(context, mImageURL);
	}
	
	public Bitmap getBitmapFromURL(Context context, String url) {
		File imageFile = new File(context.getCacheDir(), getId());
		
		if (imageFile.exists()) {
			return BitmapFactory.decodeFile(imageFile.getAbsolutePath());
		}

		InputStream in = null;
		try {
			in = new java.net.URL(url).openStream();
			Bitmap bmp = BitmapFactory.decodeStream(in);
			FileOutputStream fos = new FileOutputStream(imageFile);
			bmp.compress(Bitmap.CompressFormat.PNG, 90, fos);
			fos.close();
			return bmp;
		} catch (Exception e) {
			Log.e("Baccus", "Error downloading image", e);
			return null;
		} finally {
			try {
				if (in != null) {
					in.close();
				} 
			} catch (IOException e) { }
		}
	}

	@Override
	public String toString() {
		return getName();
	}
	
	
}