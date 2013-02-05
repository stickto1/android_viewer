package com.clbee.authorviewer;

import com.kic.basicAni.BasicAnimation;

import android.R.interpolator;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView captionView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		setText();
	}

	private void findView() {
		captionView = (TextView) findViewById(R.id.captionView);
	}

	private void setText() {
		// captionView.setText(getResources().getString(R.string.hello_world));
		captionView.setText("바깠어용");
		BasicAnimation.TranslateAni(Animation.RELATIVE_TO_SELF, 0,
				Animation.RELATIVE_TO_SELF, 2, Animation.RELATIVE_TO_PARENT, 0,
				Animation.RELATIVE_TO_PARENT, 0, 1000);
		BasicAnimation.setAniOption(true, 3, 0, new LinearInterpolator(), 0);
		BasicAnimation.startAnimation(captionView);
	}

}
