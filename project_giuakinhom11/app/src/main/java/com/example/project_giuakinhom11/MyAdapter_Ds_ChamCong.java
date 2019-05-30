package com.example.project_giuakinhom11;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter_Ds_ChamCong extends BaseAdapter {
    Context context;
    ArrayList<ChamCong> ds;
    String chuoi;
    public MyAdapter_Ds_ChamCong(ArrayList<ChamCong> ds, Context context) {
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
        TextView id;
        TextView ngay;
        TextView macn;
        TextView soluong;


    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=((Activity) context).getLayoutInflater();

        TenvaDiem tenvaDiem;
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.quanlycongnhan,null);
            tenvaDiem=new TenvaDiem();
            tenvaDiem.id=(TextView) convertView.findViewById(R.id.macn);
            tenvaDiem.ngay=(TextView) convertView.findViewById(R.id.tencn);
            tenvaDiem.macn=(TextView) convertView.findViewById(R.id.ngaysinhcn);
            tenvaDiem.soluong=(TextView) convertView.findViewById(R.id.maphanxuongcn);
            convertView.setTag(tenvaDiem);
        }
        else
        {
            tenvaDiem=(TenvaDiem) convertView.getTag();
        }
        tenvaDiem.id.setText(ds.get(position).getId());
        tenvaDiem.ngay.setText(ds.get(position).getNgay()+" ");
        tenvaDiem.macn.setText(ds.get(position).getMaCN()+"");
        tenvaDiem.soluong.setText(ds.get(position).getSOLG()+"");
        return convertView;
    }
}
