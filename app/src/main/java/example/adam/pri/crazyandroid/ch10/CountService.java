package example.adam.pri.crazyandroid.ch10;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by lab on 2015/3/28.
 */
public class CountService extends Service {
    private int count = 0;
    private IBinder binder = new MyCountBinder();
    private volatile boolean flag = true;
    private static final String TAG = "== CountService ==";

    public class MyCountBinder extends Binder{
        public int getCount(){
            return count;
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        System.err.println(TAG+" onBind");

        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println(TAG+" onCreate");

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while(flag){
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            count++;
                        }
                    }
                }
        ).start();

    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println(TAG+" onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {


        super.onDestroy();

        flag = false;
        System.out.println(TAG+" onDestroy");
    }
}
