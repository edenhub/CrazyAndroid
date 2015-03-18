package example.adam.pri.crazyandroid.ch04;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by lab on 2015/3/18.
 */
public class MyExpandListActivity extends ExpandableListActivity{
    private String[] titles = {"Group1","Group2","Group3"};
    private String[][] values = {
            {"value1_1","value1_2","value1_3"},
            {"value2_1","value2_2"},
            {"value3_1","value3_2","value3_3","value3_4"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return titles.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return values[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return titles[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return values[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return titles[groupPosition].hashCode();
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return values[groupPosition][childPosition].hashCode();
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout layout = new LinearLayout(MyExpandListActivity.this);

                layout.setOrientation(LinearLayout.HORIZONTAL);
                TextView textView = new TextView(MyExpandListActivity.this);
                textView.setText(getGroup(groupPosition).toString());

                layout.addView(textView);

                return layout;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = new TextView(MyExpandListActivity.this);
                textView.setText(getChild(groupPosition,childPosition).toString());

                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };

        setListAdapter(adapter);
    }
}
