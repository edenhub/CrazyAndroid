package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by lab on 2015/3/25.
 */
public class ch08_sqlite_activity extends Activity {
    private SQLiteDatabase sqLiteDatabase;
    private Button btInsert,btShow;
    private EditText etTtile,etValue;
    private ListView lvValue;

    private String dbPath;
    private final String dbName = "sqdb.db";
    private final String tableName = "recode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch08_sqlite_activity);

        initComponent();

    }

    protected void initComponent(){
        dbPath = this.getFilesDir()+"/"+dbName;
        sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(dbPath,null);

        btInsert = (Button)findViewById(R.id.ch08_sqlite_insert_bt);
        btShow = (Button)findViewById(R.id.ch08_sqlite_show_bt);
        etTtile = (EditText)findViewById(R.id.ch08_sqlite_title);
        etValue = (EditText)findViewById(R.id.ch08_sqlite_value);
        lvValue = (ListView)findViewById(R.id.ch08_sqlite_listview);

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTtile.getText().toString();
                String value = etValue.getText().toString();

                try{
                    insertData(title,value);
                }catch (SQLiteException e){
                    sqLiteDatabase.execSQL("create table recode(_id integer primary key autoincrement," +
                            "title varchar(225)," +
                            "value varchar(225))");
                    insertData(title, value);
                }finally {
                    Cursor cursor = sqLiteDatabase.rawQuery("select * from recode",null);
                    reLoadList(cursor);
                }
            }
        });

        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = sqLiteDatabase.rawQuery("select * from recode",null);
                reLoadList(cursor);
            }
        });
    }

    protected void reLoadList(Cursor cursor){
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,R.layout.activity_ch08_sqlite_list_activity,
                cursor,
                new String[]{"title","value"},
                new int[]{R.id.ch08_sqlite_list_title,R.id.ch08_sqlite_list_value},
                SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE
        );

        lvValue.setAdapter(adapter);
    }

    protected void insertData(String title,String value){
        sqLiteDatabase.execSQL("insert into recode values(null,?,?)", new String[]{title, value});
    }
}
