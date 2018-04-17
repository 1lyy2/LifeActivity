package com.example.administrator.rxjava2study;

import com.example.administrator.rxjava2study.bean.Banner;
import com.example.administrator.rxjava2study.bean.DouBan;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/3/7.
 */

public interface Tony_Service {
    /*   http://news-at.zhihu.com/api/4/news/latest (轮播图)
       http://api.douban.com/v2/movie/top250?start=0&count=10(豆瓣影视)*/
    //Rxjava三部曲 第一步
    //这个是Retorfit的写法，没有结合Rxjava的写法
    @GET("latest")
    Call<Banner> getBannerBean1();

    //Rxjava的写法
    @GET("latest")
    Observable<Banner> getBannerBean();

    //Rxjava的写法
    @GET("top250")
    Observable<DouBan> getBannerBean2(@Query("start") int start,@Query("count") int count);





}
