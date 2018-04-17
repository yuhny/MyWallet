package com.terralogic.mywallet.fragment.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.adapter.CategoryAdapter;
import com.terralogic.mywallet.model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trile on 4/16/2018.
 */

public class CategoryDialog extends Dialog {
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_category);

        categories = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.listCate);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        categories.add(new Category(R.drawable.icon_smile, "Cinema"));
        categories.add(new Category(R.drawable.icon_smile, "Baby"));
        categories.add(new Category(R.drawable.icon_smile, "Home"));
        categories.add(new Category(R.drawable.icon_smile, "Market"));
        categories.add(new Category(R.drawable.icon_smile, "Restaurant"));
        categories.add(new Category(R.drawable.icon_smile, "Travel"));
        categories.add(new Category(R.drawable.icon_smile, "Others"));

        adapter = new CategoryAdapter(getContext(), categories);

        recyclerView.setAdapter(adapter);
    }

    public CategoryDialog(@NonNull Context context) {
        super(context);
    }
}
