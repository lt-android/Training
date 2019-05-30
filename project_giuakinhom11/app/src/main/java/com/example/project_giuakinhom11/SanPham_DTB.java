package com.example.project_giuakinhom11;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SanPham_DTB extends SQLiteOpenHelper {
    private static String TenData_Base="ThongTinNguoiChoi";
    private static String TenTable="ThongTin_NguoiChoi";
    private static String MaSp="MaSP";
    private static String TenSP="TenSP";
    private static String DonGia="DonGia";
    public SanPham_DTB(Context context) {
        super(context,TenData_Base,null, 1);
    }


    public void onCreate(SQLiteDatabase db) {
        String data="create table "+TenTable+"("+
                MaSp+" integer primary key autoincrement ,"+
                TenSP+" text ,"+
                DonGia+" text "
                +")";
        db.execSQL(data);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void TaoSp(SanPham sanPham)
    {
        SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(TenSP,sanPham.getTenSP());
        contentValues.put(DonGia,sanPham.getDonGio());

        database.insert(TenTable,null,contentValues);
    }
    public  void SuaSanPham(SanPham sanPham)
    {
        SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(TenSP,sanPham.getTenSP());
        contentValues.put(DonGia,sanPham.getDonGio());
        database.update(TenTable,contentValues,MaSp+"=?",new String[]{sanPham.getMaSp()});
    }



    public void XoaSP(SanPham sanPham)
    {
        SQLiteDatabase database=getReadableDatabase();
        database.delete(TenTable,MaSp+"=?",new String[]{sanPham.getMaSp()});
    }

    public SanPham ThongTinSanPham(String maSp)
    {
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor=database.query(TenTable,new String[]{MaSp,TenSP,DonGia},MaSp+"=?",new String[]{maSp},null,null,null);
        cursor.moveToNext();
        String masp=cursor.getString(0);
        String tensp=cursor.getString(1);
        String dongia=cursor.getString(2);
        SanPham sanpham=new SanPham(masp,tensp,dongia);
        return sanpham;
    }

    public ArrayList<SanPham> DanhSachTatCaSanPham() {
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TenTable,null);
        if(cursor.moveToFirst())
        {
            do
            {
                String masp=cursor.getString(0);
                String tensp=cursor.getString(1);
                String dongia=cursor.getString(2);
                SanPham sanpham=new SanPham(masp,tensp,dongia);
                sanPhams.add(sanpham);
            }while (cursor.moveToNext());
        }

        return sanPhams;
    }
}
