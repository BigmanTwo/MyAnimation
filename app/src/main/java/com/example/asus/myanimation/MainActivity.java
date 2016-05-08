package com.example.asus.myanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton1,mButton2,mButton3,mButton4,mButton5;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1=(Button)findViewById(R.id.obj_but);
        mButton2=(Button)findViewById(R.id.pve_but);
        mButton3=(Button)findViewById(R.id.set_but);
        mButton4=(Button)findViewById(R.id.layout_but);
        mButton5=(Button)findViewById(R.id.view_but);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mImageView=(ImageView)findViewById(R.id.image_test);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.obj_but:
                ObjAnimator();
                break;
            case R.id.pve_but:
                pvhAnimation();
                break;
            case R.id.set_but:
                setAnimator();
                break;
            case R.id.layout_but:
                 intent=new Intent(this,TransitonActivity.class);
                startActivity(intent);
                break;
            case R.id.view_but:
                intent=new Intent(this,LayoutAnimationActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void setAnimator() {
        //时间延迟启动
//        ObjectAnimator animation1=new ObjectAnimator().ofFloat(mImageView,"rotationX",0,360f).setDuration(1000);
//        ObjectAnimator animation3=new ObjectAnimator().ofFloat(mImageView,"alpha",1.0f,0.1f,1.0f).setDuration(3000);
//        ObjectAnimator animation4=new ObjectAnimator().ofFloat(mImageView,"scaleX",1.0f,0,1.0f).setDuration(4000);
//        ObjectAnimator animation5=new ObjectAnimator().ofFloat(mImageView,"translationX",0,400f).setDuration(4000);
        //属性延迟启动
       ObjectAnimator animation1=new ObjectAnimator().ofFloat(mImageView,"rotationX",0,360f);
        ObjectAnimator animation3=new ObjectAnimator().ofFloat(mImageView,"alpha",1.0f,0.1f,1.0f);
        ObjectAnimator animation4=new ObjectAnimator().ofFloat(mImageView,"scaleX",1.0f,0,1.0f);
        ObjectAnimator animation2=new ObjectAnimator().ofFloat(mImageView,"scaleY",1.0f,0,1.0f);
        ObjectAnimator animation5=new ObjectAnimator().ofFloat(mImageView,"translationX",0,400f);
        AnimatorSet animationSet=new AnimatorSet();
      //  animationSet.playTogether(animation1,animation3,animation4,animation5);
        //从1开始到5一直
        animationSet.play(animation5).after(animation4).after(animation3).after(animation1).after(animation2);
        animationSet.setDuration(4000);
        animationSet.start();
    }

    //创建多个属性动画
    private void pvhAnimation() {
        PropertyValuesHolder holderX=PropertyValuesHolder.ofFloat("scaleX",1.0f,0,1.0f);
        PropertyValuesHolder holderY=PropertyValuesHolder.ofFloat("scaleY",1.0f,0,1.0f);
        PropertyValuesHolder rotaX=PropertyValuesHolder.ofFloat("rotationX",1.0f,360f);
        ObjectAnimator animation=new ObjectAnimator().ofPropertyValuesHolder(mImageView,holderX,
                holderY,rotaX).setDuration(4000);
        animation.start();
    }
    //单一属性
    private void ObjAnimator() {
        //缩放
//        ObjectAnimator animator=new ObjectAnimator().ofFloat(mImageView,"scaleX",1.0f,0,1.0f);
        //旋转效果
//        ObjectAnimator animator=new ObjectAnimator().ofFloat(mImageView,"rotationX",1.0f,360f);
//        ObjectAnimator animator1=new ObjectAnimator().ofFloat(mImageView,"rotationY",1.0f,360f);
        //移动
        ObjectAnimator animator=new ObjectAnimator().ofFloat(mImageView,"translationX",0,189f);
        //淡入
//        ObjectAnimator animator=new ObjectAnimator().ofFloat(mImageView,"alpha",1.0f,0.1f);
//        ObjectAnimator animator=new ObjectAnimator().ofFloat(mImageView,"rotationX",1.0f,360f);
        animator.setDuration(4000);
//        animator1.setDuration(4000);
        animator.start();
//        animator1.start();
    }

}
