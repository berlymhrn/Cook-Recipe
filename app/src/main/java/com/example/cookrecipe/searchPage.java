package com.example.cookrecipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.cookrecipe.FetchRecipe;
import com.example.cookrecipe.ItemAdapter;
import com.example.cookrecipe.ItemData;
import com.example.cookrecipe.R;

import java.util.ArrayList;

public class searchPage extends AppCompatActivity {
    private EditText searchBar;
    private Button buttonSearch;
    private RecyclerView recyclerView;
    private ArrayList<ItemData> values;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        searchBar = findViewById(R.id.search);
        buttonSearch = findViewById(R.id.button_search);
        recyclerView = findViewById(R.id.result_recycler_view);
        values = new ArrayList<>();
        itemAdapter = new ItemAdapter(this, values);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);


        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchRecipe();
            }
        });

        searchBar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    searchRecipe();
                    return true;
                }
                return false;
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_search);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_search) {
                return true;
            } else if (item.getItemId() == R.id.nav_home) {
                startActivity(new Intent(getApplicationContext(), homePage.class));
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                finish();
                return true;
            }
            return false;
        });
    }

    private void searchRecipe() {
        String queryString = searchBar.getText().toString();
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Toast.makeText(this,"Loading, Please Wait a Moment", Toast.LENGTH_LONG).show();
            new FetchRecipe(this, values, itemAdapter, recyclerView).execute(queryString);
        } else {
            Toast.makeText(this, "Please Check Your Connection.",
                    Toast.LENGTH_LONG).show();
        }
    }

    }
