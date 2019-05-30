package com.example.project_giuakinhom11;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    ViewPager listne;
    TextView tieude;
    CongNhan_DTB congNhan_dtb;
    ChamCong_DTB chamCong_dtb;
    PhanXuong_DTB phanxuong_dtb;
    SanPham_DTB sanPham_dtb;
    ArrayList<CongNhan> listcongnhan_list;
    ArrayList<ChamCong> listchamcong_list;
    ArrayList<PhanXuong> listphanxuong_list;
    ArrayList<SanPham> listsanpham_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listne= findViewById(R.id.viewne);
        tieude=findViewById(R.id.tieude);
        congNhan_dtb=new CongNhan_DTB(MainActivity.this);
        chamCong_dtb=new ChamCong_DTB(MainActivity.this);
        phanxuong_dtb=new PhanXuong_DTB(MainActivity.this);
        sanPham_dtb=new SanPham_DTB(MainActivity.this);
        ListView listCongNhan = new ListView(this);
        ListView listChamCong = new ListView(this);
        final ListView listphanxuong = new ListView(this);
        ListView listsanpham = new ListView(this);
        Vector<View> pages = new Vector<View>();
        pages.add(listCongNhan);
        pages.add(listChamCong);
        pages.add(listphanxuong);
        pages.add(listsanpham);
        ViewPager vp = (ViewPager) findViewById(R.id.viewne);
        Adapter_viewP adapter = new Adapter_viewP(this,pages);
        vp.setAdapter(adapter);
        listne.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0)
                {
                    tieude.setText("Danh Sách Công Nhân");

                }
                if(position==1)
                {
                    tieude.setText("Danh Sách Chấm Công");

                }
                if(position==2)
                {
                    tieude.setText("Danh Sách Phân Xưởng");
                }
                if(position==3)
                {
                    tieude.setText("Danh Sách Sản Phẩm");
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




        listcongnhan_list = new ArrayList<CongNhan>();
        listcongnhan_list=congNhan_dtb.ALlCongNhan();
        MyAdapter_Ds_CongNhan abc = new MyAdapter_Ds_CongNhan(listcongnhan_list,this);
        listCongNhan.setAdapter(abc);


        listchamcong_list = new ArrayList<ChamCong>();
        listchamcong_list=chamCong_dtb.DanhSachChamCong();
        MyAdapter_Ds_ChamCong abcd = new MyAdapter_Ds_ChamCong(listchamcong_list,this);
        listChamCong.setAdapter(abcd);


        listphanxuong_list = new ArrayList<PhanXuong>();
        listphanxuong_list=phanxuong_dtb.AllPhanXuong();
        MyAdapter_Ds_PhanXuong abcde = new MyAdapter_Ds_PhanXuong(listphanxuong_list,this);
        listphanxuong.setAdapter(abcde);



        listsanpham_list= new ArrayList<SanPham>();
        listsanpham_list=sanPham_dtb.DanhSachTatCaSanPham();
        MyAdapter_Ds_SanPham abcdef = new MyAdapter_Ds_SanPham(listsanpham_list,this);
        listsanpham.setAdapter(abcdef);


        listCongNhan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, QuanLy_CongNhan.class);
                intent.putExtra("congnhan", listcongnhan_list.get(position));
                startActivityForResult(intent, 9999);
                finish();
            }
        });

        listChamCong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

        listphanxuong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View x = inflater.inflate(R.layout.dialog_themcongnhan, null);
                final EditText ma = x.findViewById(R.id.macn_them_px);
                final EditText ho = x.findViewById(R.id.ho_them_px);
                final EditText ten = x.findViewById(R.id.ten_them_px);
                final EditText phai = x.findViewById(R.id.phai_them_px);

                final EditText ngaysinh = x.findViewById(R.id.ngaysinh_them_px);
                final EditText ngaylv = x.findViewById(R.id.ngaynhanviec_them_px);
                final EditText luong = x.findViewById(R.id.luong_them_px);
                final EditText maxuong = x.findViewById(R.id.maphanxuong_them_px);
                maxuong.setText(listphanxuong_list.get(position).getMaPx().toString());



                final Button tao = (Button) x.findViewById(R.id.themcongnhan_px);
                builder.setCancelable(true);
                builder.setView(x);
                final AlertDialog dialog = builder.create();
                dialog.show();
                tao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if( ten.getText().toString().equals(""))
                        {
                            Toast.makeText(MainActivity.this, "Tên rỗng!", Toast.LENGTH_SHORT).show();
                        }
                        else if(ho.getText().toString().equals(""))
                        {
                            Toast.makeText(MainActivity.this, "Họ rỗng!", Toast.LENGTH_SHORT).show();

                        }
                        else if(phai.getText().toString().equals(""))
                        {
                            Toast.makeText(MainActivity.this, "Phai rỗng!", Toast.LENGTH_SHORT).show();

                        }
                        else if(ngaysinh.getText().toString().equals(""))
                        {
                            Toast.makeText(MainActivity.this, "Ngày Sinh rỗng!", Toast.LENGTH_SHORT).show();

                        }
                        else if(ngaylv.getText().toString().equals(""))
                        {
                            Toast.makeText(MainActivity.this, "Ngày Làm việc rỗng!", Toast.LENGTH_SHORT).show();

                        }
                        else if(luong.getText().toString().equals(""))
                        {
                            Toast.makeText(MainActivity.this, "Lương rỗng!", Toast.LENGTH_SHORT).show();

                        }
                            else{
                            congNhan_dtb.TaoCongNhan(new CongNhan(ho.getText().toString(),
                                    ten.getText().toString()
                                    , phai.getText().toString(),
                                    ngaysinh.getText().toString(),
                                    ngaylv.getText().toString(),
                                    luong.getText().toString(),
                                    maxuong.getText().toString()));
                            dialog.dismiss();
                        }


                    }
                });
            }
        });
        listsanpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });


    }



}
