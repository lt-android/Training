package com.example.project_giuakinhom11;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter_Ds_PhanXuong extends BaseAdapter {
    Context context;
    ArrayList<PhanXuong> ds;
    String chuoi;
    public MyAdapter_Ds_PhanXuong(ArrayList<PhanXuong> ds, Context context) {
        this.context=context;
        this.ds = ds;
    }
    public int getCount() {
        return ds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class TenvaDiem
    {
        TextView ma;
        TextView ten;
        TextView masp;



    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=((Activity) context).getLayoutInflater();

        TenvaDiem tenvaDiem;
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.quanlyphanxuong,null);
            tenvaDiem=new TenvaDiem();
            tenvaDiem.ma=(TextView) convertView.findViewById(R.id.mapx_phanxuong);
            tenvaDiem.ten=(TextView) convertView.findViewById(R.id.tenpx_phanxuong);
            tenvaDiem.masp=(TextView) convertView.findViewById(R.id.masp_phanxuong);

            convertView.setTag(tenvaDiem);
        }
        else
        {
            tenvaDiem=(TenvaDiem) convertView.getTag();
        }
        tenvaDiem.ma.setText(ds.get(position).getMaPx());
        tenvaDiem.ten.setText(ds.get(position).getTenPx());
        tenvaDiem.masp.setText(ds.get(position).getMaSp());

        return convertView;
    }
}
