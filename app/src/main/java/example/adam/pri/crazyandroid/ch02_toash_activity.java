package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by lab on 2015/3/15.
 */
public class ch02_toash_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch02_toash_activity);

        Button simple = (Button)findViewById(R.id.ch02_toash_simple_bt);
        Button view = (Button)findViewById(R.id.ch02_toash_view_bt);

        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(ch02_toash_activity.this,"Simple Message",Toast.LENGTH_LONG);
                toast.show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(ch02_toash_activity.this,"View Message",
                        Toast.LENGTH_LONG);

                View toastView = toast.getView();

                ImageView imageView = new ImageView(ch02_toash_activity.this);
                imageView.setImageResource(R.drawable.ss1);

                LinearLayout layout = new LinearLayout(ch02_toash_activity.this);
                layout.addView(imageView);
                layout.addView(toastView);

                toast.setView(layout);
            }
        });
    }
}
