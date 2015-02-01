package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lab on 2015/1/31.
 */
public class ch02_auto_activity extends Activity {

    final int[] images = new int[]{
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p4,
            R.drawable.p5
    };

    final String[] names = new String[]{
            "adam",
            "akaon",
            "ajax",
            "array"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch02_auto_activity);

        AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.ch02_auto_actv);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item);

        List<String> names = Arrays.asList("大雄","静香","哆啦A梦","小夫","大哥大","大宝","小蛋","小心");
        adapter.addAll(names);

        actv.setAdapter(adapter);

        Spinner spinner = (Spinner) findViewById(R.id.ch02_auto_spinner);

        BaseAdapter baseAdapter = new BaseAdapter() {
            int count = 4;
            @Override
            public int getCount() {
                return count;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return images[position];
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                LinearLayout item = new LinearLayout(ch02_auto_activity.this);

                ImageView imageView = new ImageView(ch02_auto_activity.this);
                imageView.setImageResource(images[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(50,50));
                TextView textView = new TextView(ch02_auto_activity.this);
                textView.setText(position+" ");
//                Button button = new Button(ch02_auto_activity.this);
//                button.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        System.err.println(position+" ====== > button");
//                    }
//                });

                item.addView(imageView);
                item.addView(textView);
//                item.addView(button);
                return item;
            }
        };

        spinner.setAdapter(baseAdapter);
    }
}
