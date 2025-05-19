package com.example.ex5_1;

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

public class MainActivity extends AppCompatActivity {

    TextView txtView1, txtView2, txtView3, txtView4;
    EditText editText;
    Button btn;
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
        txtView1 = findViewById(R.id.textView1);
        txtView2 = findViewById(R.id.textView2);
        txtView3 = findViewById(R.id.textView3);
        txtView4 = findViewById(R.id.textView4);
        editText = findViewById(R.id.editnamduonglich);
        btn = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer namduong;
                String can, chi, namam;
                namduong = Integer.parseInt(editText.getText() + "");
                switch (namduong%10){
                    case 0:
                        can = "Canh"; break;
                    case 1:
                        can = "Tân"; break;
                    case 2:
                        can = "Nhâm"; break;
                    case 3:
                        can = "Quý"; break;
                    case 4:
                        can = "Giáp"; break;
                    case 5:
                        can = "Ất"; break;
                    case 6:
                        can = "Bính"; break;
                    case 7:
                        can = "Đính"; break;
                    case 8:
                        can = "Mậu"; break;
                    default:
                        can = "Kỳ"; break;
                }
                switch (namduong%12){
                    case 0:
                        chi = "Thân"; break;
                    case 1:
                        chi = "Dậu"; break;
                    case 2:
                        chi = "Tuât"; break;
                    case 3:
                        chi = "Hơi"; break;
                    case 4:
                        chi = "Tý"; break;
                    case 5:
                        chi = "Sưu"; break;
                    case 6:
                        chi = "Dần"; break;
                    case 7:
                        chi = "Mẹo"; break;
                    case 8:
                        chi = "Thìn"; break;
                    case 9:
                        chi = "Tỵ"; break;
                    case 10:
                        chi = "Ngọ"; break;
                    default:
                        chi = "Mùi"; break;
                }
                namam = can + " " + chi;
                txtView4.setText(namam);
            }
        });
    }
}