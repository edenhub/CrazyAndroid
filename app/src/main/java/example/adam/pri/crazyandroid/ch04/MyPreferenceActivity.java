package example.adam.pri.crazyandroid.ch04;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import example.adam.pri.crazyandroid.R;

/**
 * Created by lab on 2015/3/18.
 */
public class MyPreferenceActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.ch04_launcher_test);
    }
}
