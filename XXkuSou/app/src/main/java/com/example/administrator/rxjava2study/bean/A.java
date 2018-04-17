package com.example.administrator.rxjava2study.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/8.
 */

public class A {
    private String mName;
    private List<String> mList;

    public String getName() {
        return mName == null ? "" : mName;
    }

    public List<String> getList() {
        if (mList == null) {
            return new ArrayList<>();
        }
        return mList;
    }
}
