package com.easymorse.viewflipper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
	
	ViewFlipper viewFlipper ;
	
	GestureDetector gestureDetector;
    private Context mContext;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mContext=this;
        Button buttonClick = (Button) findViewById(R.id.bt1);

        viewFlipper = (ViewFlipper)findViewById(R.id.myViewFlipper);
        
        viewFlipper.addView(getLayoutInflater().inflate(R.layout.textlayout, null),viewFlipper.getChildCount());
        viewFlipper.addView(getLayoutInflater().inflate(R.layout.sample1, null),viewFlipper.getChildCount());
        viewFlipper.addView(getLayoutInflater().inflate(R.layout.tbllayout, null),viewFlipper.getChildCount());

        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sets auto flipping
                Toast.makeText(getApplicationContext(), "Click! ",
                        Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sets auto flipping
                Toast.makeText(getApplicationContext(), "Click! ",
                        Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.SB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sets auto flipping
                viewFlipper.stopFlipping();

            }
        });
        findViewById(R.id.pb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sets auto flipping
                //sets auto flipping
                viewFlipper.setAutoStart(true);
                viewFlipper.setFlipInterval(4000);
                viewFlipper.startFlipping();

            }
        });
        gestureDetector = new GestureDetector(new OnGestureListener() {
			
			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onShowPress(MotionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
					float distanceY) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onLongPress(MotionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
					float velocityY) {
				if(velocityX>0){
					viewFlipper.showNext();
				}else {
					viewFlipper.showPrevious();
				}
				return false;
			}
			
			@Override
			public boolean onDown(MotionEvent e) {
				// TODO Auto-generated method stub
				return false;
			}
		});
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	gestureDetector.onTouchEvent(event);
    	return super.onTouchEvent(event);
    }

}