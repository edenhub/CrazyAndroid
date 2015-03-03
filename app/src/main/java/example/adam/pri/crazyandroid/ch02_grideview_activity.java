package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adam on 2015/3/3.
 */
public class ch02_grideview_activity extends Activity {

    private static final String TAG = "==Test GridView==";

    private int[] imageIds = new int[]{
            R.drawable.p1,R.drawable.p2,
            R.drawable.p4,R.drawable.p5
    };

    private GridView gridView;
    private ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch02_gridview_activity);

        gridView = (GridView)findViewById(R.id.ch02_gridview02_gv);
        imageSwitcher = (ImageSwitcher)findViewById(R.id.ch02_gridview02_ims);

        List<Map<String,Object>> listItems =
                new ArrayList<Map<String, Object>>();

        for (int i=0;i<imageIds.length;i++){
            Map<String,Object> listItem = new HashMap<String, Object>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }

        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(ch02_gridview_activity.this);
                imageView.setBackgroundColor(0xff0000);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                return imageView;
            }
        });

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems,
                R.layout.activity_ch02_gridview_cell_activity,
                new String[]{"image"},
                new int[]{R.id.ch02_gridview02_cell_iv});

        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageSwitcher.setImageResource(imageIds[position%imageIds.length]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageSwitcher.setImageResource(imageIds[position%imageIds.length]);
            }
        });
    }
}
