package com.clbee.authorviewer;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.kic.basicAnimation.BasicAnimation;
import com.kic.util.JsonUtil;


import android.os.Bundle;
import android.app.Activity;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements AnimationListener {
	private ImageView mTargetView;
	private BasicAnimation basicAni;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		setText();
	}

	private void findView() {
		mTargetView = (ImageView) findViewById(R.id.captionView);
	}

	private void setText() {
		JsonUtil jsonUtil = new JsonUtil();
//		String jsonResult = jsonUtil.getJsonStringFromFile("docu", "raw", this);
//		String jsonResult = jsonUtil.getJsonStringFromFile("view", "raw", this);
		String jsonResult = jsonUtil.getJsonStringFromFile("test", "raw", this);
		jsonUtil.jsonParser(jsonResult);
//		TestKeyName keyName = jsonUtil.jsonStringToClass(jsonResult);
//		jsonUtil.jsonParser(jsonResult);
		
		
		
		
		
		basicAni = new BasicAnimation();
		Animation scaleAnimation = basicAni.ScaleAni(0, 10, 0, 10, Animation.ABSOLUTE, 0.5f,
				Animation.ABSOLUTE, 0.5f, 3000);
		basicAni.setAniOption(true, 0, 0, new LinearInterpolator(), 0);
		basicAni.addAnimationList(scaleAnimation);

		Animation translateAnimation = basicAni.TranslateAni(Animation.ABSOLUTE, 0,
				Animation.ABSOLUTE, 200, Animation.ABSOLUTE, 0,
				Animation.ABSOLUTE, 200, 2000);
		basicAni.setAniOption(true, 0, 0, new LinearInterpolator(), 0);
		basicAni.addAnimationList(translateAnimation);


		Animation scaleAnimaion = basicAni.ScaleAni(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f, 3000);
		basicAni.addAnimationList(scaleAnimaion);
		
		Animation transAnimation2 = basicAni.TranslateAni(Animation.ABSOLUTE, 200,
				Animation.ABSOLUTE, 200, Animation.ABSOLUTE, 200,
				Animation.ABSOLUTE, 400, 3000);
		basicAni.setAniOption(true, 0, 0, new LinearInterpolator(), 0);
		basicAni.addAnimationList(transAnimation2);
		
		Animation rotateAnimation = basicAni.RotateAni(0, -180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, 3000);
		basicAni.addAnimationList(rotateAnimation);
		
		basicAni.startAnimation(mTargetView, 1);
		basicAni.getAni(0).setAnimationListener(this);
		basicAni.getAni(1).setAnimationListener(this);
		basicAni.getAni(2).setAnimationListener(this);
		basicAni.getAni(3).setAnimationListener(this);
		basicAni.getAni(4).setAnimationListener(this);

		// basicAni.AlphaAni(0, 100, 5000);
		// basicAni.addAniList();

	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
//		if (animation.equals(basicAni.getAni(0))) {
//			basicAni.startAnimation(mTargetView, 1);
//		} else if (animation.equals(basicAni.getAni(1))) {
//			basicAni.startAnimation(mTargetView, 2);
//		} else if (animation.equals(basicAni.getAni(2))) {
//			basicAni.startAnimation(mTargetView, 3);
//		} else if (animation.equals(basicAni.getAni(3))) {
//			basicAni.startAnimation(mTargetView, 4);
//		} else if (animation.equals(basicAni.getAni(4))) {
//			basicAni.startAnimation(mTargetView, 0);
//		}
		
		
		if (animation.equals(basicAni.getAni(0))) {
			basicAni.startAnimation(mTargetView, 1);
		} else if (animation.equals(basicAni.getAni(1))) {
			basicAni.startAnimation(mTargetView, 2);
		} else if (animation.equals(basicAni.getAni(2))) {
			basicAni.startAnimation(mTargetView, 3);
		} else if (animation.equals(basicAni.getAni(3))) {
			basicAni.startAnimation(mTargetView, 4);
		} else if (animation.equals(basicAni.getAni(4))) {
			basicAni.startAnimation(mTargetView, 0);
		}

	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub

	}

}
