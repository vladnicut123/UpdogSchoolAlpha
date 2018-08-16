package com.updog.greencap.updogschoolalpha;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;


public class MiniGameStart extends AppCompatActivity {
    private android.support.constraint.ConstraintLayout.LayoutParams layoutParams;
    String msg;

  @Override
  protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_mini_game_start);

      final TextView textView = findViewById(R.id.minigame);
      final Button virgula = findViewById(R.id.button7);

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
          public void onAnimationStart(Animation animation){

          }

          @Override
          public void onAnimationRepeat(Animation animation){

          }

          @Override
          public void onAnimationEnd(Animation animation){
              Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                      R.anim.fade_out);
              textView.startAnimation(animFadeOut);
          }
      });

//    DisplayMetrics displayMetrics = new DisplayMetrics();
//    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//    int height = displayMetrics.heightPixels; take the screen height and display it useful for other shit

      // drag and drop operation hopefully it works;

      virgula.setOnLongClickListener(new View.OnLongClickListener(){
          @Override
          public boolean onLongClick(View v) {
              ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
              String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

              ClipData dragData = new ClipData(v.getTag().toString(), mimeTypes, item);
              View.DragShadowBuilder myShadow = new View.DragShadowBuilder(virgula);

              v.startDrag(dragData, myShadow, null, 0);
              return true;
          }
      });

      virgula.setOnDragListener(new View.OnDragListener(){
          @Override
          public boolean onDrag(View v, DragEvent event) {
              switch(event.getAction()) {
                  case DragEvent.ACTION_DRAG_STARTED:
                      layoutParams = (ConstraintLayout.LayoutParams) v.getLayoutParams();
                      Log.d(msg, "Action drag started");
                      break;
                  case DragEvent.ACTION_DRAG_ENTERED:
                      Log.d(msg, "Action drag entered");
                      int x_cord = (int) event.getX();
                      int y_cord = (int) event.getY();
                      break;
                  case DragEvent.ACTION_DRAG_EXITED:
                      Log.d(msg, "Action drag exited");
                      x_cord = (int) event.getX();
                      y_cord = (int) event.getY();
                      layoutParams.leftMargin = x_cord;
                      layoutParams.topMargin = y_cord;
                      v.setLayoutParams(layoutParams);
                      break;
                  case DragEvent.ACTION_DRAG_LOCATION:
                      Log.d(msg, "Action drag location");
                      x_cord = (int) event.getX();
                      y_cord = (int) event.getY();
                      break;
                  case DragEvent.ACTION_DRAG_ENDED:
                      Log.d(msg, "Action drag ended");
                      break;
                  case DragEvent.ACTION_DROP:
                      break;



              }
              return true;
          }
      });

      virgula.setOnTouchListener(new View.OnTouchListener() {
          @Override
          public boolean onTouch(View v, MotionEvent event) {
              if (event.getAction() == MotionEvent.ACTION_DOWN) {
                  ClipData data = ClipData.newPlainText("", "");
                  View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(virgula);

                  virgula.startDrag(data, shadowBuilder, virgula, 0);
                  virgula.setVisibility(View.INVISIBLE);
                  return true;
              } else {
                  return false;
              }
          }
      });
//
//      textView.setOnLongClickListener(new View.OnLongClickListener() {
//        @Override
//        public boolean onLongClick(View v) {
//          ClipData.Item item = new ClipData.Item((String)v.getTag());
//          ClipData dragData = new ClipData((CharSequence)v.getTag(), new String [] {ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
//
//          View.DragShadowBuilder virgulaShadow = new MyDragShadowBuilder(virgula);
//
//          v.startDrag(dragData,
//                      virgulaShadow,
//                      null,
//                      0);
//          return false;
//        }
//      });
//
//      myDragEventListener dragListen = new myDragEventListener();
//
//      virgula.setOnDragListener(dragListen);
//  }
//
//    protected class myDragEventListener implements View.OnDragListener {
//
//        @Override
//        public boolean onDrag(View v, DragEvent event) {
//            final int action = event.getAction();
//
//            switch(action) {
//                case DragEvent.ACTION_DRAG_STARTED:
//                    if(event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
//                        v.invalidate();
//                        return true;
//                    }
//                    return false;
//
//                case DragEvent.ACTION_DRAG_ENTERED:
//                    v.invalidate();
//                    return true;
//
//                case DragEvent.ACTION_DRAG_LOCATION:
//                    return true;
//
//                case DragEvent.ACTION_DRAG_EXITED:
//                    v.invalidate();
//                    return true;
//
//                case DragEvent.ACTION_DROP:
//                    ClipData.Item item = event.getClipData().getItemAt(0);
//                    CharSequence dragData = item.getText();
//                    Toast.makeText(getApplicationContext(), dragData, Toast.LENGTH_SHORT);
//                    v.invalidate();
//                    return true;
//
//                case DragEvent.ACTION_DRAG_ENDED:
//                    v.invalidate();
//                    if(event.getResult()) {
//                        Toast.makeText(getApplicationContext(), "The drop was handled ", Toast.LENGTH_LONG);
//                    } else {
//                        Toast.makeText(getApplicationContext(), "The drop was not handled", Toast.LENGTH_LONG);
//                    }
//                    return true;
//
//                default:
//                    Log.e("Drag drop exmaple", "unknown message received");
//
//
//            }
//            return false;
//        }
//    }
  }
}
