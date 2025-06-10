package com.example.ex13_2_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String[] arrayName = {"Anh 1", "Anh 2", "Anh 3", "Anh 4", "Anh 5", "Anh 6", "Anh 7", "Anh 8", "Anh 9", "Anh 10", "Anh 11", "Anh 12"};
    public static int[] imageName = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10, R.drawable.img11, R.drawable.img12};
    GridView gridView;
    MyarrayAdapter adapterDanhsach;
    ArrayList<Image> arrimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.gridView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gridView = (GridView) findViewById(R.id.gridView);
        arrimage = new ArrayList<Image>();
        adapterDanhsach = new MyarrayAdapter(MainActivity.this, R.layout.listitem, arrimage);
        gridView.setAdapter(adapterDanhsach);
        for (int i=0; i<imageName.length; i++){
            Image myimage = new Image();
            myimage.setName(arrayName[i]);
            myimage.setImg(imageName[i]);
            arrimage.add(myimage);
            adapterDanhsach.notifyDataSetChanged();
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent1 = new Intent(MainActivity.this, SubActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("TITLE", position);
                    intent1.putExtras(bundle);
                    startActivity(intent1);
                }
            });
        }
    }
}