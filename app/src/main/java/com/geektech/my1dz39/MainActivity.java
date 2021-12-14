package com.geektech.my1dz39;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id._image);
        Glide.with(this).load("https://encrypted-tbn0.gstatic." +
                "com/images?q=tbn:ANd9GcRIBwO3OL2BZuyaVukHIM0nzBry_awjPRuNUQ&usqp=CAU").into(imageView);
        Log.d("Ololo", "onCreate: Rojdaemsay");
    }
}