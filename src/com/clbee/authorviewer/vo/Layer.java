package com.clbee.authorviewer.vo;

import java.util.ArrayList;

public class Layer {
	String mLayerName;
	ArrayList<MainNode> mMainNodeList;
	public Layer(String mLayerName, ArrayList<MainNode> mMainNodeList) {
		super();
		mMainNodeList = new ArrayList<MainNode>();
		this.mLayerName = mLayerName;
		this.mMainNodeList = mMainNodeList;
	}
	public String getmLayerName() {
		return mLayerName;
	}
	public void setmLayerName(String mLayerName) {
		this.mLayerName = mLayerName;
	}
	public ArrayList<MainNode> getmMainNodeList() {
		return mMainNodeList;
	}
	public void setmMainNodeList(ArrayList<MainNode> mMainNodeList) {
		this.mMainNodeList = mMainNodeList;
	}
}
