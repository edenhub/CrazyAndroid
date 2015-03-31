package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import example.adam.pri.crazyandroid.ch09.DicContentUtils;

/**
 * Created by lab on 2015/3/28.
 */
public class ch09_dictResover_activity extends Activity {
    private ContentResolver contentResolver;
    private Button btAdd,btView;
    private EditText tvWord,tvDetail;
    private TextView tvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch09_dicresover_activity);

        contentResolver = getContentResolver();
        btAdd = (Button)findViewById(R.id.ch09_dicResover_btAdd);
        btView = (Button)findViewById(R.id.ch09_dicResover_btView);
        tvWord = (EditText)findViewById(R.id.ch09_dicResover_word);
        tvDetail = (EditText)findViewById(R.id.ch09_dicResover_detail);

        tvView = (TextView)findViewById(R.id.ch09_dicResover_tvView);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = tvWord.getText().toString();
                String detail = tvDetail.getText().toString();

                ContentValues contentValues = new ContentValues();
                contentValues.put(DicContentUtils.Word.WORD,word);
                contentValues.put(DicContentUtils.Word.DETAIL,detail);

                contentResolver.insert(DicContentUtils.Word.WORD_CONTENT_URI,contentValues);

                Toast.makeText(ch09_dictResover_activity.this,"插入成功",Toast.LENGTH_LONG).show();
            }
        });

        btView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = contentResolver.query(DicContentUtils.Word.DICT_CONTENT_URI,null,null,null,null);
                StringBuilder sb = new StringBuilder();
                while (cursor.moveToNext()){
                    String word = cursor.getString(1);
                    String detail = cursor.getString(2);

                    sb.append(word+" : "+detail+"\n");
                }

                tvView.setText(sb.toString());
            }
        });
    }
}
