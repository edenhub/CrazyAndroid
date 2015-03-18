package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import example.adam.pri.crazyandroid.ch04.Person;

/**
 * Created by lab on 2015/3/18.
 */
public class ch04_bundle_first_activity extends Activity{
    private static final int RequetCode = 0x1212;
    private static final int ResultCode = 0x1213;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch04_bundle_first_activity);

        final EditText username = (EditText)findViewById(R.id.ch04_bundle_first_et);
        final EditText intro = (EditText)findViewById(R.id.ch04_bundle_second_et);

        Button bt = (Button)findViewById(R.id.ch04_bunlde_first_bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un = username.getText().toString();
                String it = intro.getText().toString();
                Person person = new Person(un,it);

                Bundle bundle = new Bundle();
                bundle.putSerializable("data",person);


                Intent intent = new Intent(ch04_bundle_first_activity.this,ch04_bundle_second_activity.class);
                intent.putExtra("bundle",bundle);

                startActivityForResult(intent,RequetCode);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RequetCode && resultCode == ResultCode){
            Toast.makeText(ch04_bundle_first_activity.this,"得到放回值",Toast.LENGTH_LONG);
        }

    }
}
