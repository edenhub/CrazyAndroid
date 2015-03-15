package example.adam.pri.crazyandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lab on 2015/3/15.
 */
public class ch02_dialog_alert1_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch02_alertdialog1_activity);

        Button bt = (Button)findViewById(R.id.ch02_alertdialog1_bt);
        Button bt2 = (Button)findViewById(R.id.ch02_alertdialog2_bt);
        Button bt3 = (Button)findViewById(R.id.ch02_alertdialog3_bt);


        bt.setOnClickListener(new View.OnClickListener() {
            final AlertDialog.Builder builder = new
                    AlertDialog.Builder(ch02_dialog_alert1_activity.this);

            @Override
            public void onClick(View v) {
                builder.setTitle("Test标题");
                builder.setMessage("Test消息");

                builder.setPositiveButton("确定",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editText = (EditText)findViewById(R.id.ch02_alertdialog1_et);
                        editText.setText("点击了确定按钮");
                    }
                });

                builder.setNegativeButton("取消",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editText = (EditText)findViewById(R.id.ch02_alertdialog1_et);
                        editText.setText("点击了取消按钮");
                    }
                });


                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            final AlertDialog.Builder builder = new
                    AlertDialog.Builder(ch02_dialog_alert1_activity.this);
            @Override
            public void onClick(View v) {
                builder.setTitle("列表对话框");
                builder.setItems(new String[]{"red","green","yello"},
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                TextView editText = (TextView)findViewById(R.id.ch02_alertdialog_tv);

                                switch(which){
                                    case 0 : editText.setBackgroundColor(Color.RED); break;
                                    case 1 : editText.setBackgroundColor(Color.GREEN); break;
                                    case 2 : editText.setBackgroundColor(Color.YELLOW); break;
                                }
                            }
                        });

                builder.setPositiveButton("Done",null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            final AlertDialog.Builder builder = new
                    AlertDialog.Builder(ch02_dialog_alert1_activity.this);
            @Override
            public void onClick(View v) {

                builder.setTitle("single dialog");

                builder.setSingleChoiceItems(new String[]{"red","green","yello"},1,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TextView textView = (TextView)findViewById(R.id.ch02_alertdialog_tv);

                        switch (which){
                            case 0 : textView.setBackgroundColor(Color.RED); break;
                            case 1 : textView.setBackgroundColor(Color.GREEN); break;
                            case 2 : textView.setBackgroundColor(Color.YELLOW); break;
                        }
                    }
                });
                builder.setPositiveButton("Done", null);

                builder.create().show();
            }
        });

        Button bt4 = (Button)findViewById(R.id.ch02_alertdialog4_bt);
        bt4.setOnClickListener(new View.OnClickListener() {
            final AlertDialog.Builder builder = new
                    AlertDialog.Builder(ch02_dialog_alert1_activity.this);
            List<String> data = new ArrayList<String>(3);
            @Override
            public void onClick(View v) {
                builder.setTitle("Multi dialog");
                builder.setMultiChoiceItems(new String[]{"red","green","yello"},new boolean[]{},
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                switch(which){
                                }
                            }
                        });
                builder.setPositiveButton("Done",null);

                builder.create().show();
            }
        });

        Button bt5 = (Button)findViewById(R.id.ch02_alertdialog5_bt);
        bt5.setOnClickListener(new View.OnClickListener() {
            final AlertDialog.Builder builder =
                    new AlertDialog.Builder(ch02_dialog_alert1_activity.this);

            @Override
            public void onClick(View v) {
                LinearLayout layout = (LinearLayout)getLayoutInflater().
                        inflate(R.layout.activity_ch02_alertdialoglogin_activity,null);

                builder.setView(layout);
                builder.setPositiveButton("Done",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNegativeButton("Cancle",null);

                builder.create().show();
            }
        });
    }
}
