package com.example.thongtincanhan;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTen,ediCMND,ediBosung;
    CheckBox chkdocbao,chkdocsach,chkdoccode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTen=(EditText) findViewById(R.id.editTen);
        ediCMND=(EditText) findViewById(R.id.edtCMND);
        ediBosung=(EditText) findViewById(R.id.edtBosung);
        chkdocbao=(CheckBox) findViewById(R.id.chkdocbao);
        chkdoccode=(CheckBox) findViewById(R.id.chkdoccoding);
        chkdocsach = (CheckBox) findViewById(R.id.chkdocsach);
        Button btn=(Button) findViewById(R.id.btnguitt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShowInformation();
            }
        });
    }
    public void doShowInformation() {
        //Kiem tra ten hop le
        String ten= editTen.getText()+"";
        ten=ten.trim();
        if(ten.length()<3){
            editTen.requestFocus();
            editTen.selectAll();
            Toast.makeText(this,"Tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();

            return;
        }

        //Kiểm tra CMND hợp lệ
        String cmnd = ediCMND.getText()+"";
        cmnd=cmnd.trim();
        if(cmnd.length()!=9){
            ediCMND.requestFocus();
            ediCMND.selectAll();
            Toast.makeText(this,"CMND phải đúng 9 ký tự",Toast.LENGTH_LONG).show();
            return;
        }

        //Kiem tra bang cap
        String bang = "";
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup1);
        int id=group.getCheckedRadioButtonId();
        if(id==1)
        {
            Toast.makeText(this,"Phải chọn bằng cấp",Toast.LENGTH_LONG).show();
            return;
        }

        RadioButton rad=(RadioButton) findViewById(id);
        bang = rad.getText()+"";

        //Kiểm tra sở thích
        String sothich = "";
        if(chkdocbao.isChecked()){
            sothich += chkdocbao.getText()+"\n";
        }
        if(chkdocsach.isChecked())
            sothich += chkdocsach.getText()+"\n";
        if(chkdoccode.isChecked())
            sothich += chkdoccode.getText()+"\n";

        String bosung = ediBosung.getText()+"";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
                //Tạo nội dung
        String msg = ten+"\n";
        msg += cmnd+"\n";
        msg+=bang+"\n";
        msg+=sothich;
        msg+="________________________\n";
        msg+="Thông tin bổ sung.\n";
        msg+=bosung+"\n";
        msg+="_________________________";
        builder.setMessage(msg);//thiết lập nội dung
        builder.create().show();//Hiển thị dialog
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.activity_main,menu);
//        return true;
//    }
}
