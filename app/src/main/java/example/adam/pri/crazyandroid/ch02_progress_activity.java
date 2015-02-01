package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by lab on 2015/2/1.
 */
public class ch02_progress_activity extends Activity {
    int state = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_PROGRESS);
        setProgress(500);
        setContentView(R.layout.activity_ch02_progress_activity);

        final Button start = (Button)findViewById(R.id.ch02_progress_start_bt);
        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.ch02_progress_pb);

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {

                if (msg.what == 0x1111){
                    progressBar.setProgress(state);
                }
            }
        };

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setEnabled(false);
                Thread thread = new Thread(new Runnable() {
                    Random random = new Random();
                    @Override
                    public void run() {
                        while(state <= 100){
                            int increate = random.nextInt(10);
                            state += increate;

                            Message message = new Message();
                            message.what = 0x1111;

                            handler.sendMessage(message);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();
            }
        });

        SeekBar seekBar = (SeekBar)findViewById(R.id.ch02_progress_sb);
        final ImageView imageView = (ImageView)findViewById(R.id.ch02_progress_iv);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                imageView.setAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final RatingBar ratingBar = (RatingBar)findViewById(R.id.ch02_progress_rb);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                ratingBar.setEnabled(false);
//                Toast toast = new Toast(ch02_progress_activity.this);
//                toast.setText(rating+"");
//                toast.setDuration(Toast.LENGTH_LONG);
//                toast.show();
            }
        });
    }
}
