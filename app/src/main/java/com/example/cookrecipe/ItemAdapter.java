package com.example.cookrecipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private final ArrayList<ItemData> values;
    private Context context;
    private LayoutInflater inflater;
    public ItemAdapter(Context context,ArrayList<ItemData>values){
        this.context=context;
        this.values=values;
        this.inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.list_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemData data = values.get(position);
        Glide.with(holder.itemView.getContext()).load(data.itemImage).into(holder.imageRecipe);
        holder.nameRecipeText.setText(data.itemLabel);
        holder.caloriesText.setText(data.itemCalories);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getAdapterPosition();
                if (clickedPosition != RecyclerView.NO_POSITION) {
                    ItemData clickedItem = values.get(clickedPosition);
                    Intent intent = new Intent(context, detailPage.class);
                    intent.putExtra("ITEM_DATA", clickedItem);
                    context.startActivity(intent);
                }
            }
        });
    }


    @Override
    public int getItemCount() { return values.size();}


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageRecipe;
        TextView nameRecipeText;
        TextView caloriesText;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imageRecipe=itemView.findViewById(R.id.image);
            nameRecipeText=itemView.findViewById(R.id.nameRecipe);
            caloriesText=itemView.findViewById(R.id.totalCalories);
        }
    }
}