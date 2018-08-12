package com.updog.greencap.updogschoolalpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LaunchActivity extends Activity {
  private static int SPLASH_TIME_OUT = 5000;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_launch);

    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        Intent homeIntent = new Intent(LaunchActivity.this, MiniGameStart.class);
        startActivity(homeIntent);
        finish();
      }
    }, SPLASH_TIME_OUT);
  }
}
