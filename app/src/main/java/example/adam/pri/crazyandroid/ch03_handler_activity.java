package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lab on 2015/3/16.
 */
public class ch03_handler_activity extends Activity{
    private ImageView imageView;
    private int[] images = {
            R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4
    };

    private int currId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch03_handler_activity);

        imageView = (ImageView)findViewById(R.id.ch03_handler_iv);
        imageView.setImageResource(currId);

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if (msg.what == 0x1219){
                    currId = (currId+1)%images.length;
                }

                imageView.setImageResource(images[currId]);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x1219);
            }
        },new Date(),1000);
    }
}
