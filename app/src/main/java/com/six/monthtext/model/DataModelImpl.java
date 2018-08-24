package com.six.monthtext.model;

import com.six.monthtext.bean.BannerBean;
import com.six.monthtext.bean.LieBiaoBean;
import com.six.monthtext.bean.ShejiShiBean;

import java.util.List;

public interface DataModelImpl {
    void setOnSuccess(BannerBean data);
    void setOnError();

    void setOnSheSuccess(ShejiShiBean shejiShiData);

    void setonLieSuccess(List<LieBiaoBean.DataBean> data);
}
