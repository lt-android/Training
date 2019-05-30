package com.example.project_giuakinhom11;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class QuanLy_CongNhan extends AppCompatActivity {

    Button capnhat, chamcong, phanxuong, thoat, themcongnhan;
    EditText ma, ho, ten, phai, ngaysinh, ngaynhanviec, luong, maphanxuong;

    CongNhan_DTB congNhan_dtb;
    ChamCong_DTB chamCong_dtb;
    PhanXuong_DTB phanxuong_dtb;
    SanPham_DTB sanPham_dtb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlycongnhan);
        congNhan_dtb = new CongNhan_DTB(QuanLy_CongNhan.this);
        chamCong_dtb = new ChamCong_DTB(QuanLy_CongNhan.this);
        phanxuong_dtb = new PhanXuong_DTB(QuanLy_CongNhan.this);
        sanPham_dtb = new SanPham_DTB(QuanLy_CongNhan.this);
        final CongNhan congnhan = (CongNhan) getIntent().getExtras().getSerializable("congnhan");
        anhxa();


        ma.setText(congnhan.getMaCN());
        ten.setText(congnhan.getTen());
        ho.setText(congnhan.getHo());
        phai.setText(congnhan.getPhai());
        ngaysinh.setText(congnhan.getNamSinh());
        ngaynhanviec.setText(congnhan.getNgayNhanViec());
        luong.setText(congnhan.getLuongCoBan());
        maphanxuong.setText(congnhan.getMaPx());


        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(QuanLy_CongNhan.this, MainActivity.class);
                startActivityForResult(intent, 9999);
            }
        });
        chamcong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(QuanLy_CongNhan.this);
                LayoutInflater inflater = getLayoutInflater();
                View x = inflater.inflate(R.layout.dialog_chamcong, null);
                final EditText macn = x.findViewById(R.id.macongnhan_chamcong);
                final EditText ngay = x.findViewById(R.id.ngay_chamcong);
                final EditText soluong = x.findViewById(R.id.soluong_chamcong);
                macn.setText(congnhan.getMaCN().toString());

                final Button thoat = (Button) x.findViewById(R.id.cham_chamcong);
                builder.setCancelable(true);
                builder.setView(x);
                final AlertDialog dialog = builder.create();
                dialog.show();
                thoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (ngay.getText().toString().equals("")) {
                            Toast.makeText(QuanLy_CongNhan.this, "Ngày chấm công trống !", Toast.LENGTH_SHORT).show();
                        } else if (soluong.getText().toString().equals("")) {
                            Toast.makeText(QuanLy_CongNhan.this, "Số lượng rỗng !", Toast.LENGTH_SHORT).show();

                        } else {
                            chamCong_dtb.TaoChamCong(new ChamCong(ngay.getText().toString(), congnhan.getMaCN().toString(), soluong.getText().toString()));
                            dialog.dismiss();
                        }


                    }
                });


            }
        });
        phanxuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(QuanLy_CongNhan.this);
                LayoutInflater inflater = getLayoutInflater();
                View x = inflater.inflate(R.layout.dialog_thongtinxuong, null);
                final EditText mapx = x.findViewById(R.id.xemmapx_edit);
                final EditText tenpx = x.findViewById(R.id.xemtenpx_edit);


                mapx.setText(phanxuong_dtb.ThongTinPhanXuong(congnhan.getMaPx()).getMaPx());
                tenpx.setText(phanxuong_dtb.ThongTinPhanXuong(congnhan.getMaPx()).getTenPx());

                final Button thoat = (Button) x.findViewById(R.id.thoatpx_edit);
                builder.setCancelable(true);
                builder.setView(x);
                final AlertDialog dialog = builder.create();
                dialog.show();
                thoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                });
            }
        });
        capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                congNhan_dtb.SuaCongNhan(new CongNhan(ma.getText().toString(), ho.getText().toString(),
                        ten.getText().toString(),
                        phai.getText().toString(),
                        ngaysinh.getText().toString(),
                        ngaynhanviec.getText().toString(),
                        luong.getText().toString(),
                        maphanxuong.getText().toString()
                ));
                finish();
                Intent intent = new Intent(QuanLy_CongNhan.this, MainActivity.class);
                startActivityForResult(intent, 9999);
                Toast.makeText(QuanLy_CongNhan.this, "Cập Nhật Thành Công", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onBackPressed() {
        finish();
        Intent intent = new Intent(QuanLy_CongNhan.this, MainActivity.class);
        startActivityForResult(intent, 9999);
    }

    public void anhxa() {
        ma=findViewById(R.id.macn_edit);
        ho=findViewById(R.id.ho_edit);
        ten=findViewById(R.id.ten_edit);
        phai=findViewById(R.id.phai_edit);
        ngaysinh=findViewById(R.id.ngaysinh_edit);
        ngaynhanviec=findViewById(R.id.ngaynhanviec_edit);
        luong=findViewById(R.id.luong_edit);
        maphanxuong=findViewById(R.id.maphanxuong_edit);
        capnhat = findViewById(R.id.capnhat_edit);
        chamcong = findViewById(R.id.chamcong_edit);
        phanxuong = findViewById(R.id.xemphanxuong_edit);
        thoat = findViewById(R.id.thoat_edit);
    }
}