package com.six.monthtext.presenter;

import android.util.Log;

import com.six.monthtext.bean.BannerBean;
import com.six.monthtext.bean.LieBiaoBean;
import com.six.monthtext.bean.ShejiShiBean;
import com.six.monthtext.model.DataModel;
import com.six.monthtext.model.DataModelImpl;
import com.six.monthtext.view.DataView;

import java.util.List;

public class DataPresenter implements DataPresenterImpl{

    private DataView dataView;
    private DataModel dataModel;

    public DataPresenter(DataView dataView) {
        this.dataView = dataView;
        dataModel = new DataModel();
    }

    @Override
    public void onDestory() {
        dataView = null;
    }

    public void getDatas() {
        dataModel.getData(new DataModelImpl() {
            @Override
            public void setOnSuccess(BannerBean data) {
                dataView.getSuccess(data);
            }

            @Override
            public void setOnError() {

            }

            @Override
            public void setOnSheSuccess(ShejiShiBean shejiShiData) {

            }

            @Override
            public void setonLieSuccess(List<LieBiaoBean.DataBean> data) {

            }
        });
    }

    public void getListData() {
        dataModel.getListData(new DataModelImpl() {
            @Override
            public void setOnSuccess(BannerBean data) {

            }

            @Override
            public void setOnError() {

            }

            @Override
            public void setOnSheSuccess(ShejiShiBean shejiShiData) {
                dataView.getSheSuccess(shejiShiData);
            }

            @Override
            public void setonLieSuccess(List<LieBiaoBean.DataBean> data) {

            }
        });
    }

    public void getList2Data() {

        dataModel.getList2Data(new DataModelImpl() {
            @Override
            public void setOnSuccess(BannerBean data) {

            }

            @Override
            public void setOnError() {

            }

            @Override
            public void setOnSheSuccess(ShejiShiBean shejiShiData) {

            }

            @Override
            public void setonLieSuccess(List<LieBiaoBean.DataBean> data) {
                dataView.getLieSuccess(data);
            }
        });
    }
}
