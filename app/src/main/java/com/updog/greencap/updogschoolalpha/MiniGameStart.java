package com.updog.greencap.updogschoolalpha;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;


public class MiniGameStart extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener, View.OnTouchListener {
    String msg;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game_start);

        final TextView textView = findViewById(R.id.minigame);
        final ImageView virgula = findViewById(R.id.button7);
        final ConstraintLayout layout = findViewById(R.id.layout1);

        layout.setOnDragListener(this);
        virgula.setOnLongClickListener(this);
        virgula.setOnTouchListener(this);

        virgula.setTag(virgula);

        HashMap<String, String> map = new HashMap<>();

        map.put("AS manca o para", ",");
        map.put("Un pui merge pe uscat", ",");
        map.put("O gaina alearga", ",");

        textView.setText("ghita");


//    Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
//    textView.startAnimation(animFadeOut);


//animation to move textView and then make it fadeaway
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
    }
//    DisplayMetrics displayMetrics = new DisplayMetrics();
//    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//    int height = displayMetrics.heightPixels; take the screen height and display it useful for other shit

    // drag and drop operation hopefully it works;


    @Override
    public boolean onLongClick(View v) {
        ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

        ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
        View.DragShadowBuilder myShadow = new View.DragShadowBuilder(v);

        v.startDrag(dragData, myShadow, v, 0);
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);

            v.startDrag(data, shadowBuilder, v, 0);
            v.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d(msg, "Action drag started");
                v.invalidate();
                break;

            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d(msg, "Action drag entered");
                v.invalidate();
                break;

            case DragEvent.ACTION_DRAG_EXITED:
                Log.d(msg, "Action drag exited");
                v.invalidate();
                break;

            case DragEvent.ACTION_DRAG_LOCATION:
                Log.d(msg, "Action drag location");
                break;

            case DragEvent.ACTION_DRAG_ENDED:
                Log.d(msg, "Action drag ended");
                v.invalidate();
                break;

            case DragEvent.ACTION_DROP:
                v.invalidate();

            default:
                break;
        }
        return false;
    }
}
