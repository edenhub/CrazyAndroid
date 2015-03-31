package example.adam.pri.crazyandroid.ch10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by adam on 2015/3/31.
 */
public class OrderBrocastReceiverB extends BroadcastReceiver {
    private static final String TAG = "====== OrderBbrodcastReceiveB  =====";

    @Override
    public void onReceive(Context context, Intent intent) {
        System.err.println(TAG+" : onReceive");

        String msg = intent.getStringExtra("msg");

        Bundle bundle = getResultExtras(true);
        String msgA = bundle.getString("msgA");

        Toast.makeText(context,msg+" : "+msgA,Toast.LENGTH_LONG).show();
    }
}
