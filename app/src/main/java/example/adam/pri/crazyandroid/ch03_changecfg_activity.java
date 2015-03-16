package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import example.adam.pri.crazyandroid.utils.ConfigurationInfoUtil;

/**
 * Created by lab on 2015/3/16.
 */
public class ch03_changecfg_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch03_changecfg_activity);

        Button bt = (Button)findViewById(R.id.ch03_changecfg_bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuration conf = getResources().getConfiguration();

                if (conf.orientation == Configuration.ORIENTATION_LANDSCAPE){
                    ch03_changecfg_activity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }else{
                    ch03_changecfg_activity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        String orientaion = ConfigurationInfoUtil.screenOrientation(newConfig.orientation);

        Log.e("TEST",orientaion);

        Toast.makeText(this,orientaion,Toast.LENGTH_LONG).show();
        Log.e("Here","Here");
    }
}
