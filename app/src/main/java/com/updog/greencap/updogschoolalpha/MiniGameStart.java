package com.updog.greencap.updogschoolalpha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import java.util.HashMap;

public class MiniGameStart extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mini_game_start);
    final TextView textView = findViewById(R.id.minigame);

    HashMap<String, String> map = new HashMap<>();

    map.put("AS manca o para", ",");
    map.put("Un pui merge pe uscat", ",");
    map.put("O gaina alearga", ",");

    textView.setText("ghita");

//    Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
//    textView.startAnimation(animFadeOut);

    Animation animTranslate = AnimationUtils.loadAnimation(getApplicationContext(),
            R.anim.translate);

    textView.startAnimation(animTranslate);
    animTranslate.setFillAfter(true);

    animTranslate.setAnimationListener(new AnimationListener() {
      @Override
      public void onAnimationStart(Animation animation) {

      }

      @Override
      public void onAnimationRepeat(Animation animation) {

      }

      @Override
      public void onAnimationEnd(Animation animation) {
        Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_out);
        textView.startAnimation(animFadeOut);
      }
    });

    DisplayMetrics displayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    int height = displayMetrics.heightPixels;

  }
}
