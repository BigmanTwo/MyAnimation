package com.example.asus.myanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TransitonActivity extends AppCompatActivity {
    private ListView mListView;
    private List<String> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transiton);
        mListView=(ListView)findViewById(R.id.animation_list);
        mList=new ArrayList<>();
        for (int i=0;i<10;i++) {
            mList.add("数据添加"+i);
        }
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,mList);
        mListView.setAdapter(adapter);

    }
}
