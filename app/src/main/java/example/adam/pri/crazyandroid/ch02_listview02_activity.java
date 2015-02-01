package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lab on 2015/2/1.
 */
public class ch02_listview02_activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch02_listview02_activity);

        ListView listView = (ListView)findViewById(R.id.ch02_listview_lv02);

        List<String> listValue = new ArrayList<String>();

        for(int i=0;i<15;i++){
            listValue.add("item_"+(i+1));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,listValue);

        listView.setAdapter(arrayAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}
