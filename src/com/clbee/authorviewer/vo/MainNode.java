package com.clbee.authorviewer.vo;

import java.util.ArrayList;

import org.json.JSONObject;

public class MainNode {
	int mNodeName;
	int mObjectType;
	String mTrgTagNo;
	String mObjectName;
	String mImageName;
	String mAngle;
	String mFrame;
	String mOpacity;
	String mClass;
	ParamValues mParamValues;
	String mTriggerType;
	ArrayList<String> mTrgNodes;
	ChildNode mChildNode;
	public MainNode(int mNodeName, int mObjectType, String mTrgTagNo,
			String mObjectName, String mImageName, String mAngle,
			String mFrame, String mOpacity, String mClass,
			ParamValues mParamValues, String mTriggerType,
			ArrayList<String> mTrgNodes, ChildNode mChildNode) {
		super();
		this.mNodeName = mNodeName;
		this.mObjectType = mObjectType;
		this.mTrgTagNo = mTrgTagNo;
		this.mObjectName = mObjectName;
		this.mImageName = mImageName;
		this.mAngle = mAngle;
		this.mFrame = mFrame;
		this.mOpacity = mOpacity;
		this.mClass = mClass;
		this.mParamValues = mParamValues;
		this.mTriggerType = mTriggerType;
		this.mTrgNodes = mTrgNodes;
		this.mChildNode = mChildNode;
	}
	public int getmNodeName() {
		return mNodeName;
	}
	public void setmNodeName(int mNodeName) {
		this.mNodeName = mNodeName;
	}
	public int getmObjectType() {
		return mObjectType;
	}
	public void setmObjectType(int mObjectType) {
		this.mObjectType = mObjectType;
	}
	public String getmTrgTagNo() {
		return mTrgTagNo;
	}
	public void setmTrgTagNo(String mTrgTagNo) {
		this.mTrgTagNo = mTrgTagNo;
	}
	public String getmObjectName() {
		return mObjectName;
	}
	public void setmObjectName(String mObjectName) {
		this.mObjectName = mObjectName;
	}
	public String getmImageName() {
		return mImageName;
	}
	public void setmImageName(String mImageName) {
		this.mImageName = mImageName;
	}
	public String getmAngle() {
		return mAngle;
	}
	public void setmAngle(String mAngle) {
		this.mAngle = mAngle;
	}
	public String getmFrame() {
		return mFrame;
	}
	public void setmFrame(String mFrame) {
		this.mFrame = mFrame;
	}
	public String getmOpacity() {
		return mOpacity;
	}
	public void setmOpacity(String mOpacity) {
		this.mOpacity = mOpacity;
	}
	public String getmClass() {
		return mClass;
	}
	public void setmClass(String mClass) {
		this.mClass = mClass;
	}
	public ParamValues getmParamValues() {
		return mParamValues;
	}
	public void setmParamValues(ParamValues mParamValues) {
		this.mParamValues = mParamValues;
	}
	public String getmTriggerType() {
		return mTriggerType;
	}
	public void setmTriggerType(String mTriggerType) {
		this.mTriggerType = mTriggerType;
	}
	public ArrayList<String> getmTrgNodes() {
		return mTrgNodes;
	}
	public void setmTrgNodes(ArrayList<String> mTrgNodes) {
		this.mTrgNodes = mTrgNodes;
	}
	public ChildNode getmChildNode() {
		return mChildNode;
	}
	public void setmChildNode(ChildNode mChildNode) {
		this.mChildNode = mChildNode;
	}
	
}
