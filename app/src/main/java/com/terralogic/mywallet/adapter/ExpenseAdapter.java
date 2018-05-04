package com.terralogic.mywallet.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.adapter.viewHolder.ItemViewHolder;
import com.terralogic.mywallet.database.MySQLite;
import com.terralogic.mywallet.fragment.AddNewFragment;
import com.terralogic.mywallet.model.DateUtil;
import com.terralogic.mywallet.model.GroupItem;
import com.terralogic.mywallet.model.Item;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;
    private List<Item> itemList;
    private MySQLite mySQLite;


    public ExpenseAdapter(Context context, List<Item> expenseList) {
        this.context = context;
        this.itemList = expenseList;
        mySQLite = new MySQLite(context);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.item_expense, null);
        v.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        ItemViewHolder viewHolder = new ItemViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        final Item item = itemList.get(position);

        final Animation animOpenOutside = AnimationUtils.loadAnimation(context, R.anim.anim_moveleft_outside);
        final Animation animCloseOutside = AnimationUtils.loadAnimation(context, R.anim.anim_moveright_outside);

        NumberFormat format = new DecimalFormat("#,###");

        holder.getmContextExpense().setText(limit(item.getmName(), 10));
        holder.getmDateCreate().setText(DateUtil.getDateStringFromDataObject(item.getmDate()));
        holder.getmMoney().setText(format.format(Long.parseLong(item.getmMoney())) + " VNĐ");

        holder.getmImageCate().setImageDrawable(context.getResources().getDrawable(getImageCate(item.getmIdGroup())));
        if (item.getmType().getValues() == 0) {
            holder.getmMoney().setTextColor(Color.parseColor("#40E0D0"));
        } else {
            holder.getmMoney().setTextColor(Color.parseColor("#FF4081"));
        }
        holder.getmCardView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                final int widthOutside = holder.getmOutside().getWidth();
                holder.getmInside().startAnimation(animOpenOutside);
                holder.getmOutside().startAnimation(animOpenOutside);

                new CountDownTimer(3000, 1000) {
                    @Override
                    public void onTick(long l) {

                        holder.getmInside().setTranslationX(-widthOutside);
                        holder.getmOutside().setTranslationX(-widthOutside);

                    }

                    @Override
                    public void onFinish() {
                        holder.getmInside().setTranslationX(0);
                        holder.getmOutside().setTranslationX(0);
                        holder.getmInside().startAnimation(animCloseOutside);
                        holder.getmOutside().startAnimation(animCloseOutside);
                    }
                }.start();

                holder.getmImgEdit().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addFragmentBackStack(new AddNewFragment(item));
                    }
                });
                holder.getmImgDelete().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemList.remove(item);
                        mySQLite.deleteItem(item);
                        notifyDataSetChanged();
                    }
                });
                return true;
            }
        });
    }

    private int getImageCate(int idGroup) {
        List<GroupItem> groupItems = mySQLite.getListCategory();
        int result = 0;
        for (GroupItem groupItem : groupItems) {
            if (groupItem.getcIdGroup() == idGroup) {
                result = groupItem.getcImage();
            }
        }
        return result;
    }

    private void addFragmentBackStack(Fragment fragment) {
        FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.setCustomAnimations(R.anim.anim_in_right, R.anim.anim_out_left, R.anim.anim_in_left, R.anim.anim_to_right);
        transaction.replace(R.id.frameManage, fragment);
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commit();
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String limit(String value, int length) {
        StringBuilder buf = new StringBuilder(value);
        if (buf.length() > length) {
            buf.setLength(length);
            buf.append("...");
        }
        return buf.toString();
    }
}
