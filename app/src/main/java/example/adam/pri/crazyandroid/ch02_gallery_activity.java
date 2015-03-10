package example.adam.pri.crazyandroid;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

/**
 * Created by lab on 2015/3/10.
 */
public class ch02_gallery_activity extends Activity
        implements AdapterView.OnItemSelectedListener {

    int[] images = new int[]{
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p4,
            R.drawable.p5
    };

    private Gallery gallery;
    private ImageSwitcher switcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch02_gallery_activity);

        gallery = (Gallery)findViewById(R.id.ch02_gallery_ga);
        switcher = (ImageSwitcher)findViewById(R.id.ch02_gallery_is);

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(ch02_gallery_activity.this);

                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        Gallery.LayoutParams.WRAP_CONTENT,
                        Gallery.LayoutParams.WRAP_CONTENT
                ));
                return imageView;
            }
        });

        switcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        switcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(ch02_gallery_activity.this);

                imageView.setImageResource(images[position%images.length]);
                imageView.setLayoutParams(new Gallery.LayoutParams(75,100));
//                TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);

                return imageView;
            }
        };
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switcher.setImageResource(images[position%images.length]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
