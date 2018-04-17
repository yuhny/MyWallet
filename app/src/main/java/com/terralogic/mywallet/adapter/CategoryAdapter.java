package com.terralogic.mywallet.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.adapter.viewHolder.ItemDialogHolder;
import com.terralogic.mywallet.model.Category;

import java.util.List;

/**
 * Created by trile on 4/16/2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<ItemDialogHolder> {
    private Context context;
    private List<Category> categories;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public ItemDialogHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_category, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        ItemDialogHolder holder = new ItemDialogHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ItemDialogHolder holder, int position) {
        Category category = categories.get(position);

        holder.getImgCate().setImageDrawable(context.getResources().getDrawable(category.getImageCate()));
        holder.getTxtCate().setText(category.getNameCate());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
