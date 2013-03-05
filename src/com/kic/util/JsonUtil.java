package com.kic.util;

import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.clbee.authorviewer.vo.ChildNode;
import com.clbee.authorviewer.vo.Document;
import com.clbee.authorviewer.vo.Layer;
import com.clbee.authorviewer.vo.MainNode;
import com.clbee.authorviewer.vo.ParamValues;
import com.clbee.authorviewer.vo.paramValues.AnimationParamValues;
import com.clbee.authorviewer.vo.paramValues.BezierMoveParamValues;
import com.clbee.authorviewer.vo.paramValues.Box2dParamValues;
import com.clbee.authorviewer.vo.paramValues.FadeParamValues;
import com.clbee.authorviewer.vo.paramValues.JumpParamValues;
import com.clbee.authorviewer.vo.paramValues.MoveParamValues;
import com.clbee.authorviewer.vo.paramValues.ParticleParamValues;
import com.clbee.authorviewer.vo.paramValues.PlayMediaParamValues;
import com.clbee.authorviewer.vo.paramValues.RotateParamValues;
import com.clbee.authorviewer.vo.paramValues.ScaleMoveParamValues;
import com.clbee.authorviewer.vo.paramValues.ScaleParamValues;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import android.R.bool;
import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class JsonUtil {
	private String mTagName = "KeyName";
	public String getJsonStringFromFile(String fileName, String folderName,
			Context context) {
		int rID = 0;
		String jsonString = "";
		rID = context.getResources().getIdentifier(fileName, folderName,
				context.getPackageName());
		InputStream fio = context.getResources().openRawResource(rID);

		try {
			byte[] data = new byte[fio.available()];
			while (fio.read(data) != -1) {
				;
			}
			fio.close();

			jsonString = new String(data);

		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.e("JsonString ->", jsonString);
		return jsonString;
	}

	public void jsonParser(String jsonString) {
		ArrayList<Layer> layerList = new ArrayList<Layer>();
		try {
			JSONObject jo = new JSONObject(jsonString);
			JSONArray arrDocument = jo.getJSONArray("Document");
			for (int i = 0; i < arrDocument.length(); i++) {
				JSONObject pages = arrDocument.getJSONObject(i);
				
				//List
				JSONArray layers = pages.getJSONArray("List");
				for (int j = 0; j < layers.length(); j++) {
					JSONObject layer = layers.getJSONObject(j);
					JSONArray list = layer.getJSONArray("List");
					ArrayList<MainNode> mainNodeList = getMainNode(list);
					for (int k = 0; k < mainNodeList.size(); k++) {
						Log.e("ImageName"+k,mainNodeList.get(k).getmImageName());
					}
					String layerName = layer.getString("Name");
					layerList.add(new Layer(layerName, mainNodeList));
					Log.e("layerName", layerName);
				}
				
				//Page
//				JSONObject page = pages.getJSONObject("Page");
//				JSONObject action = page.getJSONObject("Action");
//				String pageNum = page.getString("Page");
//				Log.e("", pageNum);
//				Iterator<Object> key = action.keys();
//				String keyName="";
//				while (key.hasNext()) {
//					keyName = key.next().toString();
//					JSONArray parentNodes = action.getJSONArray(keyName);
//					for (int j = 0; j < parentNodes.length(); j++) {
//						JSONObject object = parentNodes.getJSONObject(i);
//						String nodeName = object.getString("nodeName");
//						String trgTagNo = object.getString("trgTagNo");
//						String trgName = object.getString("trgName");
//						String Class = object.getString("Class");
//						boolean expandable = object.getBoolean("expandable");
//						//childNodes Array
//						JSONArray childNodes = object.getJSONArray("childNodes");
//						getchildNode(childNodes);
//						
//					}
//					Log.e("", keyName);
//				}
			}

		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return new Document(new Document(mDocument));
	}
	
	private ArrayList<MainNode> getMainNode(JSONArray list) {
		ArrayList<MainNode> mainNodeList = new ArrayList<MainNode>();
		ArrayList<ChildNode> childNodeList = new ArrayList<ChildNode>();
		int nodeName=0;
		int objectType=0;
		String trgTagNo=null;
		String objectName=null;
		String imageName=null;
		String angle=null;
		String frame=null;
		String opacity=null;
		String Class=null;
		ParamValues paramValues=null;
		String triggerTypeKey=null;
		ArrayList<String> trgNodeList=new ArrayList<String>();
		JSONObject triggerType=null;
		ChildNode childNodeOfMain= null;
		//mainChildNode
		String nodeNameOfTriggerType=null;
		int objectTypeOfTriggerType=0;
		String trgTagNoOfTriggerType=null;
		String objectNameOfTriggerType=null;
		String imageNameOfTriggerType=null;
		String angleOfTriggerType=null;
		String frameOfTriggerType=null;
		String opacityOfTriggerType=null;
		String expandableOfTriggerType=null;
		String trgNameOfTriggerType=null;
		String ClassOfTriggerType=null;
		ParamValues paramValuesOfTriggerType=null;
		try {
			for (int k = 0; k < list.length(); k++) {
				JSONObject parentNode = list.getJSONObject(k);
				
				if(parentNode.has("nodeName")){
					nodeName = parentNode.getInt("nodeName");
				}
				if(parentNode.has("ObjectType")){
					objectType = parentNode.getInt("ObjectType");
				}
				if(parentNode.has("trgTagNo")){
					trgTagNo = parentNode.getString("trgTagNo");
				}
				if(parentNode.has("objectName")){
					objectName = parentNode.getString("objectName");
				}
				if(parentNode.has("ImageName")){
					imageName = parentNode.getString("ImageName");
				}
				if(parentNode.has("angle")){
					angle = parentNode.getString("angle");
				}
				if(parentNode.has("Frame")){
					frame = parentNode.getString("Frame");
				}
				if(parentNode.has("opacity")){
					opacity = parentNode.getString("opacity");
				}
				if(parentNode.has("Class")){
					Class = parentNode.getString("Class");
				}
				if(parentNode.has("trgNodes")){
					JSONArray trgNodes = parentNode.getJSONArray("trgNodes");
					for (int i = 0; i < trgNodes.length(); i++) {
						JSONObject trgNode = trgNodes.getJSONObject(i);
//						?? = trgNode.get(??);
					}
				}
				if(parentNode.has("paramValues")){
					JSONObject paramValue = parentNode.getJSONObject("paramValues");
					getParamValues(paramValue);
//					paramValues = getParamValues(paramValue);
				}
				
				if(parentNode.has("Start")){
					triggerTypeKey="Start";
				}else if(parentNode.has("Begin")){
					triggerTypeKey="Begin";
				}else if(parentNode.has("End")){
					triggerTypeKey="End";
				}else if(parentNode.has("In Rect")){
					triggerTypeKey="In Rect";
				}
				if(parentNode.has(triggerTypeKey)){
					triggerType = parentNode.getJSONObject(triggerTypeKey);
				}
				if(triggerType != null){
					if(triggerType.has("nodeName")){
						nodeNameOfTriggerType = triggerType.getString("nodeName");
					}
					if(triggerType.has("ObjectType")){
						objectTypeOfTriggerType = triggerType.getInt("ObjectType");
					}
					if(triggerType.has("trgTagNo")){
						trgTagNoOfTriggerType = triggerType.getString("trgTagNo");
					}
					if(triggerType.has("objectName")){
						objectNameOfTriggerType = triggerType.getString("objectName");
					}
					if(triggerType.has("ImageName")){
						imageNameOfTriggerType = triggerType.getString("ImageName");
					}
					if(triggerType.has("angle")){
						angleOfTriggerType = triggerType.getString("angle");
					}
					if(triggerType.has("Frame")){
						frameOfTriggerType = triggerType.getString("Frame");
					}
					if(triggerType.has("opacity")){
						opacityOfTriggerType = triggerType.getString("opacity");
					}
					if(triggerType.has("expandable")){
						expandableOfTriggerType = triggerType.getString("expandable");
					}
					if(triggerType.has("trgName")){
						trgNameOfTriggerType = triggerType.getString("trgName");
					}
					if(triggerType.has("Class")){
						ClassOfTriggerType = triggerType.getString("Class");
					}
					if(triggerType.has("paramValues")){
						JSONObject paramValue = triggerType.getJSONObject("paramValues");
						paramValuesOfTriggerType = getParamValues(paramValue);
					}
					
					if(triggerType.has("childNodes")){
						JSONArray childNodes = triggerType.getJSONArray("childNodes");
						childNodeList = getchildNode(childNodes);
						for (int i = 0; i < childNodeList.size(); i++) {
							Log.e("NodeName"+(i+1), childNodeList.get(i).getmNodeName());
							Log.e("trgName"+(i+1), childNodeList.get(i).getmTrgName());
						}
					}
					childNodeOfMain = new ChildNode(nodeNameOfTriggerType, objectTypeOfTriggerType, trgTagNoOfTriggerType, objectNameOfTriggerType, imageNameOfTriggerType, angleOfTriggerType, frameOfTriggerType, opacityOfTriggerType, expandableOfTriggerType, trgNameOfTriggerType, ClassOfTriggerType, trgNodeList, paramValuesOfTriggerType, childNodeList);
				}
				mainNodeList.add(new MainNode(nodeName, objectType, trgTagNo, objectName, imageName, angle, frame, opacity, Class, paramValues, triggerTypeKey, trgNodeList, childNodeOfMain));
				}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mainNodeList;
	}
	
	
	private ArrayList<ChildNode> getchildNode(JSONArray childNodes) {
		String nodeName=null;
		int objectType=0;
		String trgTagNo=null;
		String objectName=null;
		String imageName=null;
		String angle=null;
		String frame=null;
		String opacity=null;
		String expandable=null;
		String trgName=null;
		String Class=null;
		ArrayList<String> trgNodeList=new ArrayList<String>();
		ArrayList<ChildNode> childNodeList=new ArrayList<ChildNode>();
		ParamValues paramValue=null;
		ChildNode child=null;
		JSONArray innerChildNodes=null;
		try {
			for (int k = 0; k < childNodes.length(); k++) {
					JSONObject childNode = childNodes.getJSONObject(k);
					
					if(childNode.has("nodeName")){
						nodeName = childNode.getString("nodeName");
					}
					if(childNode.has("ObjectType")){
						objectType = childNode.getInt("ObjectType");
					}
					if(childNode.has("trgTagNo")){
						trgTagNo = childNode.getString("trgTagNo");
					}
					if(childNode.has("objectName")){
						objectName = childNode.getString("objectName");
					}
					if(childNode.has("ImageName")){
						imageName = childNode.getString("ImageName");
					}
					if(childNode.has("angle")){
						angle = childNode.getString("angle");
					}
					if(childNode.has("Frame")){
						frame = childNode.getString("Frame");
					}
					if(childNode.has("opacity")){
						opacity = childNode.getString("opacity");
					}
					if(childNode.has("expandable")){
						expandable = childNode.getString("expandable");
					}
					if(childNode.has("trgName")){
						trgName = childNode.getString("trgName");
					}
					if(childNode.has("Class")){
						Class = childNode.getString("Class");
					}
					//-------------getTrgNodes()호출----------------------
					if(childNode.has("trgNodes")){
						JSONArray trgNodes = childNode.getJSONArray("trgNodes");
						if (!(trgNodes.length()==0)) {
							getTrgNodes(trgNodes);
						}
					}
					//-------------getParamValues()호출----------------------
					if(childNode.has("paramValues")){
						JSONObject paramValues = childNode.getJSONObject("paramValues");
						paramValue=getParamValues(paramValues);
					}
					//-------------childNodes 존재하면 recursive--------------
					if(childNode.has("childNodes")){
						innerChildNodes = childNode.getJSONArray("childNodes");
						if (0 < innerChildNodes.length()) {
						ArrayList<ChildNode> innerChildNodeList = recursiveChildNode(innerChildNodes);
						child = new ChildNode(nodeName, objectType, trgTagNo, objectName, imageName, angle, frame, opacity, expandable, trgName, Class, trgNodeList, paramValue, innerChildNodeList);
						}else{
						child = new ChildNode(nodeName, objectType, trgTagNo, objectName, imageName, angle, frame, opacity, expandable, trgName, Class, trgNodeList, paramValue, null);
						}
					}
					childNodeList.add(child);
					for (int i = 0; i < childNodeList.size(); i++) {
						Log.e("childNode", childNodeList.get(i).getmNodeName());
					}
					Log.e("-------------------", "------------------");
			}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return childNodeList;
	}
	
	
	private ArrayList<ChildNode> recursiveChildNode(JSONArray childNodes) {
		return getchildNode(childNodes);
	}

	
	private void getTrgNodes(JSONArray trgNodes) {
		for (int i = 0; i < trgNodes.length(); i++) {
			
		}
	}
	
	
	private ParamValues getParamValues(JSONObject paramValues) {
		AnimationParamValues animationParamValues=null;
		BezierMoveParamValues bezierMoveParamValues=null;
		Box2dParamValues box2dParamValues=null;
		FadeParamValues fadeParamValues=null;
		JumpParamValues jumpParamValues=null;
		MoveParamValues moveParamValues=null;
		ParticleParamValues particleParamValues=null;
		PlayMediaParamValues playMediaParamValues=null;
		RotateParamValues rotateParamValues=null;
		ScaleMoveParamValues scaleMoveParamValues=null;
		ScaleParamValues scaleParamValues=null;
		try {
			String actType = "";
			String actSubType = "";
			if (paramValues.has("actType")) {
				actType = paramValues.getString("actType");
				Log.e("", actType);
			}
			if (paramValues.has("actSubType")) {
				actSubType = paramValues.getString("actSubType");
				Log.e("", actSubType);
			}

			if(actType.equals("Fade")){
				fadeParamValues = getFadeParamValues(paramValues);
			}else if(actType.equals("Move")){
				moveParamValues = getMoveParamValues(paramValues);
			}else if(actType.equals("Jump")){
				jumpParamValues = getJumpParamValues(paramValues);
			}else if(actType.equals("Scale")){
				scaleParamValues = getScaleParamValues(paramValues);
			}else if(actType.equals("Rotate")){
				rotateParamValues = getRotateParamValues(paramValues);
			}else if(actType.equals("Play Movie") || actType.equals("Play Sound")){
				playMediaParamValues = getPlayMediaParamValues(paramValues);
			}else if(actType.equals("Stop All Action")){
				if(paramValues.has("delay")){
					String delay = paramValues.getString("delay");
				}
			}else if(actType.equals("Hide / Show")){
				if(paramValues.has("delay")){
					String delay = paramValues.getString("delay");
				}
			}else if(actType.equals("ScaleMove")){
				getScaleMoveParamValues(paramValues);
			}else if(actType.equals("Flip")){
				if(paramValues.has("delay")){
					String delay = paramValues.getString("delay");
				}
			}else if(actType.equals("Animation")){
				animationParamValues = getAnimationParamValues(paramValues);
			}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ParamValues(animationParamValues, bezierMoveParamValues, box2dParamValues, fadeParamValues, jumpParamValues, moveParamValues, particleParamValues, playMediaParamValues, rotateParamValues, scaleMoveParamValues, scaleParamValues);
	}

	//Fade
	private FadeParamValues getFadeParamValues(JSONObject paramValues) {
		String delay=null;
		String duration=null;
		String reverse=null;
		String waitingTime=null; 
		String revDuration=null;
		String repeatCount=null;
		String repeatForever=null;
		String opacity=null;
		String revOpacity=null;
		try {
			if(paramValues.has("delay")){
				delay = paramValues.getString("delay");
				Log.e("", delay);
			}
			if(paramValues.has("duration")){
				duration = paramValues.getString("duration");
				Log.e("", duration);
			}
			if(paramValues.has("reverse")){
				reverse = paramValues.getString("reverse");
				Log.e("", reverse);
			}
			if(paramValues.has("waitingTime")){
				waitingTime = paramValues.getString("waitingTime");
				Log.e("", waitingTime);
			}
			if(paramValues.has("revDuration")){
				revDuration = paramValues.getString("revDuration");
				Log.e("", revDuration);
			}
			if(paramValues.has("repeatCount")){
				repeatCount = paramValues.getString("repeatCount");
				Log.e("", repeatCount);
			}
			if(paramValues.has("repeatForever")){
				repeatForever = paramValues.getString("repeatForever");
				Log.e("", repeatForever);
			}
			if(paramValues.has("opacity")){
				opacity = paramValues.getString("opacity");
				Log.e("", opacity);
			}
			if(paramValues.has("revOpacity")){
				revOpacity = paramValues.getString("revOpacity");
			}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new FadeParamValues(delay, duration, reverse, waitingTime, revDuration, repeatCount, repeatForever, opacity, revOpacity);
	}
	
	// Move
	private MoveParamValues getMoveParamValues(JSONObject paramValues) {
		String delay=null;
		String duration=null;
		String reverse=null;
		String waitingTime=null; 
		String revDuration=null;
		String repeatCount=null;
		String repeatForever=null;
		String opacity=null;
		String position=null;
		String revPosition=null;
		try {
			if(paramValues.has("delay")){
				delay = paramValues.getString("delay");
				Log.e("", delay);
			}
			if(paramValues.has("duration")){
				duration = paramValues.getString("duration");
				Log.e("", duration);
			}
			if(paramValues.has("reverse")){
				reverse = paramValues.getString("reverse");
				Log.e("", reverse);
			}
			if(paramValues.has("waitingTime")){
				waitingTime = paramValues.getString("waitingTime");
				Log.e("", waitingTime);
			}
			if(paramValues.has("revDuration")){
				revDuration = paramValues.getString("revDuration");
				Log.e("", revDuration);
			}
			if(paramValues.has("repeatCount")){
				repeatCount = paramValues.getString("repeatCount");
				Log.e("", repeatCount);
			}
			if(paramValues.has("repeatForever")){
				repeatForever = paramValues.getString("repeatForever");
				Log.e("", repeatForever);
			}
			if(paramValues.has("opacity")){
				opacity = paramValues.getString("opacity");
				Log.e("", opacity);
			}
			if(paramValues.has("position")){
				position = paramValues.getString("position");
			}
			if(paramValues.has("revPosition")){
				revPosition = paramValues.getString("revPosition");
			}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new MoveParamValues(delay, duration, reverse, waitingTime, revDuration, repeatCount, repeatForever, opacity, position, revPosition);
	}
	// Bezier Move
	private BezierMoveParamValues getBezierMoveParamValues(JSONObject paramValues) {
		String controlPt01=null;
		String controlPt02=null;
		String endPoint=null;
		try {
			if(paramValues.has("controlPt01")){
				controlPt01 = paramValues.getString("controlPt01");
			}
			if(paramValues.has("controlPt02")){
				controlPt02 = paramValues.getString("controlPt02");
			}
			if(paramValues.has("endPoint")){
				endPoint = paramValues.getString("endPoint");
			}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BezierMoveParamValues(controlPt01, controlPt02, endPoint);
	}
	// Jump
	private JumpParamValues getJumpParamValues(JSONObject paramValues) {
		String delay=null;
		String duration=null;
		String reverse=null;
		String waitingTime=null; 
		String revDuration=null;
		String repeatCount=null;
		String repeatForever=null;
		String opacity=null;
		String position=null;
		String revPosition=null;
		String jumpCount=null;
		String jumpHeight=null;
		try {
			if(paramValues.has("delay")){
				delay = paramValues.getString("delay");
				Log.e("", delay);
			}
			if(paramValues.has("duration")){
				duration = paramValues.getString("duration");
				Log.e("", duration);
			}
			if(paramValues.has("reverse")){
				reverse = paramValues.getString("reverse");
				Log.e("", reverse);
			}
			if(paramValues.has("waitingTime")){
				waitingTime = paramValues.getString("waitingTime");
				Log.e("", waitingTime);
			}
			if(paramValues.has("revDuration")){
				revDuration = paramValues.getString("revDuration");
				Log.e("", revDuration);
			}
			if(paramValues.has("repeatCount")){
				repeatCount = paramValues.getString("repeatCount");
				Log.e("", repeatCount);
			}
			if(paramValues.has("repeatForever")){
				repeatForever = paramValues.getString("repeatForever");
				Log.e("", repeatForever);
			}
			if(paramValues.has("opacity")){
				opacity = paramValues.getString("opacity");
				Log.e("", opacity);
			}
			if(paramValues.has("position")){
				position = paramValues.getString("position");
			}
			if(paramValues.has("revPosition")){
				revPosition = paramValues.getString("revPosition");
			}
			if(paramValues.has("jumpCount")){
				jumpCount = paramValues.getString("jumpCount");
			}
			if(paramValues.has("jumpHeight")){
				jumpHeight = paramValues.getString("jumpHeight");
			}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new JumpParamValues(delay, duration, reverse, waitingTime, revDuration, repeatCount, repeatForever, opacity, position, revPosition, jumpCount, jumpHeight);
	}
	// Scale
	private ScaleParamValues getScaleParamValues(JSONObject paramValues) {
		String delay=null;
		String duration=null;
		String reverse=null;
		String waitingTime=null; 
		String revDuration=null;
		String repeatCount=null;
		String repeatForever=null;
		String opacity=null;
		String position=null;
		String revPosition=null;
		String scaleWidth=null;
		String scaleHeight=null;
		String scaleX=null;
		String scaleY=null;
		String revScaleWidth=null;
		String revScaleHeight=null;
		String revScaleX=null;
		String revScaleY=null;
		try {
			if(paramValues.has("delay")){
				delay = paramValues.getString("delay");
				Log.e("", delay);
			}
			if(paramValues.has("duration")){
				duration = paramValues.getString("duration");
				Log.e("", duration);
			}
			if(paramValues.has("reverse")){
				reverse = paramValues.getString("reverse");
				Log.e("", reverse);
			}
			if(paramValues.has("waitingTime")){
				waitingTime = paramValues.getString("waitingTime");
				Log.e("", waitingTime);
			}
			if(paramValues.has("revDuration")){
				revDuration = paramValues.getString("revDuration");
				Log.e("", revDuration);
			}
			if(paramValues.has("repeatCount")){
				repeatCount = paramValues.getString("repeatCount");
				Log.e("", repeatCount);
			}
			if(paramValues.has("repeatForever")){
				repeatForever = paramValues.getString("repeatForever");
				Log.e("", repeatForever);
			}
			if(paramValues.has("opacity")){
				opacity = paramValues.getString("opacity");
				Log.e("", opacity);
			}
			if(paramValues.has("position")){
				position = paramValues.getString("position");
			}
			if(paramValues.has("revPosition")){
				revPosition = paramValues.getString("revPosition");
			}
			if(paramValues.has("scaleWidth")){
				scaleWidth = paramValues.getString("scaleWidth");
			}
			if(paramValues.has("scaleHeight")){
				scaleHeight = paramValues.getString("scaleHeight");
			}
			if(paramValues.has("scaleX")){
				scaleX = paramValues.getString("scaleX");
			}
			if(paramValues.has("scaleY")){
				scaleY = paramValues.getString("scaleY");
			}
			if(paramValues.has("revScaleWidth")){
				revScaleWidth = paramValues.getString("revScaleWidth");
			}
			if(paramValues.has("revScaleHeight")){
				revScaleHeight = paramValues.getString("revScaleHeight");
			}
			if(paramValues.has("revScaleX")){
				revScaleX = paramValues.getString("revScaleX");
			}
			if(paramValues.has("revScaleY")){
				revScaleY = paramValues.getString("revScaleY");
			}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ScaleParamValues(delay, duration, reverse, waitingTime, revDuration, repeatCount, repeatForever, opacity, position, revPosition, scaleWidth, scaleHeight, scaleX, scaleY, revScaleWidth, revScaleHeight, revScaleX, revScaleY);
	}
	// ScaleMove
	private ScaleMoveParamValues getScaleMoveParamValues(JSONObject paramValues) {
		String delay=null;
		String duration=null;
		String reverse=null;
		String waitingTime=null; 
		String revDuration=null;
		String repeatCount=null;
		String repeatForever=null;
		String opacity=null;
		String position=null;
		String revPosition=null;
		String scaleWidth=null;
		String scaleHeight=null;
		String scaleX=null;
		String scaleY=null;
		String revScaleWidth=null;
		String revScaleHeight=null;
		String revScaleX=null;
		String revScaleY=null;
		try {
			if(paramValues.has("delay")){
				delay = paramValues.getString("delay");
				Log.e("", delay);
			}
			if(paramValues.has("duration")){
				duration = paramValues.getString("duration");
				Log.e("", duration);
			}
			if(paramValues.has("reverse")){
				reverse = paramValues.getString("reverse");
				Log.e("", reverse);
			}
			if(paramValues.has("waitingTime")){
				waitingTime = paramValues.getString("waitingTime");
				Log.e("", waitingTime);
			}
			if(paramValues.has("revDuration")){
				revDuration = paramValues.getString("revDuration");
				Log.e("", revDuration);
			}
			if(paramValues.has("repeatCount")){
				repeatCount = paramValues.getString("repeatCount");
				Log.e("", repeatCount);
			}
			if(paramValues.has("repeatForever")){
				repeatForever = paramValues.getString("repeatForever");
				Log.e("", repeatForever);
			}
			if(paramValues.has("opacity")){
				opacity = paramValues.getString("opacity");
				Log.e("", opacity);
			}
			if(paramValues.has("position")){
				position = paramValues.getString("position");
			}
			if(paramValues.has("revPosition")){
				revPosition = paramValues.getString("revPosition");
			}
			if(paramValues.has("scaleWidth")){
				scaleWidth = paramValues.getString("scaleWidth");
			}
			if(paramValues.has("scaleHeight")){
				scaleHeight = paramValues.getString("scaleHeight");
			}
			if(paramValues.has("scaleX")){
				scaleX = paramValues.getString("scaleX");
			}
			if(paramValues.has("scaleY")){
				scaleY = paramValues.getString("scaleY");
			}
			if(paramValues.has("revScaleWidth")){
				revScaleWidth = paramValues.getString("revScaleWidth");
			}
			if(paramValues.has("revScaleHeight")){
				revScaleHeight = paramValues.getString("revScaleHeight");
			}
			if(paramValues.has("revScaleX")){
				revScaleX = paramValues.getString("revScaleX");
			}
			if(paramValues.has("revScaleY")){
				revScaleY = paramValues.getString("revScaleY");
			}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ScaleMoveParamValues(delay, duration, reverse, waitingTime, revDuration, repeatCount, repeatForever, opacity, position, revPosition, scaleWidth, scaleHeight, scaleX, scaleY, revScaleWidth, revScaleHeight, revScaleX, revScaleY);
	}
	// Rotate
	private RotateParamValues getRotateParamValues(JSONObject paramValues) {
		String delay=null;
		String duration=null;
		String reverse=null;
		String waitingTime=null; 
		String revDuration=null;
		String repeatCount=null;
		String repeatForever=null;
		String opacity=null;
		String angle=null;
		String revAngle=null;
		String revAnchorPoint=null;
		try {
			if(paramValues.has("delay")){
				delay = paramValues.getString("delay");
				Log.e("", delay);
			}
			if(paramValues.has("duration")){
				duration = paramValues.getString("duration");
				Log.e("", duration);
			}
			if(paramValues.has("reverse")){
				reverse = paramValues.getString("reverse");
				Log.e("", reverse);
			}
			if(paramValues.has("waitingTime")){
				waitingTime = paramValues.getString("waitingTime");
				Log.e("", waitingTime);
			}
			if(paramValues.has("revDuration")){
				revDuration = paramValues.getString("revDuration");
				Log.e("", revDuration);
			}
			if(paramValues.has("repeatCount")){
				repeatCount = paramValues.getString("repeatCount");
				Log.e("", repeatCount);
			}
			if(paramValues.has("repeatForever")){
				repeatForever = paramValues.getString("repeatForever");
				Log.e("", repeatForever);
			}
			if(paramValues.has("opacity")){
				opacity = paramValues.getString("opacity");
				Log.e("", opacity);
			}
			if(paramValues.has("angle")){
				angle = paramValues.getString("angle");
			}
			if(paramValues.has("revAngle")){
				revAngle = paramValues.getString("revAngle");
			}
			if(paramValues.has("revAnchorPoint")){
				revAnchorPoint = paramValues.getString("revAnchorPoint");
			}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RotateParamValues(delay, duration, reverse, waitingTime, revDuration, repeatCount, repeatForever, opacity, angle, revAngle, revAnchorPoint);
	}
	// Animation
	private AnimationParamValues getAnimationParamValues(JSONObject paramValues) {
		String delay=null;
		String duration=null;
		String reverse=null;
		String waitingTime=null; 
		String revDuration=null;
		String repeatCount=null;
		String repeatForever=null;
		String opacity=null;
		String aniImage=null;
		String aniImageName=null;
		String aniImages=null;
		String aniPath=null;
		String autoReverse=null;
		String restoreOrigin=null;
		try {
			if(paramValues.has("delay")){
				delay = paramValues.getString("delay");
				Log.e("", delay);
			}
			if(paramValues.has("duration")){
				duration = paramValues.getString("duration");
				Log.e("", duration);
			}
			if(paramValues.has("reverse")){
				reverse = paramValues.getString("reverse");
				Log.e("", reverse);
			}
			if(paramValues.has("waitingTime")){
				waitingTime = paramValues.getString("waitingTime");
				Log.e("", waitingTime);
			}
			if(paramValues.has("revDuration")){
				revDuration = paramValues.getString("revDuration");
				Log.e("", revDuration);
			}
			if(paramValues.has("repeatCount")){
				repeatCount = paramValues.getString("repeatCount");
				Log.e("", repeatCount);
			}
			if(paramValues.has("repeatForever")){
				repeatForever = paramValues.getString("repeatForever");
				Log.e("", repeatForever);
			}
			if(paramValues.has("opacity")){
				opacity = paramValues.getString("opacity");
				Log.e("", opacity);
			}
			if(paramValues.has("aniImage")){
				aniImage = paramValues.getString("aniImage");
			}
			if(paramValues.has("aniImageName")){
				aniImageName = paramValues.getString("aniImageName");
			}
			if(paramValues.has("aniImages")){
				aniImages = paramValues.getString("aniImages");
			}
			if(paramValues.has("aniPath")){
				aniPath = paramValues.getString("aniPath");
			}
			if(paramValues.has("autoReverse")){
				autoReverse = paramValues.getString("autoReverse");
			}
			if(paramValues.has("restoreOrigin")){
				restoreOrigin = paramValues.getString("restoreOrigin");
			}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new AnimationParamValues(delay, duration, reverse, waitingTime, revDuration, repeatCount, repeatForever, opacity, aniImage, aniImageName, aniImages, aniPath, autoReverse, restoreOrigin);
	}
	// Play Media
	private PlayMediaParamValues getPlayMediaParamValues(JSONObject paramValues) {
		String mediaPath = null;
		String mediaObject = null;
		String useTimeLine = null;
		try {
			if(paramValues.has("mediaPath")){
				mediaPath = paramValues.getString("mediaPath");
			}
			if(paramValues.has("mediaObject")){
				mediaObject = paramValues.getString("mediaObject");
			}
			if(paramValues.has("useTimeLine")){
				useTimeLine = paramValues.getString("useTimeLine");
			}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new PlayMediaParamValues(mediaPath, mediaObject, useTimeLine);
	}
	// Particle
	private ParticleParamValues getParticleParamValues(JSONObject paramValues) {
		String particlePath = null;
		try {
			if(paramValues.has("particlePath")){
				particlePath = paramValues.getString("particlePath");
			}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ParticleParamValues(particlePath);
	}
	// Box2d
	private Box2dParamValues getBox2dParamValues(JSONObject paramValues) {
			String shapeType = null;
			String shapeScale = null;
			String verShape = null;
			String bodyAngle = null;
			String bodyDensity = null;
			String bodyRestitution = null;
			String fixedRotation = null;
			String staticBody = null;
			String subStaticBody = null;
			String bodyGroup = null;
			String vRope = null;
		try {
			if(paramValues.has("shapeType")){
				shapeType = paramValues.getString("shapeType");
			}
			if(paramValues.has("shapeScale")){
				shapeScale = paramValues.getString("shapeScale");
			}
			if(paramValues.has("verShape")){
				verShape = paramValues.getString("verShape");
			}
			if(paramValues.has("bodyAngle")){
				bodyAngle = paramValues.getString("bodyAngle");
			}
			if(paramValues.has("bodyDensity")){
				bodyDensity = paramValues.getString("bodyDensity");
			}
			if(paramValues.has("bodyRestitution")){
				bodyRestitution = paramValues.getString("bodyRestitution");
			}
			if(paramValues.has("fixedRotation")){
				fixedRotation = paramValues.getString("fixedRotation");
			}
			if(paramValues.has("staticBody")){
				staticBody = paramValues.getString("staticBody");
			}
			if(paramValues.has("subStaticBody")){
				subStaticBody = paramValues.getString("subStaticBody");
			}
			if(paramValues.has("bodyGroup")){
				bodyGroup = paramValues.getString("bodyGroup");
			}
			if(paramValues.has("vRope")){
				vRope = paramValues.getString("vRope");
			}
		} catch (JSONException je) {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Box2dParamValues(shapeType, shapeScale, verShape, bodyAngle, bodyDensity, bodyRestitution, fixedRotation, staticBody, subStaticBody, bodyGroup, vRope);
	}
	
}
