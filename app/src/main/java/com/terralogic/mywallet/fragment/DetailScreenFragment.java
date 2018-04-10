package com.terralogic.mywallet.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.terralogic.mywallet.R;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class DetailScreenFragment extends Fragment {
    Spinner spinner;

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

        final ArrayAdapter arrayAdapter = new ArrayAdapter( this.getContext(), android.R.layout.simple_spinner_item, arrayMonth );
        arrayAdapter.setDropDownViewResource( R.layout.support_simple_spinner_dropdown_item );
            spinner.setAdapter( arrayAdapter );
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText( getContext(), spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );


            FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        FragmentListview fragmentListview = new FragmentListview();
        transaction.add( R.id.frameContent2, fragmentListview);

        transaction.commit();


        return view;
    }
}
