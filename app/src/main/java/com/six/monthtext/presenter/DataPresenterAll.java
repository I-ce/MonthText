package com.six.monthtext.presenter;

import com.six.monthtext.bean.ImageThreeBean;
import com.six.monthtext.model.DataModelplall;
import com.six.monthtext.view.DataViewAll;

public class DataPresenterAll implements DataPresenterAllImpl{

    private DataViewAll dataViewAll;
    private DataModelImplAll dataModelImplAll;

    public DataPresenterAll(DataViewAll dataViewAll) {
        this.dataViewAll = dataViewAll;
        dataModelImplAll = new DataModelImplAll();
    }

    @Override
    public void onDestory() {
        dataViewAll = null;
    }

    public void getDatas() {
        dataModelImplAll.getData(new DataModelplall() {
            @Override
            public void setOnSuccess(ImageThreeBean imageThreeBean) {
                dataViewAll.getSuccess(imageThreeBean);
            }

            @Override
            public void setOnError() {

            }
        });

    }
}
