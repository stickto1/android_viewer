package com.clbee.authorviewer.vo.paramValues;

public class BezierMoveParamValues {
	String mControlPt01;
	String mcontrolPt02;
	String mEndPoint;
	public BezierMoveParamValues(String mControlPt01, String mcontrolPt02,
			String mEndPoint) {
		super();
		this.mControlPt01 = mControlPt01;
		this.mcontrolPt02 = mcontrolPt02;
		this.mEndPoint = mEndPoint;
	}
	public String getmControlPt01() {
		return mControlPt01;
	}
	public void setmControlPt01(String mControlPt01) {
		this.mControlPt01 = mControlPt01;
	}
	public String getMcontrolPt02() {
		return mcontrolPt02;
	}
	public void setMcontrolPt02(String mcontrolPt02) {
		this.mcontrolPt02 = mcontrolPt02;
	}
	public String getmEndPoint() {
		return mEndPoint;
	}
	public void setmEndPoint(String mEndPoint) {
		this.mEndPoint = mEndPoint;
	}
}
