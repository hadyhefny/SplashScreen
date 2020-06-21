package com.hefny.hady.splashscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class SplashScreen extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    private static final String TAG = "SplashScreen";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String KEY = "ABCD";
    private static final boolean DEFAULT_VALUE = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        sharedPreferences = getPreferences(MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean(KEY, DEFAULT_VALUE)) {
            launchMainActivity();
        }
        editor.putBoolean(KEY, true);
        editor.apply();

        handler = new Handler();
        runnable = this::launchMainActivity;
        boolean value = handler.postDelayed(runnable, 1000);
        Log.d(TAG, "onCreate: " + value);
    }

    private void launchMainActivity() {
        startActivity(new Intent(SplashScreen.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}