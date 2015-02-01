package example.adam.pri.crazyandroid;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

/**
 * Created by lab on 2015/2/1.
 */
public class ch02_tab_activity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost tabHost = getTabHost();
        LayoutInflater.from(this).inflate(R.layout.activity_ch02_tab_activity,
                tabHost.getTabContentView(),true);

        tabHost.addTab(tabHost.newTabSpec("No1")
        .setIndicator("已接电话").setContent(R.id.ch02_tab_tab01));

        tabHost.addTab(tabHost.newTabSpec("No2")
        .setIndicator("未接电话").setContent(R.id.ch02_tab_tab02));

        tabHost.addTab(tabHost.newTabSpec("No3")
        .setIndicator("联系人").setContent(R.id.ch02_tab_tab03));
    }
}
