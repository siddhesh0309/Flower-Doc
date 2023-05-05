package com.codewithchang.mlhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.codewithchang.mlhub.bottomActivities.WetherActivity;

public class PestsActivity extends AppCompatActivity {

    private TextView scaleTv, thripsTv, aphideTv, mealybugsTv, whitefilesTv, spidermitesTv, caterpillerTv, leafbettleTv, cutwormsTv, leafMinerTv;
    private CardView scaleIv, thripsIv, aphideIv, mealybugsIv, whitefilesIv, spidermitesIv, caterpillerIv, leafbettleIv, cutwormsIv, leafMinerIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pests);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ImageView backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PestsActivity.this, WetherActivity.class));
                finish();
            }
        });

        scaleTv = findViewById(R.id.scales);
        thripsTv = findViewById(R.id.thrip);
        aphideTv = findViewById(R.id.aphids);
        mealybugsTv = findViewById(R.id.mealybugs);
        whitefilesTv = findViewById(R.id.whitefiles);
        spidermitesTv = findViewById(R.id.spidermites);
        caterpillerTv = findViewById(R.id.caterpiller);
        leafbettleTv = findViewById(R.id.leaf_bettl);
        cutwormsTv = findViewById(R.id.cutworms);
        leafMinerTv = findViewById(R.id.leaf_miner);

        scaleIv = findViewById(R.id.scale_image);
        thripsIv = findViewById(R.id.thrips_image);
        aphideIv = findViewById(R.id.aphids_image);
        mealybugsIv = findViewById(R.id.mealybugs_image);
        whitefilesIv = findViewById(R.id.whitefiles_image);
        spidermitesIv = findViewById(R.id.spidermites_image);
        caterpillerIv = findViewById(R.id.caterpiller_image);
        leafbettleIv = findViewById(R.id.leaf_bettl_image);
        cutwormsIv = findViewById(R.id.cutworms_image);
        leafMinerIv = findViewById(R.id.leaf_miner_image);

        scaleTv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        scaleIv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        thripsTv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        thripsIv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        aphideTv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        aphideIv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        mealybugsTv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        mealybugsIv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        whitefilesTv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        whitefilesIv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        spidermitesTv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        spidermitesIv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        caterpillerTv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        caterpillerIv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        leafbettleTv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        leafbettleIv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        cutwormsTv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        cutwormsIv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        leafMinerTv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));
        leafMinerIv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left));

    }
}
