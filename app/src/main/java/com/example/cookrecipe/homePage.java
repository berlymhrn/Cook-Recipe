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
        ingredients = "1 large ripe Ataulfo mango, peeled and roughly chopped (about 1 cup)\n1 cup plain unsweetened kefir\n1 cup frozen blackberries (4 1/2 ounces)";
        carbs = 200;
        proteins = 300;
        fats = 2;
        sugars = 10;

        goToDetail(nameRecipe, ingredients, R.drawable.salad, carbs, proteins, fats, sugars);
    }



    public void smoothies(View view) {
        nameRecipe = "Raspberry Smoothies";
        ingredients = "Frozen raspberries: 1 cup\nBanana: 1\nGreek yogurt: 1/2 cup\nHoney: 1 tablespoon\nAlmond milk: 1 cup\nIce cubes: 1 cup";
        carbs = 30;
        proteins = 5;
        fats = 3;
        sugars = 20;

        goToDetail(nameRecipe, ingredients, R.drawable.smoothies, carbs, proteins, fats, sugars);
    }

    public void mac(View view) {
        nameRecipe = "Mac and Cheese";
        ingredients = "8 ounces elbow macaroni\n2 cups shredded sharp Cheddar cheese\n1/2 cup grated Parmesan cheese\n3 cups milk\n1/4 cup butter\n2 1/2 tablespoons all-purpose flour\n2 tablespoons butter\n1/2 cup bread crumbs\n1 pinch paprika";
        carbs = 200;
        proteins = 100;
        fats = 150;
        sugars = 30;

        goToDetail(nameRecipe, ingredients, R.drawable.mac_cheese, carbs, proteins, fats, sugars);
    }

    public void rawon(View view) {
        nameRecipe = "Rawon";
        ingredients = "500g beef (cut into bite-sized pieces)\n1 liter water\n3 kaffir lime leaves\n2 lemongrass (crushed)\n2 bay leaves\n3 salam leaves\n5 candlenuts\n3 cloves garlic\n6 shallots\n1 inch galangal\n1 inch ginger\n2 tablespoons oil\n1 teaspoon salt\n1 teaspoon sugar\n2 tablespoons tamarind juice\n2 tablespoons Indonesian sweet soy sauce\nHard-boiled eggs\ncucumber\nfried shallots (for garnish)";
        carbs = 200;
        proteins = 250;
        fats = 100;
        sugars = 20;

        goToDetail(nameRecipe, ingredients, R.drawable.rawon, carbs, proteins, fats, sugars);
    }

    public void chicken(View view) {
        String nameRecipe = "Crispy Chili Chicken";
        ingredients = "Boneless chicken thighs: 4 pieces\nCornstarch: 1/2 cup\nEgg: 1\nSalt: 1/2 teaspoon\nBlack pepper: 1/4 teaspoon\nChili flakes: 1 tablespoon\nSoy sauce: 2 tablespoons\nHoney: 2 tablespoons\nSesame oil: 1 teaspoon\nCanola oil: for frying";
        carbs = 12;
        proteins = 25;
        fats = 15;
        sugars = 6;

        goToDetail(nameRecipe, ingredients, R.drawable.chicken, carbs, proteins, fats, sugars);
    }

    public void aglio(View view) {
        String nameRecipe = "Spaghetti Aglio Olio";
        ingredients = "Spaghetti: 8 ounces\nGarlic (thinly sliced): 4 cloves\nRed pepper flakes: 1/2 teaspoon\nExtra-virgin olive oil: 1/3 cup\nFresh parsley (chopped): 1/4 cup\nSalt: to taste\nBlack pepper: to taste\nGrated Parmesan cheese: for garnish (optional)";
        carbs = 50;
        proteins = 8;
        fats = 15;
        sugars = 3;

        goToDetail(nameRecipe, ingredients, R.drawable.aglio, carbs, proteins, fats, sugars);
    }

    public void pasta(View view) {
        nameRecipe = "Creamy Pasta";
        ingredients = "Pasta: 8 ounces\nHeavy cream: 1 cup\nButter: 2 tablespoons\nGarlic (minced): 2 cloves\nParmesan cheese (grated): 1/2 cup\nSalt: to taste\nPepper: to taste\nFresh parsley (chopped): 2 tablespoons";
        carbs = 60;
        proteins = 12;
        fats = 25;
        sugars = 3;

        goToDetail(nameRecipe, ingredients, R.drawable.pasta, carbs, proteins, fats, sugars);
    }

    public void veganPizza(View view) {
        String nameRecipe = "Vegan Pizza";
        ingredients = "Pizza dough: 1 ball\nMarinara sauce: 1 cup\nVegan cheese: 1 1/2 cups\nBell peppers (sliced): 1 cup\nRed onions (sliced): 1/2 cup\nMushrooms (sliced): 1 cup\nSpinach: 1 cup\nCherry tomatoes (halved): 1/2 cup\nOlive oil: 2 tablespoons\nSalt: to taste\nPepper: to taste\nItalian seasoning: 1 teaspoon";
        carbs = 40;
        proteins = 8;
        fats = 15;
        sugars = 5;

        goToDetail(nameRecipe, ingredients, R.drawable.vegan_pizza, carbs, proteins, fats, sugars);
    }

    public void cabbageWrap(View view) {
        String nameRecipe = "Cabbage Wrap";
        ingredients = "4-6 large cabbage leaves\n1 cup cooked quinoa\n1 cup black beans (cooked)\n1/2 cup corn\n1/2 red bell pepper (diced)\n2 green onions (chopped)\n1 avocado (sliced)\nJuice of 1 lime\n2 tablespoons chopped cilantro\nSalt to taste\nPepper to taste\n1 teaspoon cumin\n1 teaspoon chili powder\n1/2 teaspoon garlic powder";
        carbs = 30;
        proteins = 12;
        fats = 8;
        sugars = 4;

        goToDetail(nameRecipe, ingredients, R.drawable.cabbage_wrap, carbs, proteins, fats, sugars);
    }

    public void kimbab(View view) {
        String nameRecipe = "Kimbab";
        ingredients = "4 cups cooked sushi rice\n5 sheets seaweed (nori)\n1 medium carrot (julienned)\n1 cucumber (julienned)\n1 cup spinach (blanched and squeezed)\n5 imitation crab sticks\n5 strips yellow pickled radish\n5 eggs (made into thin omelettes)\nSesame oil\nSalt\nSesame seeds";
        carbs = 45;
        proteins = 10;
        fats = 5;
        sugars = 2;

        goToDetail(nameRecipe, ingredients, R.drawable.kimbab, carbs, proteins, fats, sugars);
    }

}
