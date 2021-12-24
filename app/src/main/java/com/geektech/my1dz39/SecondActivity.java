package com.geektech.my1dz39;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SecondActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText editText,editText2;
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.editPhoto);
        editText = findViewById(R.id.editUsername);
        editText2 = findViewById(R.id.editPassword);

       String username = getIntent().getStringExtra("key");
       String password = getIntent().getStringExtra("key2");
       editText.setText(username);
       editText2.setText(password);

       ActivityResultLauncher<String>resultLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
                   @Override
                   public void onActivityResult(Uri result) {
                       Glide.with(SecondActivity.this).load(result).circleCrop().into(imageView);
                   }
               }
       );

        ActivityResultLauncher<Intent> resultLauncherForCamera = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Glide.with(SecondActivity.this).load(result).circleCrop().into(imageView);
            }
        });

       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              AlertDialog.Builder alert =new AlertDialog.Builder(SecondActivity.this);
              alert.setPositiveButton("Выбрать из галереи", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      resultLauncher.launch("image/*");
                  }
              }).setNegativeButton("Выбрать камеру", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      resultLauncherForCamera.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));

                  }
              }).show();
           }
       });

    }
}