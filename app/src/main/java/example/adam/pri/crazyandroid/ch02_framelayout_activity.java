package example.adam.pri.crazyandroid;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class ch02_framelayout_activity extends ActionBarActivity {
    private int curr = 0;
    private int msg = 0x1122;

    private TextView[] tvs;
    private int[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch02_framelayout_activity);

        tvs = new TextView[]{
                (TextView)findViewById(R.id.ch02_framelayout_tv01),
                (TextView)findViewById(R.id.ch02_framelayout_tv02),
                (TextView)findViewById(R.id.ch02_framelayout_tv03),
                (TextView)findViewById(R.id.ch02_framelayout_tv04),
                (TextView)findViewById(R.id.ch02_framelayout_tv05),
                (TextView)findViewById(R.id.ch02_framelayout_tv06),
                (TextView)findViewById(R.id.ch02_framelayout_tv07)
        };

        colors = new int[]{
                R.color.color1,
                R.color.color2,
                R.color.color3,
                R.color.color4,
                R.color.color5,
                R.color.color6,
                R.color.color7
        };

        final Handler handler = new Handler(){

            @Override
            public void handleMessage(Message msg1) {
                if (msg1.what == msg){
                    for(int i=0;i<7;i++){
                        tvs[i].setBackgroundResource(colors[(i+curr)%7]);
                    }
                }
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                curr = (++curr)%7;

                Message message = new Message();
                message.what = msg;

                handler.sendMessage(message);
            }
        },0,200);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ch02_framelayout_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
