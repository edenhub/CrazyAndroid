package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by adam on 2015/3/30.
 */
public class ch10_OrderBroadcast_activity extends Activity {
    private Button btSent;
    public static final String ORDER_ACTION = "ch10_OrderBroadcast_actvity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch10_broadcast_activity);
        btSent = (Button)findViewById(R.id.ch10_orderbrodcast_send_bt);

        btSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(ORDER_ACTION);
                intent.putExtra("msg","From order activity ");

                sendOrderedBroadcast(intent,null);
            }
        });
    }
}
