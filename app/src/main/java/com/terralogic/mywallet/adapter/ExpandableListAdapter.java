package com.terralogic.mywallet.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.adapter.viewHolder.CatgoryViewHolder;
import com.terralogic.mywallet.adapter.viewHolder.ChildViewHolder;
import com.terralogic.mywallet.model.DateUtil;
import com.terralogic.mywallet.model.GroupItem;
import com.terralogic.mywallet.model.Item;
import com.terralogic.mywallet.model.ItemType;

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


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.mcontext.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE );
            convertView = inflater.inflate( R.layout.list_group, null );


        }


        GroupItem groupItem = mlistDataGroup.get( groupPosition );
        CatgoryViewHolder catgoryViewHolder = new CatgoryViewHolder( convertView );
        catgoryViewHolder.setDataForGroup( groupItem );


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean
            isLastChild, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.mcontext.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE );
            convertView = inflater.inflate( R.layout.list_item, null );

        }


        Item item = mlistDataItem.get( mlistDataGroup.get(
                groupPosition ) ).get( childPosition );
        ChildViewHolder childViewHolder = new ChildViewHolder( convertView );
        childViewHolder.setDataForItem( item );


        return convertView;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
