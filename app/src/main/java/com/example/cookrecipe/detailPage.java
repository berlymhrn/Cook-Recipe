package com.example.cookrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class detailPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
    }

    public void arrowBack(View view) {
        Intent intent = new Intent(this, homePage.class);
        startActivity(intent);
    }
}