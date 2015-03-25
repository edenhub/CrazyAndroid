package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lab on 2015/3/24.
 */
public class ch08_browsedir_activity extends Activity {
    private File currParent;
    private File[] currFiles;
    private ListView listView;
    private TextView tv;
    private Button parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch08_browsedir_activity);

        parent = (Button)findViewById(R.id.ch08_browsedir_parent_bt);
        tv = (TextView)findViewById(R.id.ch08_browsedir_dir_tv);
        listView = (ListView)findViewById(R.id.ch08_browsedir_listview);

        File root = new File("/mnt/sdcard");
        if (root.exists()){
            currParent = root;
            currFiles = currParent.listFiles();
            reShowListView();
        }

        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (currParent.getCanonicalPath().equals("/mnt/sdcard"))
                        return;

                    currParent = currParent.getParentFile();
                    currFiles = currParent.listFiles();
                    reShowListView();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                File file = currFiles[position];

                if (file.isFile())
                    return;

                currParent = file;
                currFiles = file.listFiles();
                reShowListView();
            }
        });


    }

    protected  void reShowListView(){
        List<Map<String,Object>> datas = new ArrayList<Map<String, Object>>(currFiles.length*3/2);
        for (File f : currFiles){
            Map<String,Object> data = new HashMap<String, Object>();
            if (f.isFile())
                data.put("icon",R.drawable.s2);
            else
                data.put("icon",R.drawable.s3);

            data.put("fileName",f.getName());
            datas.add(data);
        }
        ListAdapter adapter = new SimpleAdapter(ch08_browsedir_activity.this,datas,
                R.layout.activity_ch08_browsedir_list_activity,new String[]{"icon","fileName"},
                new int[]{R.id.ch08_browsedir_icon,R.id.ch08_browsedir_fileName});

        listView.setAdapter(adapter);
        try {
            tv.setText(currParent.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
