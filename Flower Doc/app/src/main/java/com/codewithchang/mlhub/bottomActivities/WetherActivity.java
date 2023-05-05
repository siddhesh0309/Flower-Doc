package com.codewithchang.mlhub.bottomActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.codewithchang.mlhub.PestsActivity;
import com.codewithchang.mlhub.R;
import com.codewithchang.mlhub.mainPageActivity.RoseDetection;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WetherActivity extends AppCompatActivity {

    RelativeLayout contentView, pests;
    CardView roseCard;
    Button detectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wether);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //detectBtn = (Button) findViewById(R.id.detectBtn);
        roseCard = (CardView) findViewById(R.id.roseCard);

        startActivties();

        pests = findViewById(R.id.pests);
        pests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WetherActivity.this, PestsActivity.class));
            }
        });

        contentView = findViewById(R.id.content_view);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.detect);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.detect:
                                return true;
                        }
                        return false;
                    }
                });
    }

    private void startActivties() {
//        detectBtn.setOnClickListener(view -> {
//            startActivity(new Intent(WetherActivity.this, TensorActivity.class));
//        });



        roseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WetherActivity.this, RoseDetection.class));
            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}