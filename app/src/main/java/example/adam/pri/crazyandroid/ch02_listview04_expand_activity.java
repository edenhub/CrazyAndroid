package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by lab on 2015/2/3.
 */
public class ch02_listview04_expand_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch02_listview04_expand_activity);

        ExpandableListView expandableListView = (ExpandableListView)findViewById(R.id.ch02_listview04_expand);

        ExpandableListAdapter listAdapter = new BaseExpandableListAdapter() {
            private String[] groupData = new String[]{"Group1","Group2","Group3","Group4"};
            private String[][] itemData = new String[][]{
                    {"item11","item12","item13"},
                    {"item21","item22","item23","item24"},
                    {"item31","item32"},
                    {"item41","item42","item43"}
            };
            private int[] logos = new int[]{
                    R.drawable.p1,
                    R.drawable.p2,
                    R.drawable.p4,
                    R.drawable.p5
            };

            @Override
            public int getGroupCount() {
                return groupData.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return itemData[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return groupData[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return itemData[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return getGroup(groupPosition).hashCode();
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return getChild(groupPosition,childPosition).hashCode();
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout linearLayout = new LinearLayout(ch02_listview04_expand_activity.this);

                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView logo = new ImageView(ch02_listview04_expand_activity.this);
                logo.setLayoutParams(new ViewGroup.LayoutParams(50,50));
                logo.setImageResource(logos[groupPosition]);
                linearLayout.addView(logo);

                TextView textView = new TextView(ch02_listview04_expand_activity.this);
                textView.setText(getGroup(groupPosition).toString());
                linearLayout.addView(textView);

                return linearLayout;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {


                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,64);
                TextView textView = new TextView(ch02_listview04_expand_activity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
                textView.setPadding(36,0,0,0);
                textView.setTextSize(20);

                textView.setText(getChild(groupPosition,childPosition).toString());

                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };

        expandableListView.setAdapter(listAdapter);


    }
}
