package com.six.monthtext.server;

import com.six.monthtext.bean.BannerBean;
import com.six.monthtext.bean.HanderBean;
import com.six.monthtext.bean.ImageThreeBean;
import com.six.monthtext.bean.LieBiaoBean;
import com.six.monthtext.bean.ShejiShiBean;
import com.six.monthtext.bean.UserInfoBean;

import java.io.File;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

public interface IServer {

    @POST("quarter/getAd")
    Observable<BannerBean> BannerBeandata();
    //https://www.zhaoapi.cn/file/upload
    //上传头像

//    @POST("file/upload?source=android&appVersion=101")
//    Observable<HanderBean> PushImage(@Body RequestBody imgs);
    @POST("file/upload")
    Observable<HanderBean> PushImage(@Body RequestBody imgs);

    //https://www.zhaoapi.cn/user/getUserInf
    //获取用户信息
    @POST("user/getUserInfo")
    Observable<UserInfoBean> getUserInfo(@Query("uid") String uid);

    @GET("api.php/api/Lists/designer?token=&version=1.7")
    Observable<ShejiShiBean> ShejiShiData();

    @GET("product/getCatagory")
    Observable<LieBiaoBean> LieBiaoData();

    @GET("product/getProducts?pscid=1")
    Observable<ImageThreeBean> ImageThreeData();
}
