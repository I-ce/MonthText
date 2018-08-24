package com.six.monthtext.presenter;

import android.util.Log;

import com.six.monthtext.bean.ImageThreeBean;
import com.six.monthtext.model.DataModelplall;
import com.six.monthtext.util.RetrofitUtils;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

class DataModelImplAll {
    public void getData(final DataModelplall dataModelplall) {
        Observable<ImageThreeBean> threeData = RetrofitUtils.getInstance().getServer().ImageThreeData();
        threeData.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<ImageThreeBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("aaaaaaaaaa",e.toString());
            }

            @Override
            public void onNext(ImageThreeBean imageThreeBean) {
                dataModelplall.setOnSuccess(imageThreeBean);
            }
        });
    }
}
