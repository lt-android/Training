package com.example.qlhtbongda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv1;
    ArrayList<football> fr = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1 = (ListView) findViewById(R.id.lv1);
        setevent();
    }
    public void setevent(){
        init();
        customadapter adapter = new customadapter(this,R.layout.list2_row,fr);
        lv1.setAdapter(adapter);
    }
    public void init(){
        fr.add(new football(R.string.ronaldo,R.string.des_ronaldo,R.drawable.ronaldo,R.drawable.brasil));
        fr.add(new football(R.string.zidane,R.string.des_zidane,R.drawable.zidane,R.drawable.france));

    }
}
