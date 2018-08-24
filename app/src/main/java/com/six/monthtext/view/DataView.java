package com.six.monthtext.view;

import com.six.monthtext.bean.BannerBean;
import com.six.monthtext.bean.LieBiaoBean;
import com.six.monthtext.bean.ShejiShiBean;

import java.util.List;

public interface DataView {
    void getSuccess(BannerBean data);
    void getError();

    void getSheSuccess(ShejiShiBean shejiShiData);

    void getLieSuccess(List<LieBiaoBean.DataBean> data);

}
