package com.example.evanzeng.viewpagertest.ViewPager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Evan Zeng on 2016/8/17.
 */

public class ZoomTransformation implements ViewPager.PageTransformer {

    private static final float MIN_SCALE=0.85f;
    private static final float MIN_ALPHA=0.5f;
    @Override
    public void transformPage(View page, float position) {
        int pageWidth=page.getWidth();
        int pageHeight=page.getHeight();
        if (position<-1){
//            page.setAlpha(0);
        }else if (position<=1){

            float scaleFactor=Math.max(MIN_SCALE,1-Math.abs(position));
            float vertMargin=pageHeight*(1-scaleFactor)/2;
            float horzMargin=pageWidth*(1-scaleFactor)/2;
            if (position<0){
                page.setTranslationX(horzMargin-vertMargin/2);
            }else {
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
                page.setAlpha(MIN_ALPHA+(scaleFactor-MIN_SCALE)/(1-MIN_SCALE)*(1-MIN_ALPHA));
            }
            page.setAlpha(1);
        }else {
//            page.setAlpha(0);
        }
    }
}
