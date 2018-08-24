package com.six.monthtext.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.six.monthtext.MainActivity;
import com.six.monthtext.R;
import com.six.monthtext.bean.ShejiShiBean;

import java.util.List;

public class MyHuaAdapter extends RecyclerView.Adapter<MyHuaAdapter.TextHolder> {

    private Context context;
    private ShejiShiBean.DataBean lists;

    public MyHuaAdapter(Context context, ShejiShiBean.DataBean lists) {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public TextHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.sheitem, null);

        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextHolder holder, int position) {
        holder.sheitem_icon.setImageURI(lists.getDisplay().get(position).getAvatar());
        holder.sheitem_title.setText(lists.getDisplay().get(position).getNick_name());
    }

    @Override
    public int getItemCount() {
        return lists.getDisplay().size();
    }

    public class TextHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sheitem_icon;
        private final TextView sheitem_title;

        public TextHolder(View itemView) {
            super(itemView);
            sheitem_icon = itemView.findViewById(R.id.sheitem_icon);
            sheitem_title = itemView.findViewById(R.id.sheitem_title);
        }
    }
}
