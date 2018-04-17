package com.example.administrator.rxjava2study.base;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/**
 * Description: Presenter的根父类
 */

public abstract class  BasePresenter<T> {
    //View 接口类型的软引用
    protected Reference<T> mViewRef;

    public void attachView(T view){
        //建立关系
        mViewRef = new SoftReference<T>(view);

    }
    protected  T getView(){
        return  mViewRef.get();
    }
    public  boolean isViewAttached(){
        return  mViewRef!=null&&mViewRef.get()!=null;
    }
    public  void detachView(){
        if(mViewRef!=null){
            mViewRef.clear();
        }
    }
}
