package com.example.ex6;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editten, editcmnd, editbosung;
    CheckBox chkbao, chksach, chkcode;
    Button btngui;
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editten = findViewById(R.id.edithoten);
        editcmnd = findViewById(R.id.editcmnd);
        editbosung = findViewById(R.id.editbosung);
        chkbao = findViewById(R.id.checkBoxbao);
        chksach = findViewById(R.id.checkBoxsach);
        chkcode = findViewById(R.id.checkBoxcoding);
        btngui = findViewById(R.id.btngui);
        btngui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShowInformation();
            }
        });
    }
    public void doShowInformation(){
        String ten = editten.getText().toString();
        ten = ten.trim();
        if(ten.length()<3){
            editten.requestFocus();
            editten.selectAll();
            Toast.makeText(this, "Ten >= 3 ky tu", Toast.LENGTH_LONG).show();
            return;
        }
        String cmnd = editcmnd.getText().toString();
        cmnd = cmnd.trim();
        if(cmnd.length()!=9){
            editcmnd.requestFocus();
            Toast.makeText(this, "CMND phai dung 9 ky tu", Toast.LENGTH_LONG).show();
            return;
        }
        String bang = "";
        group = findViewById(R.id.group);
        int id= group.getCheckedRadioButtonId();
        if(id==-1){
            Toast.makeText(this, "Phai cho bang cap", Toast.LENGTH_LONG).show();
        }
        RadioButton ra=findViewById(id);
        bang = ra.getText()+"";
        String sothich = "";
        if(chkbao.isChecked()){
            sothich+=chkbao.getText()+"\n";
        }
        if(chksach.isChecked()){
            sothich+=chksach.getText()+"\n";
        }
        if(chkcode.isChecked()){
            sothich+=chkcode.getText()+"\n";
        }
        String bosung = editbosung.getText()+"";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thong tin ca nhan");
        builder.setPositiveButton("Dong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        String msg=ten+"\n";
        msg+=cmnd+"\n";
        msg+=bang+"\n";
        msg+=sothich;
        msg+="------------\n";
        msg+="Thong tin bo sung:\n"+bosung;
        msg+="\n------------";
        builder.setMessage(msg);
        builder.create().show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exits?");
        b.setIcon(R.drawable.ic_launcher_background);
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        b.create().show();
    }


}