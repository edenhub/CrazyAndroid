package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by lab on 2015/3/24.
 */
public class ch08_sharepreference_activity extends Activity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch08_sharepreference_activity);

        Button read = (Button)findViewById(R.id.ch08_sharepreference_read_bt);
        Button write = (Button)findViewById(R.id.ch08_sharepreference_write_bt);
        final EditText editText = (EditText)findViewById(R.id.ch08_sharepreference_et);

        sharedPreferences = getSharedPreferences("sp_test01",MODE_WORLD_WRITEABLE);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = sharedPreferences.getString("data","无数据");
                String time = sharedPreferences.getString("time","- - -");

                Toast.makeText(ch08_sharepreference_activity.this,data+" :"+time,Toast.LENGTH_LONG)
                .show();
            }
        });

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("data",data);
                editor.putString("time",new Date().toString());
                editor.commit();

                Toast.makeText(ch08_sharepreference_activity.this,"已经写入",Toast.LENGTH_LONG);
            }
        });
    }
}
