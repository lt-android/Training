package com.example.project_giuakinhom11;


import java.io.Serializable;

public class CongNhan implements Serializable {
    public String getMaCN() {
        return MaCN;
    }

    public void setMaCN(String maCN) {
        MaCN = maCN;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String ho) {
        Ho = ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getPhai() {
        return Phai;
    }

    public void setPhai(String phai) {
        Phai = phai;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String namSinh) {
        NamSinh = namSinh;
    }

    public String getNgayNhanViec() {
        return NgayNhanViec;
    }

    public void setNgayNhanViec(String ngayNhanViec) {
        NgayNhanViec = ngayNhanViec;
    }

    public String getLuongCoBan() {
        return LuongCoBan;
    }

    public void setLuongCoBan(String luongCoBan) {
        LuongCoBan = luongCoBan;
    }

    public String getMaPx() {
        return MaPx;
    }

    public void setMaPx(String maPx) {
        MaPx = maPx;
    }

    public CongNhan() {

    }

    public CongNhan(String maCN, String ho, String ten, String phai, String namSinh, String ngayNhanViec, String luongCoBan, String maPx) {
        MaCN = maCN;
        Ho = ho;
        Ten = ten;
        Phai = phai;
        NamSinh = namSinh;
        NgayNhanViec = ngayNhanViec;
        LuongCoBan = luongCoBan;
        MaPx = maPx;
    }
    public CongNhan(String ho, String ten, String phai, String namSinh, String ngayNhanViec, String luongCoBan, String maPx) {

        Ho = ho;
        Ten = ten;
        Phai = phai;
        NamSinh = namSinh;
        NgayNhanViec = ngayNhanViec;
        LuongCoBan = luongCoBan;
        MaPx = maPx;
    }

    private String MaCN;
    private  String Ho;
    private  String Ten;
    private  String Phai;
    private  String NamSinh;
    private  String NgayNhanViec;
    private  String LuongCoBan;
    private  String MaPx;
}
