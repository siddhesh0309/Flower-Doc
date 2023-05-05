package com.codewithchang.mlhub.mainPageActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codewithchang.mlhub.R;

public class HowToDetect extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout layout_dots;
    private TextView[] tv_dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_detect);

        viewPager = findViewById(R.id.view_pager);
        layout_dots = findViewById(R.id.layout_dots);
        addDots(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                addDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void addDots(int position) {
        tv_dots = new TextView[5];
        layout_dots.removeAllViews();
        for (int i = 0; i < tv_dots.length; i++) {
            tv_dots[i] = new TextView(HowToDetect.this);
            tv_dots[i].setText(Html.fromHtml("&#8226"));
            tv_dots[i].setTextSize(35);
            tv_dots[i].setTextColor(getResources().getColor(R.color.black));
            layout_dots.addView(tv_dots[i]);
        }
        if (tv_dots.length > 0) {
            tv_dots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }
}