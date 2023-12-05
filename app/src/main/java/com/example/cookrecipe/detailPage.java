package com.example.cookrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class detailPage extends AppCompatActivity {

    TextView nameRecipe, ingredients, carbs, proteins, fats, sugars ;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        image = findViewById(R.id.imageDetail);
        nameRecipe = findViewById(R.id.RecipeName);
        ingredients = findViewById(R.id.ingredients);
        carbs = findViewById(R.id.carbs);
        proteins = findViewById(R.id.proteins);
        fats = findViewById(R.id.fats);
        sugars = findViewById(R.id.sugars);

        Intent intent = getIntent();
        if(intent != null){
            int imageResource = intent.getIntExtra("image", 0);
            String recipeName = intent.getStringExtra("nameRecipe");
            String recipeIngredients = intent.getStringExtra("ingredients");
            int carbsValue = intent.getIntExtra("carbs", 0);
            int proteinsValue = intent.getIntExtra("proteins", 0);
            int fatsValue = intent.getIntExtra("fats", 0);
            int sugarsValue = intent.getIntExtra("sugars", 0);

            nameRecipe.setText(recipeName);
            ingredients.setText(recipeIngredients);
            image.setImageResource(imageResource);
            carbs.setText(String.valueOf(carbsValue));
            proteins.setText(String.valueOf(proteinsValue));
            fats.setText(String.valueOf(fatsValue));
            sugars.setText(String.valueOf(sugarsValue));
        }

    }

    public void arrowBack(View view) {
        Intent intent = new Intent(this, homePage.class);
        startActivity(intent);
    }
}
