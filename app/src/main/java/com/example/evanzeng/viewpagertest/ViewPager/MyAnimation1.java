package com.example.evanzeng.viewpagertest.ViewPager;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Administrator on 2016/8/20.
 */

public class MyAnimation1 extends Animation {
    private float centerX;
    private float centerY;
    private int duration;
    private Camera camera=new Camera();

    public MyAnimation1(float x,float y,int duration){
        centerX=x;
        centerY=y;
        this.duration=duration;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.setFillAfter(true);
        this.setDuration(duration);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        camera.save();
        camera.rotateY(-40*(interpolatedTime));
        Matrix matrix=t.getMatrix();
        camera.getMatrix(matrix);
        matrix.preTranslate(-centerX,-centerY);
        matrix.postTranslate(centerX,centerY);
        camera.restore();
    }
}
