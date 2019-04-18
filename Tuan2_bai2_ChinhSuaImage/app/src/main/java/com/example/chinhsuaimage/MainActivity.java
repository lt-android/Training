package com.example.chinhsuaimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private CheckBox check1, check2;
    private ImageView image1, image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListnerToCheckBox();
    }
    public void addListnerToCheckBox(){
        check1 = (CheckBox) findViewById(R.id.Eye);
        check2 = (CheckBox) findViewById(R.id.Smile);
        image1 = (ImageView) findViewById(R.id.ImageEye);
        image2 = (ImageView) findViewById(R.id.ImageSmile);

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                if (((CheckBox) a).isChecked()) {
                    image1.setImageResource(R.drawable.eye);
                    image1.setVisibility(View.VISIBLE);
                }else image1.setVisibility(View.INVISIBLE);
            }
        });
        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                if (((CheckBox) b).isChecked()){
                    image2.setImageResource(R.drawable.smile);
                    image2.setVisibility(View.VISIBLE);
                }else image2.setVisibility(View.INVISIBLE);
            }
        });
    }
}
