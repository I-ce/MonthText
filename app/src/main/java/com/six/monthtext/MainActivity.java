package com.six.monthtext;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;
import com.six.monthtext.adapter.MyHuaAdapter;
import com.six.monthtext.adapter.MyLieAdapter;
import com.six.monthtext.base.BaseActivity;
import com.six.monthtext.bean.BannerBean;
import com.six.monthtext.bean.HanderBean;
import com.six.monthtext.bean.LieBiaoBean;
import com.six.monthtext.bean.ShejiShiBean;
import com.six.monthtext.presenter.DataPresenter;
import com.six.monthtext.server.IServer;
import com.six.monthtext.util.RetrofitUtils;
import com.six.monthtext.util.Utils;
import com.six.monthtext.view.DataView;
import com.stx.xhb.xbanner.XBanner;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements DataView, XBanner.XBannerAdapter {

    private RecyclerView recy_view;
    private DataPresenter presenter;
    private XBanner xbanner;
    private RecyclerView recyclerview_hua;
    private List<String> icons = new ArrayList<>();
    private String title;
    private List<String> titles = new ArrayList<>();
    private Button all, pull;
    private ImageView image_View;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101 && resultCode == Activity.RESULT_OK && null != data) {
            Uri data1 = data.getData();
            //String scheme = data1.getScheme();
            String s = getFileByUri(data1, MainActivity.this);
            //Toast.makeText(MainActivity.this,s+"123333312313",Toast.LENGTH_SHORT).show();
//            image_View.setImageURI(data1);
            File file = new File(s);
            PushImage("16929",file);



        }

    }

    @Override
    protected void initLinsten() {
    }

    @Override
    protected void initData() {
        recy_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerview_hua.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        presenter = new DataPresenter(this);
        presenter.getDatas();
        presenter.getListData();
        presenter.getList2Data();
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllActivity.class);
                startActivity(intent);
            }
        });


        pull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent picture = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(picture, 101);
            }
        });
    }

    @Override
    protected void initView() {

        setContentView(R.layout.activity_main);
        recy_view = findViewById(R.id.recyclerview);
        xbanner = findViewById(R.id.xbanner);
        recyclerview_hua = findViewById(R.id.recyclerview_hua);
        pull = findViewById(R.id.pull);
        image_View = findViewById(R.id.image_View);
        all = findViewById(R.id.all);

    }

    @Override
    public void getSuccess(BannerBean data) {
        final List<BannerBean.DataBean> data1 = data.getData();
        for (int i = 0; i < data1.size(); i++) {
            icons.add(data.getData().get(i).getIcon());
            titles.add(data.getData().get(i).getTitle());
        }
        xbanner.setData(icons, null);
        xbanner.setAutoPalyTime(3000);
        xbanner.setmAdapter(this);
        xbanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, int position) {
                Intent intent = new Intent(MainActivity.this, BannerActivity.class);
                intent.putExtra("url", data1.get(position).getUrl());
                startActivity(intent);
            }
        });
//        recy_view.setAdapter();
    }

    @Override
    public void getError() {

    }

    @Override
    public void getSheSuccess(ShejiShiBean shejiShiData) {
        Log.i("Aaaaaaaaaaa", shejiShiData.getData().getDisplay().size() + "");
        recyclerview_hua.setAdapter(new MyHuaAdapter(MainActivity.this, shejiShiData.getData()));

    }

    @Override
    public void getLieSuccess(List<LieBiaoBean.DataBean> data) {
        recy_view.setAdapter(new MyLieAdapter(MainActivity.this, data));
        recy_view.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestory();
    }

    @Override
    public void loadBanner(XBanner banner, Object model, View view, int position) {
        Glide.with(MainActivity.this).load(icons.get(position)).into((ImageView) view);
    }

    //上传头像
    public void PushImage(String uid, File file) {

        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("uid", uid);
        //注意，file是后台约定的参数，如果是多图，file[]，如果是单张图片，file就行
        builder.addFormDataPart("file", file.getName(),
                RequestBody.create(MediaType.parse("image/*"), file));
        RequestBody requestBody = builder.build();




        Observable<HanderBean> handerBeanObservables = RetrofitUtils.getInstance().getServer().PushImage(requestBody);
        handerBeanObservables.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HanderBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("aaaaaaaaaaaaaaaa", e.getMessage());
                    }

                    @Override
                    public void onNext(HanderBean handerBean) {
                        Toast.makeText(MainActivity.this, "handerBean" + handerBean.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    //获取用户信息
    public void getUserInfo() {
    }
    public static String getFileByUri(Uri uri, Context context) {
        String path = null;
        if ("file".equals(uri.getScheme())) {
            path = uri.getEncodedPath();
            if (path != null) {
                path = Uri.decode(path);
                ContentResolver cr = context.getContentResolver();
                StringBuffer buff = new StringBuffer();
                buff.append("(").append(MediaStore.Images.ImageColumns.DATA).append("=").append("'" + path + "'").append(")");
                Cursor cur = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{MediaStore.Images.ImageColumns._ID, MediaStore.Images.ImageColumns.DATA}, buff.toString(), null, null);
                int index = 0;
                int dataIdx = 0;
                for (cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext()) {
                    index = cur.getColumnIndex(MediaStore.Images.ImageColumns._ID);
                    index = cur.getInt(index);
                    dataIdx = cur.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    path = cur.getString(dataIdx);
                }
                cur.close();
                if (index == 0) {
                } else {
                    Uri u = Uri.parse("content://media/external/images/media/" + index);
                    System.out.println("temp uri is :" + u);
                }
            }
            if (path != null) {
                return path;
            }
        } else if ("content".equals(uri.getScheme())) {
            // 4.2.2以后
            String[] proj = {MediaStore.Images.Media.DATA};
            Cursor cursor = context.getContentResolver().query(uri, proj, null, null, null);

            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                path = cursor.getString(columnIndex);
            }
            Log.i("aaaaaaaa",path+"");
            cursor.close();
            return path;
        } else {
        }
        return null;
    }
}
