package example.adam.pri.crazyandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lab on 2015/3/16.
 */
public class ch03_drawview_view extends View {
    private float currX = 40;
    private float currY = 50;

    public ch03_drawview_view(Context context) {
        super(context);
    }

    public ch03_drawview_view(Context context,AttributeSet set){
        super(context,set);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        canvas.drawCircle(currX,currY,15,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currX = event.getX();
        currY = event.getY();

        this.invalidate();
        return true;
    }
}
