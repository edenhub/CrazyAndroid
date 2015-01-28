package example.adam.pri.crazyandroid.ch02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lab on 2015/1/28.
 */
public class DrawView extends View implements View.OnTouchListener{

    private float currX,currY;

    public DrawView(Context context) {
        super(context);
        currX = 0;
        currY = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(currX,currY,15,paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        currX = event.getX();
        currY = event.getY();

        System.err.println(currX+" : "+currY);
        this.invalidate();

        return true;
    }
}
