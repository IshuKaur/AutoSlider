package com.example.ishpreetkaur.autoslider;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ArrayList<ImageView> imageViews;
    int currentPage = -1;
    private ViewPagerCustomDuration viewPager_slider;
    private Timer timer;
    private boolean isNumber = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager_slider = findViewById(R.id.pager_slider);
        imageViews = new ArrayList<>();
        imageViews.add((ImageView) findViewById(R.id.dot1));
        imageViews.add((ImageView) findViewById(R.id.dot2));
        imageViews.add((ImageView) findViewById(R.id.dot3));
        imageViews.add((ImageView) findViewById(R.id.dot4));
        imageViews.add((ImageView) findViewById(R.id.dot5));


        ImageViewDotSelection(0);
        MainPagerAdapter adapter_slider = new MainPagerAdapter(getSupportFragmentManager(), 5);
        viewPager_slider.setAdapter(adapter_slider);
        viewPager_slider.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                timer.cancel();
                return false;
            }
        });
        viewPager_slider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                ImageViewDotSelection(position);
                currentPage = position;
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(7000);
                alphaAnimation.setFillAfter(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (currentPage < 7 && !isNumber) {
                    currentPage++;
                    if (currentPage == 7) {
                        isNumber = true;
                    }
                } else {
                    currentPage--;
                    if (currentPage == 0) {
                        isNumber = false;
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("data", "" + currentPage);
                        viewPager_slider.setScrollDurationFactor(30);
                        viewPager_slider.setCurrentItem(currentPage, true);
                    }
                });
            }
        }, 1000, 7000);

    }

    private void ImageViewDotSelection(int selection) {
        for (int i = 0; i < imageViews.size(); i++) {
            if (i == selection) {
                imageViews.get(i).setBackgroundResource(R.drawable.polygon_selected);
            } else {
                imageViews.get(i).setBackgroundResource(R.drawable.polygon_unselected);
            }
        }
    }
}
