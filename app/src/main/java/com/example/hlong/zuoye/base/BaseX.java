package com.example.hlong.zuoye.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.hlong.zuoye.R;
import com.example.hlong.zuoye.bean.Student;

import java.util.ArrayList;

public class BaseX extends RecyclerView.Adapter<BaseX.ViewHolder> {
    ArrayList<Student.ResultBean> list;
    Context context;

    public BaseX(ArrayList<Student.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.wen, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
    holder.tv.setText(list.get(position).getText());
        Glide.with(context).load(list.get(position).getThumbnail()).apply(new RequestOptions().circleCrop()).into(holder.iv);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clike.clike(position,list.get(position));
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_wen);
            iv = itemView.findViewById(R.id.iv_wen);
        }
    }
    private Clike clike;

    public void setClike(Clike clike) {
        this.clike = clike;
    }

    public  interface  Clike{
        void clike(int po,Student.ResultBean resultBean);
    }
}
