package com.example.moviestreamingtcn.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviestreamingtcn.MovieDetails;
import com.example.moviestreamingtcn.R;
import com.example.moviestreamingtcn.model.CategoryItem;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder> {
    Context context;
    List<CategoryItem> categoryItemList;

    public ItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.cat_recycler_row_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {
        //here we will fetch image from server so we use glide library
        Glide.with(context).load(categoryItemList.get(position).getImageUrl()).into(holder.itemImage);

        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, ""+ categoryItemList.get(position).getMovieName(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, MovieDetails.class);
                i.putExtra("movieId",categoryItemList.get(position).getId());
                i.putExtra("movieIName",categoryItemList.get(position).getMovieName());
                i.putExtra("movieImageUrl",categoryItemList.get(position).getImageUrl());
                i.putExtra("movieFile",categoryItemList.get(position).getFileUrl());
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static final class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
        }
    }
}
