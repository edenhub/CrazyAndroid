package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import example.adam.pri.crazyandroid.ch10.CountService;

/**
 * Created by lab on 2015/3/28.
 */
public class ch10_countservice_activity extends Activity {
    private Button btBind,btUnBind,btStatus;
    private CountService.MyCountBinder binder;
    private ServiceConnection serviceConnection = new MyServiceConnection();

    private static final String ACTION = "example.adam.pri.crazyandroid.COUNT_SERVICE";

    private static final String TAG = "== CountServiceActivity ==";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch10_countservice_activity);

        btBind = (Button)findViewById(R.id.ch10_countservice_btBind);
        btUnBind = (Button)findViewById(R.id.ch10_countservice_btUnBind);
        btStatus = (Button)findViewById(R.id.ch10_countservice_btStatus);

        final Intent intent = new Intent();
        intent.setAction(ACTION);

        btBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intent,serviceConnection, Service.BIND_AUTO_CREATE);
            }
        });

        btUnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(serviceConnection);
            }
        });

        btStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = binder.getCount();
                Toast.makeText(ch10_countservice_activity.this,"Count : "+count,Toast.LENGTH_LONG).show();
            }
        });
    }

    public class MyServiceConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.err.println(TAG+" onServiceConnected "+name.getClassName());

            binder = (CountService.MyCountBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.err.println(TAG+" onServiceDisconnected "+name.getClassName());
        }
    }
}
