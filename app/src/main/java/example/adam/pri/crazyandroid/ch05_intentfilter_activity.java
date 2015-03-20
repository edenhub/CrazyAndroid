package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by lab on 2015/3/20.
 */
public class ch05_intentfilter_activity extends Activity {
    public static final String ACTIONO = "ch05_intentfilter_result_activity";
    public static final String CATEGARY_ONE = "ch05_intentfilter_categary_one";
    public static final String CATEGARY_TWO = "ch05_intentfilter_categary_two";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch05_intentfilter_activity);

        Button btComponent = (Button)findViewById(R.id.ch05_intentfilter_component);
        Button btFilter = (Button)findViewById(R.id.ch05_intentfilter_filter);

        btComponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComponentName componentName = new ComponentName(ch05_intentfilter_activity.this,
                        ch05_intentfilter_result_activity.class);

                Intent intent = new Intent();
                intent.setComponent(componentName);

                Bundle bundle = new Bundle();
                bundle.putString("index","Component");
                intent.putExtra("data",bundle);

                startActivity(intent);
            }
        });

        btFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent.setAction(ch05_intentfilter_activity.ACTIONO);
                intent.addCategory(ch05_intentfilter_activity.CATEGARY_ONE);
                intent.addCategory(ch05_intentfilter_activity.CATEGARY_TWO);

                Bundle bundle = new Bundle();
                bundle.putString("index","IntentFilter");
                intent.putExtra("data",bundle);

                startActivity(intent);
            }
        });

        Button btHome = (Button)findViewById(R.id.ch05_intentfilter_home);
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);

                startActivity(intent);
            }
        });

        Button btWeb = (Button)findViewById(R.id.ch05_intentfilter_web);
        btWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "http://www.baidu.com";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(data));

                startActivity(intent);
            }
        });

        Button btEditContacts = (Button)findViewById(R.id.ch05_intentfilter_editContacts);
        btEditContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_EDIT);
                String data = "content://com.android.contacts/contacts/1";
                intent.setData(Uri.parse(data));

                startActivity(intent);
            }
        });

        Button btDial = (Button)findViewById(R.id.ch05_intentfilter_dial);
        btDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                String data = "tel:13800138000";
                intent.setData(Uri.parse(data));

                startActivity(intent);
            }
        });
    }
}
