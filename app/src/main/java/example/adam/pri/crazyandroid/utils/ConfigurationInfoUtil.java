package example.adam.pri.crazyandroid.utils;

import android.content.res.Configuration;

/**
 * Created by lab on 2015/3/16.
 */
public class ConfigurationInfoUtil {

    public static String screenOrientation(int idx){
        switch (idx){
            case Configuration.ORIENTATION_LANDSCAPE :
                return "横向屏幕";

            case Configuration.ORIENTATION_PORTRAIT :
                return "竖线屏幕";

        }

        return "";
    }
}
