package com.highgreat.sven.demo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;


public class CommAdapter<T> extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private int layoutId;
    private int variableId;//会自动生成

    private List<T> list;


    public CommAdapter(Context context, LayoutInflater inflater, int layoutId, int variableId, List<T> list) {
        this.context = context;
        this.inflater = inflater;
        this.layoutId = layoutId;
        this.variableId = variableId;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding dataBinding;
        if(convertView==null){
            dataBinding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        }else{
            dataBinding = DataBindingUtil.getBinding(convertView);
        }
        dataBinding.setVariable(variableId,list.get(position));
        return dataBinding.getRoot().getRootView();
    }
}
