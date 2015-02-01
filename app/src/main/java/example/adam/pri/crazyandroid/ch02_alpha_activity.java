package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by lab on 2015/1/31.
 */
public class ch02_alpha_activity extends Activity {

    private Button plus,minus,next;
    private ImageView origin,detail;
    private int alpha=255;

    private final int[] images = new int[]{
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p4,
            R.drawable.p5
    };

    private int curr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch02_alpha_activity);

        plus = (Button)findViewById(R.id.ch02_alpha_plus_bt);
        minus = (Button)findViewById(R.id.ch02_alpha_minus_bt);
        next = (Button)findViewById(R.id.ch02_alpha_next_bt);

        origin = (ImageView)findViewById(R.id.ch02_alpha_iv_origin);
        detail = (ImageView)findViewById(R.id.ch02_alpha_iv_detail);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = (curr+1)%4;

                BitmapDrawable bitmapDrawable = (BitmapDrawable)origin.getDrawable();
                if (!bitmapDrawable.getBitmap().isRecycled())
                    bitmapDrawable.getBitmap().recycle();

                origin.setImageBitmap(BitmapFactory.decodeResource(getResources(),images[curr]));
                origin.setAlpha(alpha);
            }
        });

        AlphaListener alphaListener = new AlphaListener();
        plus.setOnClickListener(alphaListener);
        minus.setOnClickListener(alphaListener);

//        origin.setAlpha(alpha);
        origin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) origin.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();

                double scale = bitmap.getWidth() / 320.0;

                int x = (int)(event.getX() * scale);
                int y = (int)(event.getY() * scale);

                if(x + 120 > bitmap.getWidth())
                    x = bitmap.getWidth() - 120;
                if (y + 120 > bitmap.getHeight())
                    y = bitmap.getHeight() - 120;

                detail.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                detail.setAlpha(alpha);

                return true;
            }
        });


    }

    class AlphaListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) origin.getDrawable();
//            int alpha = bitmapDrawable.getAlpha();

            if (v == plus){
                alpha += 20;
                alpha = (alpha > 255 ) ? 255 : alpha;
            }else if (v == minus){
                alpha -= 20;
                alpha = (alpha < 0) ? 0 : alpha;
            }

            bitmapDrawable.setAlpha(alpha);
        }
    }
}
