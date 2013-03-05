package com.kic.basicAnimation;

import java.util.ArrayList;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * 
 */
public class BasicAnimation {
	private Animation mAnimation = null;
	private ArrayList<Animation> mAnimaitonList;

	public BasicAnimation() {
		mAnimaitonList = new ArrayList<Animation>();
	}

	
	public Animation TranslateAni(int fromXType, float fromXValue, int toXType,
			float toXValue, int fromYType, float fromYValue, int toYType,
			float toYValue, int duration) {
		mAnimation = new TranslateAnimation(fromXType, fromXValue, toXType, toXValue,
				fromYType, fromYValue, toYType, toYValue);
		mAnimation.setDuration(duration); // 실행시간
		
		return mAnimation;
	}

	public Animation ScaleAni(float fromX, float toX, float fromY, float toY,
			int pivotXType, float pivotXValue, int pivotYType,
			float pivotYValue, int duration) {
		mAnimation = new ScaleAnimation(fromX, toX, fromY, toY, pivotXType,
				pivotXValue, pivotYType, pivotYValue);
		mAnimation.setDuration(duration); // 실행시간
		
		return mAnimation;
	}

	public Animation RotateAni(float fromDegrees, float toDegrees, int pivotXType,
			float pivotXValue, int pivotYType, float pivotYValue, int duration) {
		mAnimation = new RotateAnimation(fromDegrees, toDegrees, pivotXType,
				pivotXValue, pivotYType, pivotYValue);
		mAnimation.setDuration(duration); // 실행시간
		
		return mAnimation;
	}

	public Animation AlphaAni(float fromAlpha, float toAlpha, int duration) {
		mAnimation = new AlphaAnimation(fromAlpha, toAlpha);
		mAnimation.setDuration(duration); // 실행시간
		
		return mAnimation;
	}

	public void setAniOption(boolean fillAfter, int repeatMode,
			long startOffset, Interpolator interpolator, int zAdjustment) {
		mAnimation.setFillAfter(fillAfter); // 마지막 상태 유지
		mAnimation.setRepeatCount(repeatMode);// 반복 횟수, 0 반복 안함, INFINITE 무한반복
		mAnimation.setStartOffset(startOffset);// 애니메이션 시작전 대기시간
		mAnimation.setInterpolator(interpolator);// 속도 변화 방식
		mAnimation.setZAdjustment(zAdjustment);// 애니매이션중 다른 뷰와 겹칠때 순서
											// ZORDER_NORMAL:원래값
											// 유지,ZORDER_TOP:원래값
											// 최상위,ZORDER_BOTTOM:최하위
	}

	public Animation getAni(int index) {
		return mAnimaitonList.get(index);
	}

	public void startAnimation(View view, int index) {
		view.startAnimation(mAnimaitonList.get(index));
	}

	public void addAnimationList(Animation animation) {
		mAnimaitonList.add(animation);
	}
	
	public void clearAnimationList() {
		if(mAnimaitonList != null) {
			mAnimaitonList.removeAll(mAnimaitonList);
		}
	}

}
