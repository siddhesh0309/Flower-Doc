package com.codewithchang.mlhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codewithchang.mlhub.adapters.OnboardingAdapter;
import com.codewithchang.mlhub.bottomActivities.WetherActivity;
import com.codewithchang.mlhub.models.OnboardingItem;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicators;
    ViewPager2 onboardingViewPager;
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        layoutOnboardingIndicators = findViewById(R.id.layoutOnboardingIndicator);
        skip = findViewById(R.id.skip);

        setupOnboardingItems();

        onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setupOnboardingIndicators();
        setCurrentOnboardingIndicator(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), WetherActivity.class));
                finish();
            }
        });

    }

    private void setupOnboardingItems(){

        List<OnboardingItem> onboardingItems = new ArrayList<>();

        OnboardingItem itemTime = new OnboardingItem();
        itemTime.setTitle(getString(R.string.health_check));
        itemTime.setDescription(getString(R.string.health_check_tag));
        itemTime.setImage(R.drawable.onboard1);


        OnboardingItem itemFee = new OnboardingItem();
        itemFee.setTitle(getString(R.string.community));
        itemFee.setDescription(getString(R.string.community_tag));
        itemFee.setImage(R.drawable.onboard2);


        OnboardingItem itemSafe = new OnboardingItem();
        itemSafe.setTitle(getString(R.string.cultivation_tips));
        itemSafe.setDescription(getString(R.string.cultivation_tips_tag));
        itemSafe.setImage(R.drawable.onboard3);

        onboardingItems.add(itemTime);
        onboardingItems.add(itemFee);
        onboardingItems.add(itemSafe);

        onboardingAdapter = new OnboardingAdapter(onboardingItems);

    }

    private void setupOnboardingIndicators(){
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(8,0,8,0);
        for (int i =0 ; i < indicators.length ; i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicators.addView(indicators[i]);
        }
    }

    private void setCurrentOnboardingIndicator(int index){
        int childCount = layoutOnboardingIndicators.getChildCount();
        for(int i = 0 ; i < childCount; i++){
            ImageView imageView = (ImageView) layoutOnboardingIndicators.getChildAt(i);
            if(i==index){
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active));
            }
            else{

                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive));
            }
        }
    }
}