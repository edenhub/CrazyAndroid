package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lab on 2015/3/20.
 */
public class ch05_intentfilter_result_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch05_intentfilter_result_activity);

        TextView tv = (TextView)findViewById(R.id.ch05_intentfilter_result_tv);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");

        String index = bundle.getString("index");
        String tvStr = tv.getText().toString();

        tv.setText(tvStr+index);

        Button bt = (Button)findViewById(R.id.ch05_intentfilter_finish_bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch05_intentfilter_result_activity.this.finish();
            }
        });
    }
}
