package com.clbee.authorviewer.vo.paramValues;

public class PlayMediaParamValues {
	String mMediaPath = null;
	String mMediaObject = null;
	String mUseTimeLine = null;
	public PlayMediaParamValues(String mMediaPath, String mMediaObject,
			String mUseTimeLine) {
		super();
		this.mMediaPath = mMediaPath;
		this.mMediaObject = mMediaObject;
		this.mUseTimeLine = mUseTimeLine;
	}
	public String getmMediaPath() {
		return mMediaPath;
	}
	public void setmMediaPath(String mMediaPath) {
		this.mMediaPath = mMediaPath;
	}
	public String getmMediaObject() {
		return mMediaObject;
	}
	public void setmMediaObject(String mMediaObject) {
		this.mMediaObject = mMediaObject;
	}
	public String getmUseTimeLine() {
		return mUseTimeLine;
	}
	public void setmUseTimeLine(String mUseTimeLine) {
		this.mUseTimeLine = mUseTimeLine;
	}
}
