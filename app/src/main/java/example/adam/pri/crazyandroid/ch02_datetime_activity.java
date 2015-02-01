package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by lab on 2015/1/31.
 */
public class ch02_datetime_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch02_datetime_activity);

        DatePicker datePicker = (DatePicker)findViewById(R.id.ch02_datetime_date);
        TimePicker timePicker = (TimePicker)findViewById(R.id.ch02_datetime_time);
        EditText editText = (EditText)findViewById(R.id.ch02_datetime_et);

        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    }
                });

    }
}
