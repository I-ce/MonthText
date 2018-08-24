package com.six.monthtext.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.six.monthtext.AllActivity;
import com.six.monthtext.R;
import com.six.monthtext.bean.ImageThreeBean;

import java.util.List;

public class MyThreeAdapter extends RecyclerView.Adapter<MyThreeAdapter.TextHolder> {

    private Context context;
    private List<ImageThreeBean.DataBean> list;

    public MyThreeAdapter(Context context, List<ImageThreeBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TextHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.lieitem, null);
        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextHolder holder, int position) {
        holder.lieitem_icon.setImageURI(list.get(position).getImages().split("\\|")[0]);
        holder.lileitem_title.setText(list.get(position).getTitle());
        holder.lieitem_createtime.setText(list.get(position).getCreatetime());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class TextHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView lieitem_icon;
        private final TextView lieitem_createtime;
        private final TextView lileitem_title;

        public TextHolder(View itemView) {
            super(itemView);
            lieitem_icon = itemView.findViewById(R.id.lieitem_icon);
            lieitem_createtime = itemView.findViewById(R.id.lieitem_createtime);
            lileitem_title = itemView.findViewById(R.id.lileitem_title);
        }
    }
}
