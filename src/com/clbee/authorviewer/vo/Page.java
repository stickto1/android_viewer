package com.clbee.authorviewer.vo;

import java.util.ArrayList;

public class Page {
	private int mPage; //페이지 번호
	private String mAction; //애니메이션 시작 조건
	private ArrayList<Layer> mLayerList;
	private ArrayList<ChildNode> mChildNodes;
	
	public enum kTriggerType {
		Shake, Mic, Blow, Start, Begin, End, InRect, Drag;
	}

	public Page(ArrayList<Layer> mLayerList, String mAction, int mPage,
			ArrayList<ChildNode> mChildNodes) {
		super();
		this.mLayerList = new ArrayList<Layer>();
		this.mLayerList = mLayerList;
		this.mAction = mAction;
		this.mPage = mPage;
		this.mChildNodes = mChildNodes;
	}

	public ArrayList<Layer> getmLayerList() {
		return mLayerList;
	}

	public void setmLayerList(ArrayList<Layer> mLayerList) {
		this.mLayerList = mLayerList;
	}

	public String getmAction() {
		return mAction;
	}

	public void setmAction(String mAction) {
		this.mAction = mAction;
	}

	public int getmPage() {
		return mPage;
	}

	public void setmPage(int mPage) {
		this.mPage = mPage;
	}

	public ArrayList<ChildNode> getmChildNodes() {
		return mChildNodes;
	}

	public void setmChildNodes(ArrayList<ChildNode> mChildNodes) {
		this.mChildNodes = mChildNodes;
	}
}
