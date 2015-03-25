package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * Created by lab on 2015/3/25.
 */
public class ch08_viewfilpper_activity extends Activity implements
        GestureDetector.OnGestureListener {
    protected ViewFlipper viewFlipper;
    protected Animation[] animations;
    protected GestureDetector gestureDetector;
    private final int FLIP_DISTANCE = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch08_viewfilpper_activity);

        viewFlipper = (ViewFlipper)findViewById(R.id.ch08_viewflipper);
        animations = new Animation[]{
                AnimationUtils.loadAnimation(this,R.anim.abc_fade_in),
                AnimationUtils.loadAnimation(this,R.anim.abc_fade_out)
        };

        viewFlipper.addView(generateViewChild(R.drawable.p1));
        viewFlipper.addView(generateViewChild(R.drawable.p2));
        viewFlipper.addView(generateViewChild(R.drawable.p4));
        viewFlipper.addView(generateViewChild(R.drawable.p5));

        gestureDetector = new GestureDetector(this,this);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    protected View generateViewChild(int viewId){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(viewId);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        return imageView;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getX() - e2.getX() > FLIP_DISTANCE){//right
            viewFlipper.setOutAnimation(animations[1]);
            viewFlipper.setInAnimation(animations[0]);
            viewFlipper.showPrevious();

            return true;
        }else if (e1.getX() - e2.getX() < -FLIP_DISTANCE){//left
            viewFlipper.setInAnimation(animations[0]);
            viewFlipper.setOutAnimation(animations[1]);
            viewFlipper.showNext();

            return true;
        }

        return false;
    }
}
