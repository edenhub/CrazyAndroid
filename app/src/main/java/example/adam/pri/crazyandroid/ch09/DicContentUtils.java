package example.adam.pri.crazyandroid.ch09;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by lab on 2015/3/28.
 */
public final class DicContentUtils {
    public static final String AUTHORITY = "example.adam.pri.apptestcontent.dic";

    public static class Word implements BaseColumns{
        public static final String _ID = "_id";
        public static final String WORD = "word";
        public static final String DETAIL = "detail";

        public static final Uri DICT_CONTENT_URI =
                Uri.parse("content://"+ AUTHORITY+"/words");
        public static final Uri WORD_CONTENT_URI =
                Uri.parse("content://"+AUTHORITY+"/word");
    }

    public static class DBSql{
        public static final String TABLE_NAME = "dicts";
        public static final String DB_FILE_NAME = "dics.db";
        public static final String TABLE_STRACT =
                "create table dicts (_id integer primary key autoincrement," +
                        "word varchar," +
                        "detail varchar)";
    }

    public static class Uris{
        public static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        public static final int WORDS = 1;
        public static final int WORD = 2;

        public Uris(){
            uriMatcher.addURI(AUTHORITY,"words",WORDS);
            uriMatcher.addURI(AUTHORITY,"word/#",WORD);
        }

        public static UriMatcher getUriMatcher(){
            return uriMatcher;
        }
    }

}
