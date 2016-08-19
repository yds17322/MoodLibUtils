package com.dk.yds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ds.dk.yuoto.libutils.Http.HttpUtils;
import ds.dk.yuoto.libutils.Http.HttpUtilsCallback;

/**
 * Created by deshui.yu on 16-8-19.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpUtils.getInstance();
        btn1 = (Button) findViewById(R.id.btn_1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                HttpUtils.post().url("http://192.168.1.111/login")
                        .addParams("name", "1800000000")//
                        .addParams("pwd", "123456")//
                        .build()//
                        .execute(new HttpUtilsCallback() {
                            @Override
                            public void success(String response) {
                                Log.d("yds", "response ---> " + response);
                                btn1.setText("post_success");
                            }

                            @Override
                            public void error(String e) {
                                Log.d("yds", "error ---> " + e);
                                btn1.setText("post_error");
                            }
                        });
                break;

            case R.id.btn_2:
                HttpUtils.get().url("https://www.baidu.com/s?wd=a").build().execute(new HttpUtilsCallback() {
                    @Override
                    public void success(String response) {
                        Log.d("yds", "response ---> " + response);
                        btn2.setText("get_success");
                    }

                    @Override
                    public void error(String e) {
                        Log.d("yds", "e ---> " + e);
                        btn2.setText("get_error");
                    }
                });
                break;
        }
    }
}
