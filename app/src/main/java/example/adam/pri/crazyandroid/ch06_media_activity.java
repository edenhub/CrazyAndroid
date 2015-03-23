package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

/**
 * Created by lab on 2015/3/23.
 */
public class ch06_media_activity extends Activity {
    private MediaPlayer mediaPlayer1,mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch06_media_activity);

        Button rawBt = (Button)findViewById(R.id.ch06_media_row_bt);
        Button assertBt = (Button)findViewById(R.id.ch06_media_assert_bt);

        mediaPlayer1 = MediaPlayer.create(this,R.raw.music1);

        rawBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1.start();
            }
        });

        AssetManager assetManager = getAssets();
        try {
            AssetFileDescriptor assetFileDescriptor = assetManager.openFd("music2.mp3");
            mediaPlayer2 = new MediaPlayer();
            mediaPlayer2.setDataSource(assetFileDescriptor.getFileDescriptor());
            mediaPlayer2.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer2.start();
            }
        });


    }
}
