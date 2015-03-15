package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by lab on 2015/3/15.
 */
public class ch02_notification_activity extends Activity {
    private final int NOTI_ID = 0x1212;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch02_notification_activity);

        Button send = (Button)findViewById(R.id.ch02_notification_send_bt);
        Button cancle = (Button)findViewById(R.id.ch02_notification_cancle_bt);
        final NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ch02_notification_activity.this,ch02_notification_to_activity.class);
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(ch02_notification_activity.this,0,intent,0);

                Notification notification = new Notification();
                notification.icon = R.drawable.ss1;
                notification.when = System.currentTimeMillis();
                notification.defaults = Notification.DEFAULT_SOUND;
                notification.defaults = Notification.DEFAULT_LIGHTS;

                notification.setLatestEventInfo(ch02_notification_activity.this,"event","click",pendingIntent);

                notificationManager.notify(NOTI_ID,notification);
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationManager.cancel(NOTI_ID);
            }
        });

    }
}
