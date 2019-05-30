package com.example.project_giuakinhom11;


public class ChamCong {
    private  String Id;
    private  String Ngay;
    private  String MaCN;
    private  String SOLG;

    public ChamCong() {

    }

    public ChamCong(String id, String ngay, String maCN, String SOLG) {
        Id = id;
        Ngay = ngay;
        MaCN = maCN;
        this.SOLG = SOLG;
    }
    public ChamCong( String ngay, String maCN, String SOLG) {
        Ngay = ngay;
        MaCN = maCN;
        this.SOLG = SOLG;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    public String getMaCN() {
        return MaCN;
    }

    public void setMaCN(String maCN) {
        MaCN = maCN;
    }

    public String getSOLG() {
        return SOLG;
    }

    public void setSOLG(String SOLG) {
        this.SOLG = SOLG;
    }







}
