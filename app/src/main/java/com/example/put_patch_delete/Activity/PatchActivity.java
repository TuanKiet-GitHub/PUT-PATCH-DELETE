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

import retrofit2.Callback;
import retrofit2.Response;

public class PatchActivity extends AppCompatActivity {
    TextView tvResutlPatch ;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patch);
        tvResutlPatch= findViewById(R.id.tvResultPatch);
        btnBack = findViewById(R.id.btnBackPatch);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        updatePost();

    }
    private void updatePost()
    {
        Post post = new Post(4, "Tuan Kiet 2", "Nguyen Tuan Kiet" );
        JsonPlaceHolderApi.apiService.patchPost(4,post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(retrofit2.Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    tvResutlPatch.setText("Code: " + response.code());
                    return;
                }
                Post postResponese = response.body();
                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponese.getId() + "\n";
                content += "User ID: " + postResponese.getUserId() + "\n";
                content += "Title: " + postResponese.getTitle() + "\n";
                content += "Text: " + postResponese.getText() + "\n\n";
                Log.e("LOG", content);
                tvResutlPatch.setText(content);
                Toast.makeText(getApplicationContext(), "PATCH SUCCESS" , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(retrofit2.Call<Post> call, Throwable t) {
                tvResutlPatch.setText(t.getMessage());
            }
        });

    }
}