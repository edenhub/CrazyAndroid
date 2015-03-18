package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import example.adam.pri.crazyandroid.ch04.Person;

/**
 * Created by lab on 2015/3/18.
 */
public class ch04_bundle_second_activity extends Activity {
    private static final int ResultCode = 0x1213;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch04_bundle_second_activity);

        Button button = (Button)findViewById(R.id.ch04_bundle_second_bt);

        EditText editText = (EditText)findViewById(R.id.ch04_bundle_second_eet);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        Person person = (Person) bundle.getSerializable("data");
        editText.setText(person.toString());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch04_bundle_second_activity.this.setResult(ResultCode);

                ch04_bundle_second_activity.this.finish();
            }
        });
    }
}
