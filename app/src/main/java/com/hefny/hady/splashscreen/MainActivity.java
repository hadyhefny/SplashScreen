package com.hefny.hady.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MaterialButton skipButton;
    private MaterialButton finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        Log.d(TAG, "onCreate: ");
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        skipButton = findViewById(R.id.btnSkip);
        finishButton = findViewById(R.id.btnFinish);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == adapter.getCount() - 1) {
                    skipButton.setVisibility(View.GONE);
                    finishButton.setVisibility(View.VISIBLE);
                } else {
                    skipButton.setVisibility(View.VISIBLE);
                    finishButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        finishButton.setOnClickListener(l -> launchMain2Activity());
        skipButton.setOnClickListener(l -> launchMain2Activity());
    }

    private void launchMain2Activity() {
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
        finish();
    }
}