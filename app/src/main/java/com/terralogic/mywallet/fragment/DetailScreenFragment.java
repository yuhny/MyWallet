package com.terralogic.mywallet.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.activity.ManageActivity;
import com.terralogic.mywallet.database.MySQLite;
import com.terralogic.mywallet.model.Category;
import com.terralogic.mywallet.model.GroupItem;
import com.terralogic.mywallet.model.Item;
import com.terralogic.mywallet.model.ItemType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class DetailScreenFragment extends Fragment {
    Spinner spinner;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<GroupItem> listDataGroup;
    HashMap<GroupItem, List<Item>> listDataItem;
    HashMap<Integer, List<Item>> listId;
    private Toolbar mToolbar;
    private TextView mTitle;

   // @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_detail_screen, container,
                false );


        mToolbar = ((ManageActivity) getActivity()).findViewById( R.id.toolbar );
        mTitle = ((ManageActivity) getActivity()).findViewById( R.id.txtTitle );
////        mTitle.setText( "Detail for month" );


        spinner = view.findViewById( R.id.spinner_month );
        final ArrayList<String> arrayMonth = new ArrayList<>();
        arrayMonth.add( "January" );
        arrayMonth.add( "February" );
        arrayMonth.add( "March" );
        arrayMonth.add( "April" );
        arrayMonth.add( "May" );
        arrayMonth.add( "June" );
        arrayMonth.add( "July" );
        arrayMonth.add( "August" );
        arrayMonth.add( "September" );
        arrayMonth.add( "October" );
        arrayMonth.add( "November" );
        arrayMonth.add( "December " );

        final ArrayAdapter arrayAdapter = new ArrayAdapter( this.getContext(),
                android.R.layout.simple_spinner_item, arrayMonth );
        arrayAdapter.setDropDownViewResource( R.layout.support_simple_spinner_dropdown_item );
        spinner.setAdapter( arrayAdapter );
        spinner.setOnItemSelectedListener(onItemSelectedListener());


        expListView = view.findViewById( R.id.expandableListView );

        prepareListData();
        return view;
    }

    private AdapterView.OnItemSelectedListener onItemSelectedListener(){
       return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                prepareListData();
                //listAdapter.notify();
                listAdapter = new com.terralogic.mywallet.adapter.ExpandableListAdapter(
                        view.getContext(), listDataGroup, listDataItem );

                expListView.setAdapter( listAdapter );
                int itemCount = expListView.getCount();
                for (int j = 0; j < itemCount; j++) {
                    expListView.expandGroup( j );
                }
                mTitle.setText( "Detail for "+spinner.getSelectedItem() );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }

    private void prepareListData() {
        listDataGroup = new ArrayList<>();
        listDataItem = new HashMap<GroupItem, List<Item>>();
        MySQLite sqLite = new MySQLite( this.getContext() );
        List<GroupItem> listDataGroupTemp = sqLite.getListCategory();

        List<Item> itemList = sqLite.getListItem();

        for (GroupItem gi : listDataGroupTemp) {
            ArrayList<Item> listItem = new ArrayList<>();
            long money = 0;

            for (Item item : itemList) {
                if (item.getmIdGroup() == gi.getcIdGroup() ) {
                    if(spinner.getSelectedItemPosition() == item.getmDate().getMonth()) {
                        listItem.add( item );
                        if (item.getmType() == ItemType.INCOME) {
                            money += Long.parseLong( item.getmMoney() );
                        } else {
                            money -= Long.parseLong( item.getmMoney() );
                        }
                    }
                }
            }

            if (listItem.size() > 0) {
                listDataItem.put( gi, listItem );
                gi.setcMoney( money+"" );
                listDataGroup.add( gi );
            }

        }

//            for (GroupItem gi : listDataGroup) {
//                ArrayList<Item> list = new ArrayList<>();
//                listId.put( gi.getcIdGroup(), list );
//
//                }
//
//                for(Item item : itemList)
//                {
//                    ArrayList<Item> list = (ArrayList<Item>) listId.get( item.getmIdGroup() );
//                    list.add( item );
//                    listId.put( item.getmIdGroup(),list );
//                }
//
//                for(GroupItem gr:listDataGroup)
//                {
//                    List<Item> list1 = listId.get( gr.getcIdGroup() );
//                    listDataItem.put( gr,list1 );
//                }


    }

    private void handleMoneyCategory() {
        MySQLite sqLite1 = new MySQLite( this.getContext() );
        List<Item> itemList = sqLite1.getListItem();
        List<GroupItem> listDataGroup = sqLite1.getListCategory();


        for (GroupItem gritem : listDataGroup) {

        }
    }


}
