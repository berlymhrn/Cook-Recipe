package com.example.cookrecipe;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class homePage extends AppCompatActivity {
    BottomNavigationView navigation;
    String nameRecipe, ingredients;
    int carbs, proteins, fats, sugars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                return true;
            } else if (item.getItemId() == R.id.nav_search) {
                startActivity(new Intent(getApplicationContext(), searchPage.class));
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                finish();
                return true;
            }
            return false;
        });
    }

    public void goToDetail(String nameRecipe, String ingredients, int resourceImage, int carbs, int proteins, int fats, int sugars) {
        Intent intent = new Intent(this, detailPage.class);
        intent.putExtra("nameRecipe", nameRecipe);
        intent.putExtra("ingredients", ingredients);
        intent.putExtra("image", resourceImage);
        intent.putExtra("carbs", carbs);
        intent.putExtra("proteins", proteins);
        intent.putExtra("fats", fats);
        intent.putExtra("sugars", sugars);

        startActivity(intent);
    }

    public void vegetarianSalad(View view) {
        nameRecipe = "Vegetarian Salad";
        ingredients = "1. Lettuce\n" + "2. Tomatoes\n" + "3. Cucumbers\n" + "4. Bell peppers\n" + "5. Carrots\n" + "6. Red onions\n" + "7. Olives";
        carbs = 200;
        proteins = 300;
        fats = 2;
        sugars = 10;

        goToDetail(nameRecipe, ingredients, R.drawable.salad, carbs, proteins, fats, sugars);
    }


    public void smoothies(View view) {
        String nameRecipe = "Raspberry Smoothies";
        String ingredients = "1. Raspberries\n" + "2. Yogurt\n" + "3. Milk\n" + "4. Honey (optional)\n" + "5. Ice cubes";
        carbs = 38;
        proteins = 15;
        fats = 7;
        sugars = 29;

        goToDetail(nameRecipe, ingredients, R.drawable.smoothies, carbs, proteins, fats, sugars);
    }

    public void mac(View view) {
        String nameRecipe = "Mac And Cheese";
        String ingredients = "1. Elbow macaroni\n" + "2. Butter\n" + "3. All-purpose flour\n" + "4. Milk\n" + "5. Cheddar cheese\n" + "6. Salt\n" + "7. Black pepper\n" + "8. Optional toppings (breadcrumbs, parsley, etc.)";
        carbs = 157;
        proteins = 50;
        fats = 117;
        sugars = 6;

        goToDetail(nameRecipe, ingredients, R.drawable.mac_cheese, carbs, proteins, fats, sugars);
    }

    public void rawon(View view) {
        String nameRecipe = "Rawon";
        String ingredients = "1. Beef (preferably shank or chuck)\n" + "2. Kluwek (black nuts)\n" + "3. Lemongrass\n" + "4. Galangal\n" + "5. Bay leaves\n" + "6. Kaffir lime leaves\n" + "7. Tamarind\n" + "8. Shallots\n" + "9. Garlic\n" + "10. Candlenuts\n" + "11. Salt\n" + "12. Palm sugar\n" + "13. Cooking oil\n" + "14. Water\n" + "15. Bean sprouts (optional)\n" + "16. Sambal (chili paste) for serving";
        carbs = 20;
        proteins = 50;
        fats = 3;
        sugars = 5;

        goToDetail(nameRecipe, ingredients, R.drawable.rawon, carbs, proteins, fats, sugars);
    }

    public void chicken(View view) {
        String nameRecipe = "Crispy Chili Chicken";
        String ingredients = "1. Chicken pieces\n2. All-purpose flour\n3. Cornstarch\n4. Baking powder\n5. Salt\n6. Pepper\n7. Eggs\n8. Chili sauce\n9. Soy sauce\n10. Garlic\n11. Sugar\n12. Vinegar\n13. Green onions\n14. Sesame seeds\n15. Oil for frying";
        carbs = 40;
        proteins = 30;
        fats = 20;
        sugars = 5;

        goToDetail(nameRecipe, ingredients, R.drawable.chicken, carbs, proteins, fats, sugars);
    }

    public void aglio(View view) {
        String nameRecipe = "Spaghetti Aglio Olio";
        String ingredients = "1. Spaghetti\n2. Olive oil\n3. Garlic\n4. Red pepper flakes\n5. Parsley\n6. Salt\n7. Parmesan cheese";
        carbs = 40;
        proteins = 10;
        fats = 15;
        sugars = 2;

        goToDetail(nameRecipe, ingredients, R.drawable.aglio, carbs, proteins, fats, sugars);
    }

    public void pasta(View view) {
        String nameRecipe = "Creamy Pasta";
        String ingredients = "1. Pasta\n2. Heavy cream\n3. Butter\n4. Parmesan cheese\n5. Garlic\n6. Salt\n7. Black pepper\n8. Italian seasoning";
        carbs = 50;
        proteins = 15;
        fats = 25;
        sugars = 5;

        goToDetail(nameRecipe, ingredients, R.drawable.pasta, carbs, proteins, fats, sugars);
    }

    public void veganPizza(View view) {
        String nameRecipe = "Vegan Pizza";
        String ingredients = "1. Pizza dough\n2. Tomato sauce\n3. Vegan cheese\n4. Bell peppers\n5. Red onions\n6. Mushrooms\n7. Olives\n8. Spinach";
        carbs = 30;
        proteins = 10;
        fats = 15;
        sugars = 2;

        goToDetail(nameRecipe, ingredients, R.drawable.vegan_pizza, carbs, proteins, fats, sugars);
    }

    public void cabbageWrap(View view) {
        String nameRecipe = "Cabbage Wrap";
        String ingredients = "1. Cabbage leaves\n2. Quinoa\n3. Bell peppers\n4. Carrots\n5. Red onions\n6. Tomatoes\n7. Hummus\n8. Avocado";
        carbs = 15;
        proteins = 5;
        fats = 3;
        sugars = 5;

        goToDetail(nameRecipe, ingredients, R.drawable.cabbage_wrap, carbs, proteins, fats, sugars);
    }

    public void kimbab(View view) {
        String nameRecipe = "Kimbab";
        String ingredients = "1. Sushi rice\n2. Seaweed sheets\n3. Carrots\n4. Cucumber\n5. Pickled radish\n6. Crab sticks\n7. Eggs\n8. Spinach";
        carbs = 30;
        proteins = 5;
        fats = 7;
        sugars = 2;

        goToDetail(nameRecipe, ingredients, R.drawable.kimbab, carbs, proteins, fats, sugars);
    }

}
