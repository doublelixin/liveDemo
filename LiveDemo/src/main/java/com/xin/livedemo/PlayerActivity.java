package com.xin.livedemo;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

/**
 * Created by Sikang on 2017/5/2.
 */

public class PlayerActivity extends Activity implements View.OnClickListener {
    private String path = "";
    private VideoPlayerIJK videoPlayerIJK;
    private EditText mEditText;
    private Button mStartBtn;
    private Button mStopBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        mEditText = (EditText) findViewById(R.id.url);
        videoPlayerIJK = (VideoPlayerIJK) findViewById(R.id.video_view);

        mStartBtn = (Button) findViewById(R.id.start);
        mStopBtn = (Button) findViewById(R.id.stop);
        mStartBtn.setOnClickListener(this);
        mStopBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                path = mEditText.getText().toString();
                if (!TextUtils.isEmpty(path)) {
                    videoPlayerIJK.setVideoPath(path);
                }
                break;
            case R.id.stop:
                videoPlayerIJK.stop();
                break;
        }
    }
}
