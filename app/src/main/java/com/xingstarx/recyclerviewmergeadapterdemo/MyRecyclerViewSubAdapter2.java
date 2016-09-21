package com.xingstarx.recyclerviewmergeadapterdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.mvdw.recyclerviewmergeadapter.adapter.RecyclerViewSubAdapter;

/**
 * Created by xiongxingxing on 16/9/21.
 */
public class MyRecyclerViewSubAdapter2 extends RecyclerView.Adapter<MyRecyclerViewSubAdapter2.ViewHolder> {

    private List<String> dataList;

    public void setDataList(List<String> dataList) {
        this.dataList = dataList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerViewSubAdapter.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }


}
