package com.ysy.talkheart.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Shengyu Yao on 2016/11/23.
 */

public class MeMarkListViewAdapter extends RecyclerView.Adapter<MeMarkListViewAdapter.RecyclerViewHolder> {

    private ListOnItemClickListener mOnItemClickListener;

    public void setListOnItemClickListener(ListOnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        RecyclerViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public MeMarkListViewAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MeMarkListViewAdapter.RecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
