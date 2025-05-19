package com.example.ex7_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    EditText editAA, editBB;
    Button btnsendtong, btnsendhieu;
    Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editAA = findViewById(R.id.editTextTextA);
        editBB = findViewById(R.id.editTextTextB);
        btnsendtong = findViewById(R.id.button2);
        btnsendhieu = findViewById(R.id.button3);
        myintent = getIntent();
        int a = myintent.getIntExtra("soa", 0);
        int b = myintent.getIntExtra("sob", 0);
        editAA.setText(a+"");
        editBB.setText(b+"");
        btnsendtong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = a+b;
                myintent.putExtra("kq", sum);
                setResult(33, myintent);
                finish();
            }
        });
        btnsendhieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sub = a-b;
                myintent.putExtra("kq", sub);
                setResult(34, myintent);
                finish();
            }
        });
    }
}