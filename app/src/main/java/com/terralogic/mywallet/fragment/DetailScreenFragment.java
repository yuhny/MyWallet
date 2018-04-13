package com.terralogic.mywallet.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.model.GroupItem;
import com.terralogic.mywallet.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetailScreenFragment extends Fragment {
    Spinner spinner;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<GroupItem> listDataGroup;
    HashMap<GroupItem, List<Item>> listDataItem;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_detail_screen, container, false );

        spinner =view.findViewById( R.id.spinner_month );
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
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText( getContext(), spinner.getSelectedItem().toString(),
                        Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );


        expListView = view.findViewById(R.id.expandableListView);

        prepareListData();

        listAdapter = new com.terralogic.mywallet.adapter.ExpandableListAdapter(
                this.getActivity(), listDataGroup,listDataItem );

        expListView.setAdapter( listAdapter );
        int itemCount = expListView.getCount();
        for(int i = 0; i< itemCount; i++) {
            expListView.expandGroup(i);
        }

        return view;
    }
        private void prepareListData()
        {
            listDataGroup = new ArrayList<>(  );
            listDataItem = new HashMap<GroupItem, List<Item>>();
            listDataGroup.add( new GroupItem( R.mipmap.ic_launcher,"baby","2000000 vnd"
                     ) );
            listDataGroup.add(new GroupItem( R.mipmap.ic_launcher,"supermarket",
                    "100000 " +
                    "vnd" ) );

            List<Item> baby = new ArrayList<>(  );
            baby.add( new Item("buy milk","22/12/2018","318000 vnd" ));
            List<Item> supermarket = new ArrayList<>(  );
            supermarket.add(new Item(   "buy fish","22/12/2018","30000 vnd" ));

            listDataItem.put(listDataGroup.get(0),baby);
            listDataItem.put( listDataGroup.get( 1 ), supermarket );


        }



}
