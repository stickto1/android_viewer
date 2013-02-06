package com.clbee.authorviewer;

import com.kic.basicAni.BasicAnimation;

import android.R.interpolator;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements AnimationListener {
	private ImageView captionView;
	private BasicAnimation basicAni;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		setText();
	}

	private void findView() {
		captionView = (ImageView) findViewById(R.id.captionView);
	}

	private void setText() {
		basicAni = new BasicAnimation();
		basicAni.ScaleAni(0, 5, 0, 5, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f, 3000);
		basicAni.setAniOption(true, 0, 0, new LinearInterpolator(), 0);
		basicAni.addAniList();

		basicAni.TranslateAni(Animation.ABSOLUTE, 0,
				Animation.ABSOLUTE, 200, Animation.ABSOLUTE, 0,
				Animation.ABSOLUTE, 200, 2000);
		basicAni.setAniOption(true, 0, 0, new LinearInterpolator(), 0);
		basicAni.addAniList();


		basicAni.ScaleAni(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f, 3000);
		basicAni.addAniList();
		
		basicAni.TranslateAni(Animation.ABSOLUTE, 200,
				Animation.ABSOLUTE, 200, Animation.ABSOLUTE, 200,
				Animation.ABSOLUTE, 400, 3000);
		basicAni.setAniOption(true, 0, 0, new LinearInterpolator(), 0);
		basicAni.addAniList();
		
		basicAni.RotateAni(0, -180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f, 3000);
		basicAni.addAniList();
		
		basicAni.startAnimation(captionView, 0);
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
		if (animation.equals(basicAni.getAni(0))) {
			basicAni.startAnimation(captionView, 1);
		} else if (animation.equals(basicAni.getAni(1))) {
			basicAni.startAnimation(captionView, 2);
		} else if (animation.equals(basicAni.getAni(2))) {
			basicAni.startAnimation(captionView, 3);
		} else if (animation.equals(basicAni.getAni(3))) {
			basicAni.startAnimation(captionView, 4);
		} else if (animation.equals(basicAni.getAni(4))) {
			basicAni.startAnimation(captionView, 0);
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
