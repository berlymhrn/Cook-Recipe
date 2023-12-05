package com.example.cookrecipe;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FetchRecipe extends AsyncTask<String, Void, ArrayList<ItemData>> {
    private ArrayList<ItemData> values;
    private ItemAdapter itemAdapter;
    private RecyclerView recyclerView;
    private Context context;

    public FetchRecipe(Context context, ArrayList<ItemData> values,
                       ItemAdapter itemAdapter, RecyclerView recyclerView) {
        this.values = values;
        this.itemAdapter = itemAdapter;
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @Override
    protected ArrayList<ItemData> doInBackground(String... strings) {
        ArrayList<ItemData> fetchedData = new ArrayList<>();
        String queryString = strings[0];
        BufferedReader reader = null;
        String recipeJSONString = "";
        String EDAMAM_RECIPE_URL = "https://api.edamam.com/api/recipes/v2";
        String EDAMAM_QUERY_PARAM = "q";
        String EDAMAM_TYPE = "public";
        String EDAMAM_APP_ID = "0566f9fa";
        String EDAMAM_APP_KEY = "6d229c4a172c69d1df305f04ef2dbb88";
        String EDAMAM_IMAGE_SIZE = "THUMBNAIL";

        HttpURLConnection urlConnection = null;
        Uri builtUri = Uri.parse(EDAMAM_RECIPE_URL).buildUpon()
                .appendQueryParameter(EDAMAM_QUERY_PARAM, queryString)
                .appendQueryParameter("type", EDAMAM_TYPE)
                .appendQueryParameter("app_id", EDAMAM_APP_ID)
                .appendQueryParameter("app_key", EDAMAM_APP_KEY)
                .appendQueryParameter("imageSize", EDAMAM_IMAGE_SIZE)
                .build();

        URL requestURL = null;
        try {
            requestURL = new URL(builtUri.toString());
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder builder = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            if (builder.length() == 0) {
                return null;
            }
            recipeJSONString = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (recipeJSONString != null) {
            try {
                JSONObject jsonObject = new JSONObject(recipeJSONString);
                JSONArray hitsArray = jsonObject.getJSONArray("hits");
                for (int i = 0; i < hitsArray.length(); i++) {
                    JSONObject hit = hitsArray.getJSONObject(i);
                    JSONObject recipe = hit.getJSONObject("recipe");
                    String label = recipe.getString("label");
                    String image = recipe.optString("image", "");
                    String caloriesStr = recipe.optString("calories", "");

                    int caloriesInt = 0;
                    if (!caloriesStr.isEmpty()) {
                        float caloriesFloat = Float.parseFloat(caloriesStr);
                        caloriesInt = (int) caloriesFloat;
                    }

                    ItemData itemData = new ItemData(image, label, String.valueOf(caloriesInt));
                    itemData.itemImage = image;
                    itemData.itemLabel = label;
                    itemData.itemCalories = String.valueOf(caloriesInt);
                    fetchedData.add(itemData);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return fetchedData;
    }

    @Override
    protected void onPostExecute(ArrayList<ItemData> fetchedData) {
        super.onPostExecute(fetchedData);
        if (fetchedData != null && !fetchedData.isEmpty()) {
            this.values.clear();
            this.values.addAll(fetchedData);
            this.itemAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(context, "We Don`t Have Any Result 😖", Toast.LENGTH_LONG).show();
        }
    }
}