package example.adam.pri.crazyandroid.ch10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by adam on 2015/3/31.
 */
public class OrderBrocastReceiverA extends BroadcastReceiver {
    private static final String TAG = "===== OrderBroadcastReceiverA ======";

    @Override
    public void onReceive(Context context, Intent intent) {
        System.err.println(TAG+" : onReceive. . .");

        String msg = intent.getStringExtra("msg");

        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();

        Bundle bundle = new Bundle();
        bundle.putString("msgA","here is the msg from A");
        setResultExtras(bundle);

//        abortBroadcast();
    }
}
