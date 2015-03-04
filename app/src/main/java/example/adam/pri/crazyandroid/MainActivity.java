package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MainActivity extends ActionBarActivity {
    private Button ch02_imageView_bt;
    private Button ch02_draw_bt;
    private Button ch02_linearlayout_bt;

    private Map<Integer,Button> buttonMap = new ConcurrentHashMap<Integer,Button>(30);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableRow root = (TableRow)findViewById(R.id.main_layout_ch02_01);

        ch02_imageView_bt = (Button) findViewById(R.id.ch02_imageView_bt);

//        ch02_imageView_bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,ch02_imageview_activity.class);
//                startActivity(intent);
//            }
//        });


//        ch02_draw_bt = (Button)findViewById(R.id.ch02_draw_bt);
//        ch02_draw_bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,ch02_drawview_activity.class);
//                startActivity(intent);
//            }
//        });


        ch02_linearlayout_bt = new Button(this);
        ch02_linearlayout_bt.setText("LinerLayout");

        ch02_linearlayout_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ch02_linerlayout_activity.class);
                startActivity(intent);
            }
        });
        root.addView(ch02_linearlayout_bt);

//        Button ch02_framelayout_bt = (Button) findViewById(R.id.ch02_framelayout_bt);
//        ch02_framelayout_bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,ch02_framelayout_activity.class);
//                startActivity(intent);
//            }
//        });

//        Button ch02_textview_bt01 = (Button)findViewById(R.id.ch02_textview_bt01);
//        ch02_textview_bt01.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,ch02_textview01_activity.class);
//                startActivity(intent);
//            }
//        });


//        Button ch02_textview_bt02 = (Button)findViewById(R.id.ch02_textview_bt02);
//        ch02_textview_bt02.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,ch02_textview02_activity.class);
//                startActivity(intent);
//            }
//        });

//        final Button ch02_alpha_bt = (Button)findViewById(R.id.ch02_alpha_bt);
//        ch02_alpha_bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,ch02_alpha_activity.class);
//                startActivity(intent);
//            }
//        });

        addNewButtonInLayout(R.id.ch02_imageView_bt,ch02_imageview_activity.class);
        addNewButtonInLayout(R.id.ch02_draw_bt,ch02_drawview_activity.class);
        addNewButtonInLayout(R.id.ch02_framelayout_bt,ch02_framelayout_activity.class);
        addNewButtonInLayout(R.id.ch02_textview_bt01,ch02_textview01_activity.class);
        addNewButtonInLayout(R.id.ch02_textview_bt02,ch02_textview02_activity.class);
        addNewButtonInLayout(R.id.ch02_alpha_bt,ch02_alpha_activity.class);
        addNewButtonInLayout(R.id.ch02_auto_bt,ch02_auto_activity.class);
        addNewButtonInLayout(R.id.ch02_datetime_bt,ch02_datetime_activity.class);
        addNewButtonInLayout(R.id.ch02_progress_bt,ch02_progress_activity.class);
        addNewButtonInLayout(R.id.ch02_tab_bt,ch02_tab_activity.class);
        addNewButtonInLayout(R.id.ch02_scroll_bt,ch02_scroll_activity.class);
        addNewButtonInLayout(R.id.ch02_listview_bt01,ch02_listview01_activity.class);
        addNewButtonInLayout(R.id.ch02_listview_bt02,ch02_listview02_activity.class);
        addNewButtonInLayout(R.id.ch02_simple_bt,ch02_listview03_simple_activity.class);
        addNewButtonInLayout(R.id.ch02_listview_btexpd,ch02_listview04_expand_activity.class);
        addNewButtonInLayout(R.id.ch02_gridview_bt,ch02_gridview_activity.class);
    }

    private void addNewButtonInLayout(int id, final Class<? extends Activity> targetActivity){
        Button button = (Button)findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,targetActivity);
                startActivity(intent);
            }
        });

        buttonMap.put(id,button);
    }

    private void addNewButtonInLayout(int parentId,int id,String text,
                                      final Class<? extends Activity> targetActivity){
        ViewGroup root = (ViewGroup)findViewById(parentId);
        addNewButtonInLayout(id,targetActivity);
        Button button = buttonMap.get(id);
        button.setText(text);
        root.addView(button);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
