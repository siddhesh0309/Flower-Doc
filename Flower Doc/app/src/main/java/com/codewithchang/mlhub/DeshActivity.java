package com.codewithchang.mlhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.codewithchang.mlhub.bottomActivities.WetherActivity;

import java.util.Locale;

public class DeshActivity extends AppCompatActivity {

    Button getStarted, languageBtn;
    SharedPreferences onBoardingScreen;
    LinearLayout languageLL, logoLL, buttonLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desh);

        getStarted = findViewById(R.id.getStartedBtn);
        languageLL = findViewById(R.id.languageLL);
        logoLL = findViewById(R.id.logoLL);
        buttonLL = findViewById(R.id.ll2);

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

                if (isFirstTime) {
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();
                    startActivity(new Intent(DeshActivity.this, OnBoardingActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(DeshActivity.this, WetherActivity.class));
                    finish();
                }
            }
        });


    }
}
