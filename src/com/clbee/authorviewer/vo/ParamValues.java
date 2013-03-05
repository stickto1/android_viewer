package com.clbee.authorviewer.vo;

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

public class ParamValues {
	AnimationParamValues mAnimationParamValues;
	BezierMoveParamValues mBezierMoveParamValues;
	Box2dParamValues mBox2dParamValues;
	FadeParamValues mFadeParamValues;
	JumpParamValues mJumpParamValues;
	MoveParamValues mMoveParamValues;
	ParticleParamValues mParticleParamValues;
	PlayMediaParamValues mPlayMediaParamValues;
	RotateParamValues mRotateParamValues;
	ScaleMoveParamValues mScaleMoveParamValues;
	ScaleParamValues mScaleParamValues;
	public ParamValues(AnimationParamValues mAnimationParamValues,
			BezierMoveParamValues mBezierMoveParamValues,
			Box2dParamValues mBox2dParamValues,
			FadeParamValues mFadeParamValues, JumpParamValues mJumpParamValues,
			MoveParamValues mMoveParamValues,
			ParticleParamValues mParticleParamValues,
			PlayMediaParamValues mPlayMediaParamValues,
			RotateParamValues mRotateParamValues,
			ScaleMoveParamValues mScaleMoveParamValues,
			ScaleParamValues mScaleParamValues) {
		super();
		this.mAnimationParamValues = mAnimationParamValues;
		this.mBezierMoveParamValues = mBezierMoveParamValues;
		this.mBox2dParamValues = mBox2dParamValues;
		this.mFadeParamValues = mFadeParamValues;
		this.mJumpParamValues = mJumpParamValues;
		this.mMoveParamValues = mMoveParamValues;
		this.mParticleParamValues = mParticleParamValues;
		this.mPlayMediaParamValues = mPlayMediaParamValues;
		this.mRotateParamValues = mRotateParamValues;
		this.mScaleMoveParamValues = mScaleMoveParamValues;
		this.mScaleParamValues = mScaleParamValues;
	}
	public AnimationParamValues getmAnimationParamValues() {
		return mAnimationParamValues;
	}
	public void setmAnimationParamValues(AnimationParamValues mAnimationParamValues) {
		this.mAnimationParamValues = mAnimationParamValues;
	}
	public BezierMoveParamValues getmBezierMoveParamValues() {
		return mBezierMoveParamValues;
	}
	public void setmBezierMoveParamValues(
			BezierMoveParamValues mBezierMoveParamValues) {
		this.mBezierMoveParamValues = mBezierMoveParamValues;
	}
	public Box2dParamValues getmBox2dParamValues() {
		return mBox2dParamValues;
	}
	public void setmBox2dParamValues(Box2dParamValues mBox2dParamValues) {
		this.mBox2dParamValues = mBox2dParamValues;
	}
	public FadeParamValues getmFadeParamValues() {
		return mFadeParamValues;
	}
	public void setmFadeParamValues(FadeParamValues mFadeParamValues) {
		this.mFadeParamValues = mFadeParamValues;
	}
	public JumpParamValues getmJumpParamValues() {
		return mJumpParamValues;
	}
	public void setmJumpParamValues(JumpParamValues mJumpParamValues) {
		this.mJumpParamValues = mJumpParamValues;
	}
	public MoveParamValues getmMoveParamValues() {
		return mMoveParamValues;
	}
	public void setmMoveParamValues(MoveParamValues mMoveParamValues) {
		this.mMoveParamValues = mMoveParamValues;
	}
	public ParticleParamValues getmParticleParamValues() {
		return mParticleParamValues;
	}
	public void setmParticleParamValues(ParticleParamValues mParticleParamValues) {
		this.mParticleParamValues = mParticleParamValues;
	}
	public PlayMediaParamValues getmPlayMediaParamValues() {
		return mPlayMediaParamValues;
	}
	public void setmPlayMediaParamValues(PlayMediaParamValues mPlayMediaParamValues) {
		this.mPlayMediaParamValues = mPlayMediaParamValues;
	}
	public RotateParamValues getmRotateParamValues() {
		return mRotateParamValues;
	}
	public void setmRotateParamValues(RotateParamValues mRotateParamValues) {
		this.mRotateParamValues = mRotateParamValues;
	}
	public ScaleMoveParamValues getmScaleMoveParamValues() {
		return mScaleMoveParamValues;
	}
	public void setmScaleMoveParamValues(ScaleMoveParamValues mScaleMoveParamValues) {
		this.mScaleMoveParamValues = mScaleMoveParamValues;
	}
	public ScaleParamValues getmScaleParamValues() {
		return mScaleParamValues;
	}
	public void setmScaleParamValues(ScaleParamValues mScaleParamValues) {
		this.mScaleParamValues = mScaleParamValues;
	}
}
