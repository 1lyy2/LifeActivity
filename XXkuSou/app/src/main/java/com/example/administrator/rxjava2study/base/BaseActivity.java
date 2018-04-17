package com.example.administrator.rxjava2study.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018/3/6.
 */

public abstract class BaseActivity<V,T extends BasePresenter> extends AppCompatActivity {
    public String TAG = getClass().getSimpleName() + "";

    protected T mPresenter;

    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);
        mContext = BaseActivity.this;
        //创建presenter
        mPresenter = createPresenter();

        // presenter与view绑定
        if (null != mPresenter) {
            mPresenter.attachView((V) this);
        }

        findViewById();

        getData();

    }
    //关于Activity的界面填充的抽象方法，需要子类必须去实现
    protected  abstract void initView(Bundle savedInstanceState);

    //加载页面元素
    protected  abstract  void findViewById();

    //创建Presenter对象
    protected abstract T createPresenter();

    protected abstract void getData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.detachView();
        }
    }


}
