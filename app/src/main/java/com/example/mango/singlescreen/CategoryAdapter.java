package com.example.mango.singlescreen;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    List<Integer[]> categoryList;
    Context cn;
    public CategoryAdapter(List<Integer[]> catList, Context context)
    {
        this.categoryList = catList;
        cn = context;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_category, parent, false);

        return new CategoryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {
        Integer[] category = categoryList.get(position);
        holder.categoryTxt.setText(cn.getString(category[0]));
        holder.categoryImg.setImageResource(category[1]);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public  class  CategoryHolder extends  RecyclerView.ViewHolder{

        public ImageView categoryImg;
        public TextView categoryTxt;
        public CategoryHolder(View itemView) {
            super(itemView);
            categoryTxt = (TextView) itemView.findViewById(R.id.categoryTxt);
            categoryImg = (ImageView) itemView.findViewById(R.id.categoryImg);
        }
    }
}
