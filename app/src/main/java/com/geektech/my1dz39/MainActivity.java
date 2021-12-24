package com.geektech.my1dz39;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText editText,editText2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id._image);
        editText = findViewById(R.id.ed_username);
        editText2 = findViewById(R.id.ed_password);
        button = findViewById(R.id.button_send);
        Glide.with(this).load("https://encrypted-tbn0.gstatic." +
                "com/images?q=tbn:ANd9GcRIBwO3OL2BZuyaVukHIM0nzBry_awjPRuNUQ&usqp=CAU").into(imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().length() < 6 ){
                    Toast.makeText(MainActivity.this, "Имя пользователя не может быть меньше 6 символов", Toast.LENGTH_SHORT).show();
                }else if (editText2.getText().toString().length() < 6){
                    Toast.makeText(MainActivity.this, "Пароль должен состоят из 6 символов", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("key",editText.getText().toString());
                    intent.putExtra("key2",editText2.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}