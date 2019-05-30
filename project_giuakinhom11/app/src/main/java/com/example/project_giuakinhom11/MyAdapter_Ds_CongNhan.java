package com.example.project_giuakinhom11;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter_Ds_CongNhan extends BaseAdapter {
    Context context;
    ArrayList<CongNhan> ds;
    String chuoi;
    public MyAdapter_Ds_CongNhan(ArrayList<CongNhan> ds, Context context) {
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
        TextView macn;
        TextView tencn;
        TextView ngaysinh;
        TextView phongxuong;


    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=((Activity) context).getLayoutInflater();

        TenvaDiem tenvaDiem;
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.quanlycongnhan,null);
            tenvaDiem=new TenvaDiem();
            tenvaDiem.macn=(TextView) convertView.findViewById(R.id.macn);
            tenvaDiem.tencn=(TextView) convertView.findViewById(R.id.tencn);
            tenvaDiem.ngaysinh=(TextView) convertView.findViewById(R.id.ngaysinhcn);
            tenvaDiem.phongxuong=(TextView) convertView.findViewById(R.id.maphanxuongcn);
            convertView.setTag(tenvaDiem);
        }
        else
        {
            tenvaDiem=(TenvaDiem) convertView.getTag();
        }
        tenvaDiem.macn.setText(ds.get(position).getMaCN());
        tenvaDiem.tencn.setText(ds.get(position).getHo()+" "+ds.get(position).getTen());
        tenvaDiem.ngaysinh.setText(ds.get(position).getNamSinh()+"");
        tenvaDiem.phongxuong.setText(ds.get(position).getMaPx()+"");
        return convertView;
    }
}
