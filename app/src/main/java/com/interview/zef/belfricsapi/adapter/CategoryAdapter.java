package com.interview.zef.belfricsapi.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.interview.zef.belfricsapi.R;
import com.interview.zef.belfricsapi.model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zef on 28/12/17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context mContext;
    private List<Category> categoryList = new ArrayList<>();

    public CategoryAdapter(Context mContext, List<Category> categoryList) {
        this.mContext = mContext;
        this.categoryList = categoryList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.title.setText(category.getCategoryName());
        String image = category.getImageUrl();

        Glide.with(mContext)
                .load(image)
                .into(holder.image);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        ImageView image;

        public MyViewHolder(View view) {

            super(view);
            title = view.findViewById(R.id.title);
            image = view.findViewById(R.id.image);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                    }
                }
            });
        }
    }
}
