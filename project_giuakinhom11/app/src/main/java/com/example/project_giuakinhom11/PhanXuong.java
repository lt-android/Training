package com.example.project_giuakinhom11;


public class PhanXuong {
    public PhanXuong() {

    }

    public PhanXuong(String maPx, String tenPx, String maSp) {
        MaPx = maPx;
        TenPx = tenPx;
        MaSp = maSp;
    }
    public PhanXuong(String maPx) {
        MaPx = maPx;

    }
    public PhanXuong( String tenPx, String maSp) {
        TenPx = tenPx;
        MaSp = maSp;
    }

    public String getMaPx() {
        return MaPx;
    }

    public void setMaPx(String maPx) {
        MaPx = maPx;
    }

    public String getTenPx() {
        return TenPx;
    }

    public void setTenPx(String tenPx) {
        TenPx = tenPx;
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String maSp) {
        MaSp = maSp;
    }

    private  String MaPx="Mapx";
    private  String TenPx="TenPx";
    private  String MaSp="MaSp";
}
