package com.example.project_giuakinhom11;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class PhanXuong_DTB extends SQLiteOpenHelper {
    private static String TenData_Base="PhanXuong_DTB";
    private static String TenTable="PhanXuong_TB";
    private static String MaPx="Mapx";
    private static String TenPx="TenPx";
    private static String MaSp="MaSp";

    public PhanXuong_DTB(Context context) {
        super(context,TenData_Base,null, 1);
    }


    public void onCreate(SQLiteDatabase db) {
        String data="create table "+TenTable+"("+
                MaPx+" integer primary key autoincrement ,"+
                TenPx+" text ,"+
                MaSp+" text "
                +")";
        db.execSQL(data);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void TaoPhanXuong(PhanXuong phanXuong)
    {
        SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(TenPx,phanXuong.getTenPx());
        contentValues.put(MaSp,phanXuong.getMaSp());
        database.insert(TenTable,null,contentValues);
    }
    public  void SuaPhanXuong(PhanXuong phanXuong)
    {
        SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(TenPx,phanXuong.getTenPx());
        contentValues.put(MaSp,phanXuong.getMaSp());
        database.update(TenTable,contentValues,MaPx+"=?",new String[]{phanXuong.getMaPx()});
    }



    public void XoaPhanXuong(PhanXuong phanXuong)
    {
        SQLiteDatabase database=getReadableDatabase();
        database.delete(TenTable,MaPx+"=?",new String[]{phanXuong.getMaPx()});
    }

    public PhanXuong ThongTinPhanXuong(String phanxuong)
    {
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor=database.query(TenTable,new String[]{MaPx,TenPx,MaSp},MaPx+"=?",new String[]{phanxuong},null,null,null);
        cursor.moveToNext();
        String mapx=cursor.getString(0);
        String tenpx=cursor.getString(1);
        String masp=cursor.getString(2);
        PhanXuong taiKhoanNguoiChoi=new PhanXuong(mapx,tenpx,masp);
        return taiKhoanNguoiChoi;
    }

    public ArrayList<PhanXuong> AllPhanXuong()
    {
        ArrayList<PhanXuong> phanxuongs=new ArrayList<>();
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from "+TenTable,null);
        if(cursor.moveToFirst())
        {
            do{
                String mapx=cursor.getString(0);
                String tenpx=cursor.getString(1);
                String masp=cursor.getString(2);
                phanxuongs.add(new PhanXuong(mapx,tenpx,masp));
            }
            while(cursor.moveToNext());
        }
        return phanxuongs;
    }


}
