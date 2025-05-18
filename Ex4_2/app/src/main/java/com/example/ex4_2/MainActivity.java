package com.example.ex4_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btnchandoan;
    EditText editTen, editchieucao,editcannang, editBMI, editchandoan;
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
        btnchandoan = findViewById(R.id.btnBMI);
        editTen = findViewById(R.id.edtten);
        editcannang = findViewById(R.id.edtcannang);
        editchieucao = findViewById(R.id.edtchieucao);
        editBMI = findViewById(R.id.edtBMI);
        editchandoan = findViewById(R.id.edtChandoan);
        btnchandoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double H = Double.parseDouble(editchieucao.getText() + "");
                double W = Double.parseDouble(editcannang.getText() + "");
                double BMI = W/Math.pow(H, 2);
                String chandoan = "";
                if(BMI<18){
                    chandoan = "Bạn gay";
                }
                else if(BMI<=24.9){
                    chandoan = "Bạn bình thờng";
                }
                else if(BMI<=29.9){
                    chandoan = "Ban beo phi do 1";
                }
                else if(BMI<=34.9){
                    chandoan = "Ban beo phi do 2";
                }
                else{
                    chandoan = "Ban beo phi do 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                editBMI.setText(dcf.format(BMI));
                editchandoan.setText(chandoan);
            }
        });
    }
}