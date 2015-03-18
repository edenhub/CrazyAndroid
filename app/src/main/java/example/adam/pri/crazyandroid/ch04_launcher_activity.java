package example.adam.pri.crazyandroid;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import example.adam.pri.crazyandroid.ch04.MyExpandListActivity;
import example.adam.pri.crazyandroid.ch04.MyPreferenceActivity;

/**
 * Created by lab on 2015/3/18.
 */
public class ch04_launcher_activity extends LauncherActivity {
    private String[] listTitles = {"设置参数","查看扩展列表"};
    private Class[] listClazzs = {MyPreferenceActivity.class,MyExpandListActivity.class};

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,listTitles);

        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        Intent intent = new Intent(this,listClazzs[position]);

        return intent;
    }
}
