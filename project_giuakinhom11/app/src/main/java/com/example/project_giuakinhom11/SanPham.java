package com.example.project_giuakinhom11;


public class SanPham {
    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String maSp) {
        MaSp = maSp;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getDonGio() {
        return DonGio;
    }

    public void setDonGio(String donGio) {
        DonGio = donGio;
    }

    public SanPham(String maSp, String tenSP, String donGio) {
        MaSp = maSp;
        TenSP = tenSP;
        DonGio = donGio;
    }

    public SanPham( String tenSP, String donGio) {

        TenSP = tenSP;
        DonGio = donGio;
    }

    public SanPham( ) {

    }

    private  String MaSp="MaSP";
    private  String TenSP="TenSP";
    private  String DonGio="DonGia";
}
