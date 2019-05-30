package com.example.project_giuakinhom11;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ChamCong_DTB extends SQLiteOpenHelper {
    private static String TenData_Base="ChamCong_DTB";
    private static String TenTable="ChamCong_TB";
    private static String ID="Id";
    private static String Ngay="Ngay";
    private static String MaCN="MaCN";
    private static String SOLG="SoLuong";

    public ChamCong_DTB(Context context) {
        super(context,TenData_Base,null, 1);
    }
    public void onCreate(SQLiteDatabase db) {
        String data="create table "+TenTable+"("+
                ID+" integer  primary key autoincrement,"+
                Ngay+" text ,"+
                MaCN+" text ,"+
                SOLG+" text "
                +")";
        db.execSQL(data);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void TaoChamCong(ChamCong chamCong)
    {
        SQLiteDatabase database=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Ngay,chamCong.getNgay());
        contentValues.put(MaCN,chamCong.getMaCN());
        contentValues.put(SOLG,chamCong.getSOLG());
        database.insert(TenTable,null,contentValues);
    }






    public ArrayList<ChamCong> DanhSachChamCong() {
        ArrayList<ChamCong> nguoichoi = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+TenTable,null);
        if(cursor.moveToFirst())
        {
            do
            {
                String IDa=cursor.getString(0);
                String Ngaya=cursor.getString(1);
                String Macna=cursor.getString(2);
                String SoLuonga=cursor.getString(3);
                nguoichoi.add(new ChamCong(IDa,Ngaya,Macna,SoLuonga));
            }while (cursor.moveToNext());
        }
        return nguoichoi;
    }
}
