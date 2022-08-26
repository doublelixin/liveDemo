package com.xin.livedemo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;


public class MainActivity extends Activity implements View.OnClickListener {
    private Button mPushBtn;
    private Button mPlayBtn;
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPushBtn = (Button) findViewById(R.id.push_stream_btn);
        mPlayBtn = (Button) findViewById(R.id.play_stream_btn);
        mPushBtn.setOnClickListener(this);
        mPlayBtn.setOnClickListener(this);
        int storage = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int camera = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int audio = ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        int internet = ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        if (storage == PackageManager.PERMISSION_GRANTED
                && camera == PackageManager.PERMISSION_GRANTED
                && audio == PackageManager.PERMISSION_GRANTED
                && internet == PackageManager.PERMISSION_GRANTED) {
            flag = true;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.push_stream_btn:
                if (flag)
                    startActivity(new Intent(this, CameraActivity.class));
                else
                    Toast.makeText(this, "请先给予应用权限", Toast.LENGTH_SHORT).show();
                break;
            case R.id.play_stream_btn:
                startActivity(new Intent(this, PlayerActivity.class));
                break;
        }
    }
}
