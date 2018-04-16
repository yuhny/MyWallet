package com.terralogic.mywallet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.fragment.DetailScreenFragment;
import com.terralogic.mywallet.model.GroupItem;
import com.terralogic.mywallet.model.Item;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context mcontext;
    private List<GroupItem> mlistDataGroup;
    private HashMap<GroupItem, List<Item>> mlistDataItem;


    public ExpandableListAdapter(Context context, List<GroupItem> listDataGroup,
                                 HashMap<GroupItem, List<Item>> listDataItem) {
        this.mcontext = context;
        this.mlistDataGroup = listDataGroup;
        this.mlistDataItem = listDataItem;
    }

    @Override
    public int getGroupCount() {
        return this.mlistDataGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.mlistDataItem.get( this.mlistDataGroup.get( groupPosition ) ).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.mlistDataGroup.get( groupPosition );
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return this.mlistDataItem.get( this.mlistDataGroup.get( groupPosition ) ).get(
                childPosition );
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup viewGroup) {
//        String groupTitle = (String) getGroup( groupPosition );
//        int groupImage = (Integer) getGroup( groupPosition );
//        String groupMoney = (String) getGroup( groupPosition );

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.mcontext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView = inflater.inflate( R.layout.list_group, null );


        }

        ImageView imGroup = (ImageView) convertView.findViewById( R.id.imgGroup );
        TextView grTextView1 = (TextView) convertView.findViewById( R.id.textNameGroup );
        TextView grTextView2 = (TextView) convertView.findViewById( R.id.textMoney );

//        imGroup.setImageResource( groupImage );
//        grTextView1.setText( groupTitle );
//        grTextView2.setText( groupMoney );
        GroupItem groupItem = mlistDataGroup.get( groupPosition );

        imGroup.setImageResource( groupItem.getcImage() );
        grTextView1.setText( groupItem.getcName() );
        grTextView2.setText( groupItem.getcMoney() );


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.mcontext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView = inflater.inflate( R.layout.list_item, null );

        }

        TextView textViewNameChild = (TextView) convertView.findViewById( R.id.textNameItem );
        TextView textViewDateChild = (TextView) convertView.findViewById( R.id.textDate );
        TextView textViewMoneyChild = (TextView) convertView.findViewById( R.id.textMoneyItem );


        Item item = mlistDataItem.get( mlistDataGroup.get( groupPosition ) ).get( childPosition );
        textViewNameChild.setText( item.getmName() );
        textViewDateChild.setText( item.getmDate() );
        textViewMoneyChild.setText(item.getmMoneyConsume());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
