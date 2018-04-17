package com.example.administrator.rxjava2study;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.example.administrator.rxjava2study.bean.Banner;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements BottomDialogFragment.OnDialogCancelListener,BottomDialogFragment.OnDialogBindViewSuccessListener{
    public static String TAG;
    private ConvenientBanner mBanner;
    private List<Banner.TopStoriesBean> mList = new ArrayList<>();
    BottomDialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBanner = (ConvenientBanner) findViewById(R.id.banner);
        TAG = getClass().getSimpleName();
        getTonyQuery();
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
    }

    private void getTonyQuery() {
        //定义一个路径
        //http://news-at.zhihu.com/api/4/news/latest
        String url = "http://news-at.zhihu.com/api/4/news/";
        /**
         * 使用 Retrofit 的步骤共有7个：
         步骤1：添加Retrofit库的依赖
         步骤2：创建 接收服务器返回数据 的类
         步骤3：创建 用于描述网络请求 的接口
         步骤4：创建 Retrofit 实例
         步骤5：创建 网络请求接口实例 并 配置网络请求参数
         步骤6：发送网络请求（异步 / 同步）
         */
        //用什么来请求数据
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)//放路径
                .addConverterFactory(GsonConverterFactory.create())//gson解析
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//工厂
                .build();

        //Rxjava三部曲：第二步  动态代理
        Tony_Service apiervice = retrofit.create(Tony_Service.class);

        //Rxjava三部曲：第三步
        apiervice.getBannerBean().subscribeOn(Schedulers.io())//事件触发IO
                .observeOn(AndroidSchedulers.mainThread())//在UI线程处理返回的数据
                .subscribe(new Observer<Banner>() {  //Rxjava 三部曲： 第三步 订阅
                    @Override
                    public void onSubscribe(Disposable d) {
                        //解除订阅
                    }

                    @Override
                    public void onNext(Banner value) {
                        //向下执行
                        mList.addAll(value.getTop_stories());
                    }

                    @Override
                    public void onError(Throwable e) {
                        //有错误（异常）

                    }

                    @Override
                    public void onComplete() {
                        //已完成
                        //设置页数
                        mBanner.setPages(new CBViewHolderCreator<Myholder>() {
                            @Override
                            public Myholder createHolder() {

                                return new Myholder();
                            }
                        }, mList);

                        //设置指示器
                        //mBanner.setPageIndicator()


                    }
                });
    }

    @Override
    public void onCancel() {
        Log.i("DimSS","-------------------->dimss");
        Toast.makeText(MainActivity.this,"dimss",Toast.LENGTH_SHORT);
    }

    @Override
    public void onBindViewSuccess() {
        dialogFragment.setTitleText("厂长求带飞");
        dialogFragment.setTitleColor(getResources().getColor(R.color.colorAccent));
    }

    public class Myholder implements Holder<Banner.TopStoriesBean> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            mImageView = new ImageView(context);
            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return mImageView;
        }

        @Override
        public void UpdateUI(Context context, int position, Banner.TopStoriesBean data) {
            Glide.with(context).load(data.getImage()).into(mImageView);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //设置自动循环切换
        mBanner.startTurning(3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //停止循环切换
        mBanner.stopTurning();
    }

    private void rxJava() {

        Observable.create(new ObservableOnSubscribe<Integer>() {  //第一步：初始化Obeservable
            //ObservableEmitter  相当于发射器
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "Observable emit 1" + "\n");
                e.onNext(1);
                Log.e(TAG, "Observable emit 2" + "\n");
                e.onNext(2);
                Log.e(TAG, "Observable emit 3" + "\n");
                e.onNext(3);
                e.onComplete();
                Log.e(TAG, "Observable emit 4" + "\n");
                e.onNext(4);

            }
        }).subscribe(new Observer<Integer>() { //第三步：订阅

            //第二步:初始化Observer
            private int i;
            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(Integer value) {
                i++;
                if (i == 2) {
                    //在RxJava2.x中，新增了Disposable可以做到切断的操作，让Observer不再继续接收上游事件
                    mDisposable.dispose();
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError : value : " + e.getMessage() + "\n");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete" + "\n");
            }
        });
    }
    private void init(){
        dialogFragment = BottomDialogFragment.newInstance();
        dialogFragment.setOnDialogCancelListener(this);
        dialogFragment.setOnDialogBindViewSuccessListener(this);
        dialogFragment.show(getFragmentManager(), "DialogFragment");
    }
}
