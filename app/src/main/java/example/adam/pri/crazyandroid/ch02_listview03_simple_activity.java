package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lab on 2015/2/3.
 */
public class ch02_listview03_simple_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch02_listview03_simple_activity);

        ListView listView = (ListView)findViewById(R.id.ch02_listview_lv03);
        ImageView imageView = (ImageView)findViewById(R.id.ch02_listview03_header);
        TextView textView = (TextView)findViewById(R.id.ch02_listview03_name);

        String[] names = new String[]{"adam","jack","kate","eson"};
        int[] pics = new int[]{R.drawable.p1,R.drawable.p2,R.drawable.p4,R.drawable.p5};

        List<Map<String,Object>> lists = new ArrayList<Map<String, Object>>(4);

        for(int i=0;i<4;i++){
            Map<String,Object> item = new HashMap<String, Object>(4);
            item.put("personName",names[i]);
            item.put("header",pics[i]);

            lists.add(item);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                lists,
                R.layout.activity_ch02_listview03_simple_activity,
                new String[]{"personName","header"},
                new int[]{R.id.ch02_listview03_name,R.id.ch02_listview03_header}
        );

        listView.setAdapter(simpleAdapter);
    }
}
