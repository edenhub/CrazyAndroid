package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

/**
 * Created by lab on 2015/1/29.
 */
public class ch02_textview02_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch02_textview02_activity);

        ToggleButton tbt = (ToggleButton)findViewById(R.id.ch02_textview02_tbt);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ch02_textview02_layout);

        tbt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                }else{
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                }
            }
        });
    }
}
