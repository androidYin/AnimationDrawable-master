package com.teacheryin.android.animationdrawable;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView m_img_duke;
    private AnimationDrawable m_frame_animation;
    private TextView m_tv_time;
    private Button m_btn_start_stop;
    private long lastTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFrameAnimation();
    }


    private void initView() {
        m_img_duke = (ImageView) findViewById(R.id.img_duke);
        m_tv_time = (TextView) findViewById(R.id.tv_time);
        m_btn_start_stop = (Button) findViewById(R.id.btn_start);
    }

    private void initFrameAnimation() {
        m_img_duke.setBackgroundResource(R.drawable.frame_animation);
        m_frame_animation = (AnimationDrawable) m_img_duke.getBackground();
    }

    public void click(View view) {
        switch(view.getId()) {
            case R.id.btn_start:
                m_frame_animation.start();
                break;
            case R.id.btn_stop:
                m_frame_animation.stop();
                break;
            case R.id.btn_5_secs:
                animation5secs();
                break;
        }
    }


    private Handler mHandler = new Handler();

    private void animation5secs() {
        int delayMillis = 5 * 1000; // 5秒
        boolean result = mHandler.postDelayed(new Task(), delayMillis);
        m_tv_time.setText(result ? "post成功" : "post失敗");
        m_frame_animation.start();
    }
    private class Task implements Runnable {
        @Override
        public void run() {
            m_frame_animation.stop();
            m_tv_time.setText("時間到");
        }
    }

}
