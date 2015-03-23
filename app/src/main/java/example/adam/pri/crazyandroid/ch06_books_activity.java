package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by lab on 2015/3/23.
 */
public class ch06_books_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch06_books_activity);

        TextView textView = (TextView)findViewById(R.id.ch06_books_avtivity_tv);;

        XmlResourceParser xrp = getResources().getXml(R.xml.ch06_books);

        StringBuilder sb = new StringBuilder();

        try {
            while(xrp.getEventType() != XmlResourceParser.END_DOCUMENT){

                if (xrp.getEventType() == XmlResourceParser.START_TAG){
                    String tagName = xrp.getName();
                    if (tagName.equals("book")){
                        String bookPrice = xrp.getAttributeValue(null,"price");
                        String date = xrp.getAttributeValue(null,"date");
                        String bookName = xrp.nextText();

                        sb.append("价格：").append(bookPrice).append("出版日期").append(date)
                                .append("书名").append(bookName);
                    }
                }

                xrp.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String infos = sb.toString();
        textView.setText(infos);
    }
}
