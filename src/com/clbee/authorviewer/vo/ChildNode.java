package com.clbee.authorviewer.vo;

import java.util.ArrayList;

public class ChildNode {
	String mNodeName;
	int mObjectType;
	String mTrgTagNo;
	String mObjectName;
	String mImageName;
	String mAngle;
	String mFrame;
	String mOpacity;
	String mExpandable;
	String mTrgName;
	String mClass;
	ArrayList<String> mTrgNodeList;
	ParamValues mParamValues;	
	ArrayList<ChildNode> mChildNodeList;
	public ChildNode(String mNodeName, int mObjectType, String mTrgTagNo,
			String mObjectName, String mImageName, String mAngle,
			String mFrame, String mOpacity, String mExpandable,
			String mTrgName, String mClass, ArrayList<String> mTrgNodeList,
			ParamValues mParamValues, ArrayList<ChildNode> mChildNodeList) {
		super();
		this.mNodeName = mNodeName;
		this.mObjectType = mObjectType;
		this.mTrgTagNo = mTrgTagNo;
		this.mObjectName = mObjectName;
		this.mImageName = mImageName;
		this.mAngle = mAngle;
		this.mFrame = mFrame;
		this.mOpacity = mOpacity;
		this.mExpandable = mExpandable;
		this.mTrgName = mTrgName;
		this.mClass = mClass;
		this.mTrgNodeList = mTrgNodeList;
		this.mParamValues = mParamValues;
		this.mChildNodeList = mChildNodeList;
	}
	public String getmNodeName() {
		return mNodeName;
	}
	public void setmNodeName(String mNodeName) {
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
	public String getmExpandable() {
		return mExpandable;
	}
	public void setmExpandable(String mExpandable) {
		this.mExpandable = mExpandable;
	}
	public String getmTrgName() {
		return mTrgName;
	}
	public void setmTrgName(String mTrgName) {
		this.mTrgName = mTrgName;
	}
	public String getmClass() {
		return mClass;
	}
	public void setmClass(String mClass) {
		this.mClass = mClass;
	}
	public ArrayList<String> getmTrgNodeList() {
		return mTrgNodeList;
	}
	public void setmTrgNodeList(ArrayList<String> mTrgNodeList) {
		this.mTrgNodeList = mTrgNodeList;
	}
	public ParamValues getmParamValueList() {
		return mParamValues;
	}
	public void setmParamValueList(ParamValues mParamValues) {
		this.mParamValues = mParamValues;
	}
	public ArrayList<ChildNode> getmChildNodeList() {
		return mChildNodeList;
	}
	public void setmChildNodeList(ArrayList<ChildNode> mChildNodeList) {
		this.mChildNodeList = mChildNodeList;
	}
}
