package com.example.bai3;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private RadioGroup radioG_animals;
    private RadioButton radioBtn_bird;
    private  RadioButton radioBtn_cat;
    private  RadioButton radioBtn_dog;
    private  RadioButton radioBtn_rabbit;
    private  RadioButton radioBtn_pig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.imageView = (ImageView) this.findViewById(R.id.imageView);
        this.radioBtn_bird = (RadioButton) this.findViewById(R.id.radioBtn_bird);
        this.radioBtn_cat = (RadioButton) this.findViewById(R.id.radioBtn_cat);
        this.radioBtn_dog = (RadioButton) this.findViewById(R.id.radioBtn_dog);
        this.radioBtn_rabbit = (RadioButton) this.findViewById(R.id.radioBtn_rabbit);
        this.radioBtn_pig = (RadioButton) this.findViewById(R.id.radioBtn_pig);
        this.radioG_animals = (RadioGroup) this.findViewById(R.id.radioG_animals);
        this.radioG_animals.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedld) {
                doOnDifficultyLevelChanged(group, checkedld);
            }
        });
    }
    private void showBird(){
        this.imageView.setImageResource(R.drawable.bird);
    }
    private void showCat(){
        this.imageView.setImageResource(R.drawable.cat);
    }
    private void showDog(){
        this.imageView.setImageResource(R.drawable.dog);
    }
    private void showRabbit(){
        this.imageView.setImageResource(R.drawable.rabbit);
    }
    private void showPig(){
        this.imageView.setImageResource(R.drawable.pig);
    }

    private void doOnDifficultyLevelChanged(RadioGroup group, int checkedld) {
        int checkedRadiold = group.getCheckedRadioButtonId();
        if(checkedRadiold==R.id.radioBtn_bird){
            showBird();
        } else if (checkedRadiold == R.id.radioBtn_cat){
            showCat();
        } else if (checkedRadiold == R.id.radioBtn_dog){
            showDog();
        } else if (checkedRadiold == R.id.radioBtn_rabbit){
            showRabbit();
        } else {
            showPig();
        }
    }
    }
