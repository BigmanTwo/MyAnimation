package com.example.asus.myanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;

public class LayoutAnimationActivity extends AppCompatActivity implements View.OnClickListener{
    private int index;
    private Button addButton;
    private GridLayout mGridLayout;
    private CheckBox mCheckBox1,mCheckBox2,mCheckBox3,mCheckBox4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);
        addButton=(Button)findViewById(R.id.add_but);
        mCheckBox1=(CheckBox)findViewById(R.id.appear_check);
        mCheckBox2=(CheckBox)findViewById(R.id.disappeer_check);
        mCheckBox3=(CheckBox)findViewById(R.id.other_check);
        mCheckBox4=(CheckBox)findViewById(R.id.changedisappear_check);
        mGridLayout=(GridLayout)findViewById(R.id.grid_but);
        addButton.setOnClickListener(this);
    }
    private void addGridButton(){
        index++;
        final Button button=new Button(this);
        button.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setText("测试数据"+index);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mGridLayout.setLayoutTransition(getLayoutTransition());
                    mGridLayout.removeView(button);
                }
            });

        mGridLayout.setLayoutTransition(getLayoutTransition());
        //绑定下标，从第一号位置添加
        mGridLayout.addView(button,mGridLayout.getChildCount()>0?1:0);
//        mGridLayout.addView(button);
    }
    //创建动画
    private LayoutTransition getLayoutTransition(){
        LayoutTransition transition=new LayoutTransition();
        ObjectAnimator animator=new ObjectAnimator().ofFloat(this,"scaleX",0,1).setDuration(2000);
        ObjectAnimator disVisible=new ObjectAnimator().ofFloat(this,"rotationX",0,36f).setDuration(2000);
        ObjectAnimator other=new ObjectAnimator().ofFloat(this,"rotationX",0,360f).setDuration(4000);
        if (mCheckBox1.isChecked()){
            transition.setAnimator(LayoutTransition.APPEARING,animator);
        }
        if(mCheckBox2.isChecked()) {
            transition.setAnimator(LayoutTransition.DISAPPEARING,disVisible);
        }
        if (mCheckBox3.isChecked()){
            PropertyValuesHolder pvhTop=PropertyValuesHolder.ofInt("top",0,1);
            PropertyValuesHolder pvhLeft=PropertyValuesHolder.ofInt("left",0,1);
            PropertyValuesHolder pvhRight=PropertyValuesHolder.ofInt("right",0,1);
            PropertyValuesHolder pvhBottom=PropertyValuesHolder.ofInt("bottom",0,1);
            PropertyValuesHolder holderX=PropertyValuesHolder.ofFloat("scaleX",1,0,1);
            PropertyValuesHolder holderY=PropertyValuesHolder.ofFloat("scaleY",1,0,1);
            final ObjectAnimator animator1=new ObjectAnimator().ofPropertyValuesHolder(this,pvhLeft,pvhRight,pvhTop,pvhBottom,holderX,holderY);
            animator1.setDuration(4000);
            animator1.addListener(new AnimatorListenerAdapter() {
                                      @Override
                                      public void onAnimationEnd(Animator animation) {
                                          View view=(View)((ObjectAnimator)animation).getTarget();
                                          view.setScaleX(1);
                                          view.setScaleY(1);
                                      }
                                  }


            );

            transition.setAnimator(LayoutTransition.CHANGE_APPEARING,animator1);
        }
        if(mCheckBox4.isChecked()){
            PropertyValuesHolder pvhTop=PropertyValuesHolder.ofInt("top",0,1);
            PropertyValuesHolder pvhLeft=PropertyValuesHolder.ofInt("left",0,1);
            PropertyValuesHolder pvhRight=PropertyValuesHolder.ofInt("right",0,1);
            PropertyValuesHolder pvhBottom=PropertyValuesHolder.ofInt("bottom",0,1);
            PropertyValuesHolder holderX=PropertyValuesHolder.ofFloat("scaleX",1,0,1);
            PropertyValuesHolder holderY=PropertyValuesHolder.ofFloat("scaleY",1,0,1);
            final ObjectAnimator changeDisappear=new ObjectAnimator().ofPropertyValuesHolder(this,pvhLeft,pvhRight,pvhTop,pvhBottom,holderX,holderY);
            changeDisappear.setDuration(4000);
            changeDisappear.addListener(new AnimatorListenerAdapter() {
                                      @Override
                                      public void onAnimationEnd(Animator animation) {
                                          View view=(View)((ObjectAnimator)animation).getTarget();
                                          view.setScaleX(1);
                                          view.setScaleY(1);
                                      }
                                  }


            );

            transition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,changeDisappear);
        }
        return transition;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_but:
                addGridButton();
                break;
        }
    }
}
