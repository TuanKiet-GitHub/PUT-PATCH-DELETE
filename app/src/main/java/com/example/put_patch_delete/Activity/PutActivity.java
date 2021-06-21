package com.example.put_patch_delete.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.put_patch_delete.API.JsonPlaceHolderApi;
import com.example.put_patch_delete.Model.Post;
import com.example.put_patch_delete.R;

import retrofit2.Callback;
import retrofit2.Response;

public class PutActivity extends AppCompatActivity {
    TextView tvResultPut ;
    Button btnPut ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put);
        updatePost();
        tvResultPut = findViewById(R.id.tvResultPut);
        btnPut = findViewById(R.id.btnBackPut);
        btnPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void updatePost()
    {
        Post post = new Post(3, "Tuan Kiet 1", "Nguyen Tuan Kiet" );

        JsonPlaceHolderApi.apiService.putPost(4,post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(retrofit2.Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    tvResultPut.setText("Code: " + response.code());
                    return;
                }
                Post postResponese = response.body();
                    String content = "";
                    content += "Code: " + response.code() + "\n";
                    content += "ID: " + postResponese.getId() + "\n";
                    content += "User ID: " + postResponese.getUserId() + "\n";
                    content += "Title: " + postResponese.getTitle() + "\n";
                    content += "Text: " + postResponese.getText() + "\n\n";
                   tvResultPut.setText(content);
                Toast.makeText(getApplicationContext(), "PUT SUCCESS" , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(retrofit2.Call<Post> call, Throwable t) {
                     tvResultPut.setText(t.getMessage());
            }
        });

    }
}