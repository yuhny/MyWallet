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
import com.terralogic.mywallet.model.GroupItem;

import java.util.List;

/**
 * Created by trile on 4/16/2018.
 */

public class CategoryAdapter extends ArrayAdapter<GroupItem> {
    private List<GroupItem> categories;

    public CategoryAdapter(Context context, List<GroupItem> categories) {
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

        GroupItem category = getItem(position);
        imgCate.setImageDrawable(getContext().getResources().getDrawable(category.getcImage()));
        txtCate.setText(category.getcName());

        return convertView;
    }

    public List<GroupItem> getCategories() {
        return categories;
    }

}
