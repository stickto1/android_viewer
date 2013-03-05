package com.clbee.authorviewer;

import java.util.ArrayList;
import java.util.Hashtable;

public class VoModel {
	private String Show;
	private String ImageFile;
	private ArrayList<Hashtable<String, String>> mKeyValueList;
	private Hashtable<String, String> mVoModelKeyValue;
	
	public VoModel() {
		mVoModelKeyValue = new Hashtable<String, String>(); 
		mKeyValueList = new ArrayList<Hashtable<String,String>>();
	}
	
	
	public String getShow() {
		return Show;
	}



	public void setShow(String show) {
		Show = show;
	}



	public String getImageFile() {
		return ImageFile;
	}



	public void setImageFile(String imageFile) {
		ImageFile = imageFile;
	}



	public ArrayList<Hashtable<String, String>> getmKeyValueList() {
		return mKeyValueList;
	}



	public void setmKeyValueList(ArrayList<Hashtable<String, String>> mKeyValueList) {
		this.mKeyValueList = mKeyValueList;
	}

}
