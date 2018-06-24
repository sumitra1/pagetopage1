package com.santoshjha.pagetopage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import jp.wasabeef.blurry.Blurry;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private boolean blurred;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        blurred=false;
    }

    public void page(View view) {
        LinearLayout linearLayout = findViewById(R.id.layout);
        linearLayout.setVisibility(View.VISIBLE);
        linearLayout.setAlpha(0.5f);
        ConstraintLayout constraintLayout = findViewById(R.id.con);
        if(blurred){
            Blurry.delete((ViewGroup)constraintLayout);
            linearLayout.setVisibility(View.INVISIBLE);
        }
        else {
            Blurry.with(MainActivity.this)
                    .radius(25)
                    .sampling(4)
                    .async()
                    .onto((ViewGroup)constraintLayout);
        }
        blurred=!blurred;
    }
}








