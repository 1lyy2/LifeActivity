package com.example.administrator.rxjava2study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 生命周期的学习
 */

public class LifecycleActivity extends AppCompatActivity {

    /**
     * 表示Activity正在被创建
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
    }

    /**
     * activity变为在屏幕上对用户可见时调用
     */

    @Override
    protected void onStart() {
        super.onStart();
    }


    /**
     * Activity正在重新启动
     */
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    /**
     *  开始与用户交互时调用
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Activity正在停止，失去焦点
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Activity即将停止，且处于不可见状态
     */
    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * Activity正在被销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
