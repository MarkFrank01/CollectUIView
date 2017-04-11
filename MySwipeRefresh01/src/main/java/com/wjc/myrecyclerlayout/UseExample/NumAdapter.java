package com.wjc.myrecyclerlayout.UseExample;

import android.content.Context;


import com.wjc.myrecyclerlayout.R;
import com.wjc.myrecyclerlayout.adapter.JCRecyclerAdapter;
import com.wjc.myrecyclerlayout.adapter.JCViewHolder;

import java.util.List;

/**
 * Created by Angel on 2017/4/7.
 */
public class NumAdapter extends JCRecyclerAdapter<String> {

    private List<String> list;
    private Context context;

    public NumAdapter(Context context, List<String> list) {
        super(context, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.item;
    }

    @Override
    public void bindData(JCViewHolder holder, int position, String item) {
        holder.getTextView(R.id.text).setText(list.get(position)+"");
    }

    @Override
    public void add(int positon, String item) {
        super.add(positon, item);
    }

    @Override
    public void delete(int positon) {
        super.delete(positon);
    }
}
