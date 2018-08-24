package com.six.monthtext.model;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.six.monthtext.api.Api;
import com.six.monthtext.bean.BannerBean;
import com.six.monthtext.bean.HanderBean;
import com.six.monthtext.bean.LieBiaoBean;
import com.six.monthtext.bean.ShejiShiBean;
import com.six.monthtext.server.IServer;
import com.six.monthtext.util.RetrofitUtils;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DataModel {

    public void getData(final DataModelImpl dataModel) {

        final Observable<BannerBean> beandata1 = RetrofitUtils.getInstance().getServer().BannerBeandata();
        beandata1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("aaaaaaaa",e.toString());
                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                       dataModel.setOnSuccess(bannerBean);
                    }
                });
    }

    public void getListData(final DataModelImpl dataModel) {

        Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("https://app.tuozhe8.com/")
                    .build();
        Observable<ShejiShiBean> shejiShiData = retrofit.create(IServer.class).ShejiShiData();
        shejiShiData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShejiShiBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("aaaaaaaaaaa",e.toString());
                    }

                    @Override
                    public void onNext(ShejiShiBean shejiShiBean) {
                        dataModel.setOnSheSuccess(shejiShiBean);
                    }
                });
    }

    public void getList2Data(final DataModelImpl dataModel) {
        Observable<LieBiaoBean> lieBiaoData = RetrofitUtils.getInstance().getServer().LieBiaoData();
        lieBiaoData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LieBiaoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LieBiaoBean lieBiaoBean) {
                        dataModel.setonLieSuccess(lieBiaoBean.getData());
                    }
                });

    }


}
