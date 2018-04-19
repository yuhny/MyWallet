package com.terralogic.mywallet.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.model.Category;

import java.util.List;

/**
 * Created by trile on 4/16/2018.
 */

public class CategoryAdapter extends ArrayAdapter<Category> {

    public CategoryAdapter(Context context, List<Category> categories) {
        super(context, 0, categories);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.item_cate, parent, false);
        }
        ImageView imgCate = (ImageView) convertView.findViewById(R.id.imgDialogCate);
        TextView txtCate = (TextView) convertView.findViewById(R.id.txtDialogCate);

        Category category = getItem(position);
        imgCate.setImageDrawable(getContext().getResources().getDrawable(category.getImageCate()));
        txtCate.setText(category.getNameCate());

        return convertView;
    }
    //    public CategoryAdapter(Context context, List<Category> categories) {
//        this.context = context;
//        this.categories = categories;
//    }
//
//    @Override
//    public int getCount() {
//        return categories.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return categories.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//
//        return null;
//    }

//    @Override
//    public ItemDialogHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.dialog_category, null);
//        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
//
//        ItemDialogHolder holder = new ItemDialogHolder(view);
//
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(ItemDialogHolder holder, int position) {
//        Category category = categories.get(position);
//
//        holder.getImgCate().setImageDrawable(context.getResources().getDrawable(category.getImageCate()));
//        holder.getTxtCate().setText(category.getNameCate());
//    }
//
//    @Override
//    public int getItemCount() {
//        return categories.size();
//    }
}
