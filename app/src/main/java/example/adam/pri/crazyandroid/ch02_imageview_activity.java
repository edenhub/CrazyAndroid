package example.adam.pri.crazyandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class ch02_imageview_activity extends ActionBarActivity {

      int[] images = new int[]{
            R.drawable.p1,
            R.drawable.p2,
//            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch02_imageview_activity);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.ch02_imageView_layout);

        final ImageView imageView = new ImageView(this);
        layout.addView(imageView);
        imageView.setImageResource(images[0]);
        imageView.setOnClickListener(new View.OnClickListener() {
            int currIndex = 0;
            int len = images.length;
            @Override
            public void onClick(View v) {
                currIndex = (currIndex+1) % len;
                imageView.setImageResource(images[currIndex]);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ch02_imageview_activity, menu);
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
