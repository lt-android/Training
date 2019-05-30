package com.example.project_giuakinhom11;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class CongNhan_DTB extends SQLiteOpenHelper {
    private static String TenData_Base="CongNhan_DTB";
    private static String TenTable="CongNhan_TB";
    private static String MaCN="MaCN";
    private static String Ho="Ho";
    private static String Ten="Ten";
    private static String Phai="Phai";
    private static String NamSinh="NgaySinh";
    private static String NgayNhanViec="NgayNV";
    private static String LuongCoBan="LuongCB";
    private static String MaPx="MaPx";
    public CongNhan_DTB(Context context) {
        super(context,TenData_Base,null, 1);
    }


    public void onCreate(SQLiteDatabase db) {
        String data="create table "+TenTable+"("+
                MaCN+" integer primary key autoincrement ,"+
                Ho+" text ,"+
                Ten+" text ,"+
                Phai+" text ,"+
                NamSinh+" text ,"+
                NgayNhanViec+" text ,"+
                LuongCoBan+" text ,"+
                MaPx+" text "
                +")";
        db.execSQL(data);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void TaoCongNhan(CongNhan congNhan)
    {
        SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Ho,congNhan.getHo());
        contentValues.put(Ten,congNhan.getTen());
        contentValues.put(Phai,congNhan.getPhai());
        contentValues.put(NamSinh,congNhan.getNamSinh());
        contentValues.put(NgayNhanViec,congNhan.getNgayNhanViec());
        contentValues.put(LuongCoBan,congNhan.getLuongCoBan());
        contentValues.put(MaPx,congNhan.getMaPx());
        database.insert(TenTable,null,contentValues);
    }
    public  void SuaCongNhan(CongNhan congNhan)
    {
        SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Ho,congNhan.getHo());
        contentValues.put(Ten,congNhan.getTen());
        contentValues.put(Phai,congNhan.getPhai());
        contentValues.put(NamSinh,congNhan.getNamSinh());
        contentValues.put(NgayNhanViec,congNhan.getNgayNhanViec());
        contentValues.put(LuongCoBan,congNhan.getLuongCoBan());
        contentValues.put(MaPx,congNhan.getMaPx());
        database.update(TenTable,contentValues,MaCN+"=?",new String[]{congNhan.getMaCN()});
    }


    public CongNhan XemThongTinCongNhan(CongNhan congNhan)
    {
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor=database.query(TenTable,new String[]{MaCN,Ho,Ten,Phai,NamSinh,NgayNhanViec,LuongCoBan,MaPx},MaCN+"=?",new String[]{congNhan.getMaCN()},null,null,null);
        cursor.moveToNext();
        String macn=cursor.getString(0);
        String ho=cursor.getString(1);
        String ten=cursor.getString(2);
        String phai=cursor.getString(3);
        String namsinh=cursor.getString(4);
        String ngaynhanvien=cursor.getString(5);
        String luongcb=cursor.getString(6);
        String mapx=cursor.getString(7);
        CongNhan congnhan=new CongNhan(macn,ho,ten,phai,namsinh,ngaynhanvien,luongcb,mapx);
        return congnhan;
    }
    public void XoaCongNhan(CongNhan congNhan)
    {
        SQLiteDatabase database=getReadableDatabase();
        database.delete(TenTable,MaCN+"=?",new String[]{congNhan.getMaCN()});
    }




    public ArrayList<CongNhan> ALlCongNhan()
    {
        ArrayList<CongNhan> nguoiDungs=new ArrayList<>();
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from "+TenTable,null);
        if(cursor.moveToFirst())
        {
            do{
                String macn=cursor.getString(0);
                String ho=cursor.getString(1);
                String ten=cursor.getString(2);
                String phai=cursor.getString(3);
                String namsinh=cursor.getString(4);
                String ngaynhanvien=cursor.getString(5);
                String luongcb=cursor.getString(6);
                String mapx=cursor.getString(7);
                CongNhan congnhan=new CongNhan(macn,ho,ten,phai,namsinh,ngaynhanvien,luongcb,mapx);
                nguoiDungs.add(congnhan);
            }
            while(cursor.moveToNext());
        }
        return nguoiDungs;
    }


}
