package com.wjc.myrecyclerlayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Angel on 2017/3/28.
 */
public abstract class JCRecyclerAdapter<T> extends RecyclerView.Adapter<JCViewHolder> {

    private Context context;
    private List<T> list;
    private LayoutInflater inflater;

    public JCRecyclerAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public JCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final JCViewHolder holder = new JCViewHolder(
                inflater.inflate(getItemLayoutId(viewType), parent, false));
        return holder;
    }

    public void onBindViewHolder(JCViewHolder holder, int position) {
        bindData(holder, position, list.get(position));
    }

    abstract public int getItemLayoutId(int viewType);

    abstract public void bindData(JCViewHolder holder, int position, T item);

    public int getItemCount() {
        return list.size();
    }

    public void add(int positon, T item) {
        list.add(positon, item);
        notifyItemInserted(positon);
    }

    public void delete(int positon) {
        list.remove(positon);
        notifyItemRemoved(positon);
    }
}
