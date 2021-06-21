package com.example.put_patch_delete;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.put_patch_delete.Activity.DeleteActivity;
import com.example.put_patch_delete.Activity.GetActivity;
import com.example.put_patch_delete.Activity.PatchActivity;
import com.example.put_patch_delete.Activity.PutActivity;
import com.example.put_patch_delete.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this , R.layout.activity_main);
        binding.btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , GetActivity.class);
                startActivity(intent);
            }
        });
        binding.btnPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , PutActivity.class);
                startActivity(intent);
            }
        });
        binding.btnPatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , PatchActivity.class);
                startActivity(intent);
            }
        });
        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , DeleteActivity.class);
                startActivity(intent);
            }
        });
    }
}