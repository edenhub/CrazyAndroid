package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by lab on 2015/3/23.
 */
public class ch06_value_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch06_value_activity);

        String[] arrays = getResources().getStringArray(R.array.ch06_array_test);

//        TextView testArray = (TextView)findViewById(R.id.ch06_string_test_array);
//        testArray.setText(arrays.length);
    }
}
