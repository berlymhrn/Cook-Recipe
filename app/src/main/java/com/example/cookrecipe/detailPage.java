package com.example.cookrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cookrecipe.ItemData;
import com.example.cookrecipe.R;
import com.example.cookrecipe.homePage;

public class detailPage extends AppCompatActivity {

    TextView nameRecipe, ingredients, carbs, proteins, fats, sugars;
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
        ingredients = findViewById(R.id.ingredients);

        Intent intent = getIntent();
        if (intent != null) {
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

        if (intent != null && intent.hasExtra("ITEM_DATA")) {
            ItemData itemData = intent.getParcelableExtra("ITEM_DATA");

            nameRecipe.setText(itemData.itemLabel);
            Glide.with(this).load(itemData.itemImage).into(image);
            String itemIngredients = intent.getStringExtra("ITEM_INGREDIENTS");
            if (itemIngredients != null) {
                ingredients.setText(itemIngredients);
            }

            int fat = 0;
            if (intent.hasExtra("ITEM_FAT")) {
                fat = Integer.parseInt(intent.getStringExtra("ITEM_FAT"));
            }
            fats.setText(String.valueOf(fat));

            int sugar = 0;
            if (intent.hasExtra("ITEM_SUGARS")) {
                sugar = Integer.parseInt(intent.getStringExtra("ITEM_SUGARS"));
            }
            sugars.setText(String.valueOf(sugar));

            int protein = 0;
            if (intent.hasExtra("ITEM_PROTEINS")) {
                protein = Integer.parseInt(intent.getStringExtra("ITEM_PROTEINS"));
            }
            proteins.setText(String.valueOf(protein));
        }

        int carb = 0;
        if (intent.hasExtra("ITEM_CARBS")) {
            carb = Integer.parseInt(intent.getStringExtra("ITEM_CARBS"));
        }
        carbs.setText(String.valueOf(carb));
    }

    public void arrowBack(View view) {
        Intent intent = new Intent(this, homePage.class);
        startActivity(intent);
    }
}
