package com.clbee.authorviewer;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
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
//		captionView.setText(getResources().getString(R.string.hello_world));
		captionView.setText("바깠어용");
	}
	
	
}
