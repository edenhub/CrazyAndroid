package example.adam.pri.crazyandroid.ch03;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import example.adam.pri.crazyandroid.ch03.PlaneView;

/**
 * Created by lab on 2015/3/16.
 */
public class DrawView extends Activity {
    private final int speed = 22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final PlaneView planeView = new PlaneView(this);

        setContentView(planeView);

        planeView.setBackgroundColor(Color.BLACK);

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();

        final int screenWidth = display.getWidth();
        final int screenHeight = display.getHeight();

        planeView.setCurrX(screenWidth / 2);
        planeView.setCurrY(screenHeight - 40);

        planeView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch(event.getKeyCode()){
                    case KeyEvent.KEYCODE_DPAD_DOWN :
                        planeView.currY += speed; break;

                    case KeyEvent.KEYCODE_DPAD_UP :
                        planeView.currY -= speed; break;

                    case KeyEvent.KEYCODE_DPAD_LEFT :
                        planeView.currX -= speed; break;

                    case KeyEvent.KEYCODE_DPAD_RIGHT :
                        planeView.currX += speed; break;
                }

                planeView.invalidate();
                return true;
            }
        });

        planeView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                planeView.currX = event.getX();
                planeView.currY = event.getY();

                planeView.invalidate();
                return true;
            }
        });
    }
}
