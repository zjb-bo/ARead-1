package com.aread.cn.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aread.cn.R;
import com.aread.cn.bean.RecordTextBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobo on 2017/5/23.
 */

public class MainActivityRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<RecordTextBean> datas;
    private Context mContext;
    private LayoutInflater inflater;

    public MainActivityRecycleViewAdapter(Context context) {
        this.datas = new ArrayList<>();
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void addDatas(List<RecordTextBean> datas){
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.item_recyclerview_main, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        MyViewHolder mHolder = (MyViewHolder) holder;
//        try {
//            RecordTextBean recordTextBean = datas.get(position);
//            mHolder.time.setText(recordTextBean.getCreatTime());
//            mHolder.content.setText(recordTextBean.getContent());
//            mHolder.type.setText(recordTextBean.getTextStyle());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    @Override
    public int getItemCount() {
        return datas==null?0:datas.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView time,type,content;
        public MyViewHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.creatTime);
            type = (TextView) itemView.findViewById(R.id.type);
            content = (TextView) itemView.findViewById(R.id.content);
        }
    }
}
