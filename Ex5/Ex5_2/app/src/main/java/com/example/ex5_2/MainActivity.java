package com.example.ex5_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btntieptuc, btngiai, btnthoat;
    EditText edita, editb, editc;
    TextView txtketqua;
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
        btntieptuc = findViewById(R.id.btntieptuc);
        btngiai = findViewById(R.id.btngiaipt);
        btnthoat = findViewById(R.id.btnthoat);
        edita = findViewById(R.id.edita);
        editb = findViewById(R.id.editb);
        editc = findViewById(R.id.editc);
        txtketqua = findViewById(R.id.txtketqua);
        btngiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sa = edita.getText() + "";
                String sb = editb.getText() + "";
                String sc = editc.getText() + "";
                int a=Integer.parseInt(sa);
                int b=Integer.parseInt(sb);
                int c=Integer.parseInt(sc);
                String kq = "";
                DecimalFormat dcf = new DecimalFormat("0.00");
                if(a==0){
                    if(b==0){
                        if(c==0){
                            kq="PT vo so nghiem";
                        }
                        else kq="PT vo nghiem";
                    }
                    else kq="PT co 1 nghiem, x=" + dcf.format(-c/b);
                }
                else{
                    double delta = b*b-4*a*c;
                    if(delta<0){
                        kq="PT vo nghiem";
                    }
                    else if(delta==0){
                        kq="PT co nghiem kep x1=x2=" + dcf.format(-b/2*a);
                    }
                    else{
                        kq="PT co 2 nghiem: x1=" + dcf.format((-b+Math.sqrt(delta))/(2*a)) + "; x2=" + dcf.format((-b-Math.sqrt(delta))/(2*a));
                    }
                    txtketqua.setText(kq);
                }
            }
        });
        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edita.setText("");
                editb.setText("");
                editc.setText("");
                edita.requestFocus();
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}