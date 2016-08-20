package com.example.evanzeng.viewpagertest.ViewPager;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * Created by Administrator on 2016/8/19.
 */

public class MyAnimation extends Animation {

    private float centerX;
    private float centerY;
    private int duration;
    private float rotate;
    private Camera camera=new Camera();

    public MyAnimation(float x,float y,int duration,float rotate){
        centerX=x;
        centerY=y;
        this.duration=duration;
        this.rotate=rotate;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setDuration(duration);
        setFillAfter(true);
        setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        camera.save();
        camera.rotateY(rotate*(interpolatedTime));
        Matrix matrix=t.getMatrix();
        camera.getMatrix(matrix);
        matrix.preTranslate(-centerX,-centerY);
        matrix.postTranslate(centerX,centerY);
        camera.restore();
    }
}
