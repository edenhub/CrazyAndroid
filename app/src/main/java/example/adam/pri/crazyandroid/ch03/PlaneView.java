package example.adam.pri.crazyandroid.ch03;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import example.adam.pri.crazyandroid.R;

/**
 * Created by lab on 2015/3/16.
 */
public class PlaneView extends View {
    public float currX,currY;
    public Bitmap plane;

    public PlaneView(Context context) {
        super(context);

        plane = BitmapFactory.decodeResource(context.getResources(), R.drawable.ss1);

        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        canvas.drawBitmap(plane,currX,currY,paint);
    }

    public float getCurrX() {
        return currX;
    }

    public void setCurrX(float currX) {
        this.currX = currX;
    }

    public float getCurrY() {
        return currY;
    }

    public void setCurrY(float currY) {
        this.currY = currY;
    }

    public Bitmap getPlane() {
        return plane;
    }

    public void setPlane(Bitmap plane) {
        this.plane = plane;
    }
}
