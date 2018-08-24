package com.six.monthtext;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.six.monthtext.adapter.MyThreeAdapter;
import com.six.monthtext.base.BaseActivity;
import com.six.monthtext.bean.ImageThreeBean;
import com.six.monthtext.presenter.DataPresenterAll;
import com.six.monthtext.view.DataViewAll;

public class AllActivity extends BaseActivity implements DataViewAll {


    private RecyclerView all_Recy;
    private DataPresenterAll presenterAll;

    @Override
    protected void initLinsten() {

    }

    @Override
    protected void initData() {
        all_Recy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        presenterAll = new DataPresenterAll(this);
        presenterAll.getDatas();
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_all);
        all_Recy = findViewById(R.id.all_recy);
    }

    @Override
    public void getSuccess(ImageThreeBean imageThreeBean) {
        all_Recy.setAdapter(new MyThreeAdapter(AllActivity.this,imageThreeBean.getData()));
    }

    @Override
    public void getError() {

    }
}
