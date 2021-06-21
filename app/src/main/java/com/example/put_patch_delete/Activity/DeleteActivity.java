package com.example.put_patch_delete.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.put_patch_delete.API.JsonPlaceHolderApi;
import com.example.put_patch_delete.Model.Post;
import com.example.put_patch_delete.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeleteActivity extends AppCompatActivity {
    TextView tvResutlDelete ;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        tvResutlDelete= findViewById(R.id.tvResultDelete);
        btnBack = findViewById(R.id.btnBackDelete);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        DeletePost();
    }

    private void DeletePost() {
        JsonPlaceHolderApi.apiService.deletePost(5).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                tvResutlDelete.setText("Code: " + response.code());
                Toast.makeText(getApplicationContext(), "DELETE SUCCESS" , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                tvResutlDelete.setText(t.getMessage());
            }
        });
    }
}