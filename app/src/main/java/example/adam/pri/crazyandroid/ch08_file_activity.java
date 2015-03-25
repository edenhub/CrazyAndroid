package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lab on 2015/3/24.
 */
public class ch08_file_activity extends Activity {
    private final String fileName = "Ch08_File.bin";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ch08_file_activity);

        Button btRead = (Button)findViewById(R.id.ch08_file_read_bt);
        Button btWrite = (Button)findViewById(R.id.ch08_file_write_bt);
        final EditText editText = (EditText)findViewById(R.id.ch08_file_et);

        btRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream in = openFileInput(fileName);
                    byte[] buffer = new byte[1024];
                    StringBuilder sb = new StringBuilder();
                    int ch;

                    while ( (ch = in.read(buffer)) != -1 ){
                        sb.append(new String(buffer));
                    }

                    editText.setText(sb.toString());
                    in.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream out = openFileOutput(fileName,MODE_WORLD_WRITEABLE);
                    String content = editText.getText().toString();
                    out.write(content.getBytes());
                    out.close();

                    Toast.makeText(ch08_file_activity.this,"写入完毕",Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
