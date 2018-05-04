package com.terralogic.mywallet.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.activity.ManageActivity;
import com.terralogic.mywallet.adapter.CategoryAdapter;
import com.terralogic.mywallet.database.MySQLite;
import com.terralogic.mywallet.model.Category;
import com.terralogic.mywallet.model.DateUtil;
import com.terralogic.mywallet.model.GroupItem;
import com.terralogic.mywallet.model.Item;
import com.terralogic.mywallet.model.ItemType;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by trile on 4/10/2018.
 */

public class AddNewFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private TextView mTxtTitle, mTxtAddIncome, mTxtAddExpense, mTxtAddMoney, mTxtUnit;
    private LinearLayout mLayoutIncome, mLayoutExpense;
    private ImageView mImgAddDate, mImgAddCate;
    private EditText mEditAddDate, mEditAddNote;
    private Spinner mSpinnerCate;
    private List<GroupItem> mListCate;
    private CategoryAdapter adapter;
    private boolean isIncome = true;
    private int day, month, year;
    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private Button btnOkay;
    private ImageButton btnDel;
    private String resultMoney = "0";
    private GroupItem itemSpinner;
    private MySQLite mySQLite;
    private Item item;

    @SuppressLint("ValidFragment")
    public AddNewFragment(Item item) {
        this.item = item;
    }

    public AddNewFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_add_new, container, false );
        mySQLite = new MySQLite( getContext() );

        initToolbar();

        initContent( view );
        initButtons( view );

        clickLayoutIncome();
        clickLayoutExpense();
        clickCalendarImage();

        initListCate();
        initSpinner();

        return view;
    }

    private void initSpinner() {
        adapter = new CategoryAdapter( getContext(), mListCate );
        mSpinnerCate.setAdapter( adapter );

        mSpinnerCate.setOnItemSelectedListener( this );
        if (item != null) {

            int position = mListCate.indexOf( getGroupItemById( item.getmIdGroup() ) );
            mSpinnerCate.setSelection( position );
        }
    }

    private GroupItem getGroupItemById(int id) {
        GroupItem result = null;
        List<GroupItem> groupItemList = mListCate;
        for (GroupItem groupItem : groupItemList) {
            if (groupItem.getcIdGroup() == id) {
                result = groupItem;
            }
        }
        return result;
    }

    private void initButtons(View view) {
        btnZero = view.findViewById( R.id.btnZero );
        btnZero.setOnClickListener( this );

        btnOne = view.findViewById( R.id.btnOne );
        btnOne.setOnClickListener( this );

        btnTwo = view.findViewById( R.id.btnTwo );
        btnTwo.setOnClickListener( this );

        btnThree = view.findViewById( R.id.btnThree );
        btnThree.setOnClickListener( this );

        btnFour = view.findViewById( R.id.btnFour );
        btnFour.setOnClickListener( this );

        btnFive = view.findViewById( R.id.btnFive );
        btnFive.setOnClickListener( this );

        btnSix = view.findViewById( R.id.btnSix );
        btnSix.setOnClickListener( this );

        btnSeven = view.findViewById( R.id.btnSeven );
        btnSeven.setOnClickListener( this );

        btnEight = view.findViewById( R.id.btnEight );
        btnEight.setOnClickListener( this );

        btnNine = view.findViewById( R.id.btnNine );
        btnNine.setOnClickListener( this );

        btnDel = view.findViewById( R.id.btnDelete );
        btnDel.setOnClickListener( this );

        btnOkay = view.findViewById( R.id.btnOk );
        btnOkay.setOnClickListener( this );
    }

    private void initContent(View view) {
        mLayoutIncome = view.findViewById( R.id.layoutIncome );
        mLayoutExpense = view.findViewById( R.id.layoutExpense );

        mTxtAddIncome = view.findViewById( R.id.txtAddIncome );
        mTxtAddExpense = view.findViewById( R.id.txtAddExpense );
        mTxtAddMoney = view.findViewById( R.id.txtAddMoney );
        mTxtUnit = view.findViewById( R.id.txtUnit );

        mImgAddDate = view.findViewById( R.id.imgAddDate );
        mImgAddCate = view.findViewById( R.id.imageAddCate );

        mEditAddDate = view.findViewById( R.id.editDate );
        mEditAddNote = view.findViewById( R.id.editNote );

        mSpinnerCate = view.findViewById( R.id.spinnerCate );

        if (item != null) {
            resultMoney = cutZero( item.getmMoney() );
            mTxtAddMoney.setText( String.format( "%,d", Integer.parseInt( resultMoney ) ) );
            mEditAddNote.setText( item.getmName() );
            mEditAddDate.setText( DateUtil.getDateStringFromDataObject( item.getmDate() ) );
            if (item.getmType() == ItemType.INCOME) {
                isIncome = true;
                mLayoutIncome.setBackgroundResource( R.drawable.background_income );
                mTxtAddIncome.setTextColor( Color.parseColor( "#FFFFFF" ) );
                mTxtAddMoney.setTextColor( Color.parseColor( "#40E0D0" ) );
                mTxtUnit.setTextColor( Color.parseColor( "#40E0D0" ) );
            } else {
                isIncome = false;
                mLayoutExpense.setBackgroundResource( R.drawable.background_expense );
                mTxtAddExpense.setTextColor( Color.parseColor( "#FFFFFF" ) );
                mTxtAddMoney.setTextColor( Color.parseColor( "#FF4081" ) );
                mTxtUnit.setTextColor( Color.parseColor( "#FF4081" ) );
            }
        } else {
            mLayoutIncome.setBackgroundResource( R.drawable.background_income );
            mTxtAddIncome.setTextColor( Color.parseColor( "#FFFFFF" ) );
            mTxtAddMoney.setTextColor( Color.parseColor( "#40E0D0" ) );
            mTxtUnit.setTextColor( Color.parseColor( "#40E0D0" ) );
        }
    }

    private String cutZero(String s) {
        StringBuilder builder = new StringBuilder( s );
        return builder.delete( s.length() - 3, s.length() ).toString();
    }

    private void initToolbar() {
        mTxtTitle = ((ManageActivity) getActivity()).findViewById( R.id.txtTitle );
        if (item != null) {
            mTxtTitle.setText( "Edit" );
        } else {
            mTxtTitle.setText( "Add New" );
        }
    }

    private void clickCalendarImage() {
        Calendar mCalendar = Calendar.getInstance();

        day = mCalendar.get( Calendar.DAY_OF_MONTH );
        month = mCalendar.get( Calendar.MONTH );
        year = mCalendar.get( Calendar.YEAR );


        mEditAddDate.setText( day + "-" + (month + 1) + "-" + year );

        mImgAddDate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog( getContext(), R.style.DatePicker, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        mEditAddDate.setText( day + "-" + (month + 1) + "-" + year );
                    }
                }, year, month, day );
//                datePickerDialog
                datePickerDialog.show();
            }
        } );
    }

    private void clickLayoutExpense() {
        mLayoutExpense.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation a = AnimationUtils.loadAnimation( getContext(), R.anim.anim_moveleft );
                isIncome = false;
                mLayoutExpense.setBackgroundResource( R.drawable.background_expense );
                mLayoutExpense.startAnimation( a );
                mLayoutIncome.setBackgroundResource( R.drawable.background_null );
                mTxtAddExpense.setTextColor( Color.parseColor( "#FFFFFF" ) );
                mTxtAddIncome.setTextColor( Color.parseColor( "#000000" ) );
                switchColorMoney();
            }
        } );
    }

    private void clickLayoutIncome() {
        mLayoutIncome.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation a = AnimationUtils.loadAnimation( getContext(), R.anim.anim_moveright );
                isIncome = true;
                mLayoutIncome.setBackgroundResource( R.drawable.background_income );
                mLayoutIncome.startAnimation( a );
                mLayoutExpense.setBackgroundResource( R.drawable.background_null );
                mTxtAddIncome.setTextColor( Color.parseColor( "#FFFFFF" ) );
                mTxtAddExpense.setTextColor( Color.parseColor( "#000000" ) );
                switchColorMoney();

            }
        } );
    }

    private void initListCate() {
        mListCate = mySQLite.getListCategory();

    }

    private void switchColorMoney() {
        if (isIncome) {
            mTxtAddMoney.setTextColor( Color.parseColor( "#40E0D0" ) );
            mTxtUnit.setTextColor( Color.parseColor( "#40E0D0" ) );
        }
        if (!isIncome) {
            mTxtAddMoney.setTextColor( Color.parseColor( "#FF4081" ) );
            mTxtUnit.setTextColor( Color.parseColor( "#FF4081" ) );
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public void onClick(View view) {
        if (view == btnOne) {
            limitResult( btnOne.getText().toString() );
        }
        if (view == btnTwo) {
            limitResult( btnTwo.getText().toString() );
        }
        if (view == btnThree) {
            limitResult( btnThree.getText().toString() );
        }
        if (view == btnFour) {
            limitResult( btnFour.getText().toString() );
        }
        if (view == btnFive) {
            limitResult( btnFive.getText().toString() );
        }
        if (view == btnSix) {
            limitResult( btnSix.getText().toString() );
        }
        if (view == btnSeven) {
            limitResult( btnSeven.getText().toString() );
        }
        if (view == btnEight) {
            limitResult( btnEight.getText().toString() );
        }
        if (view == btnNine) {
            limitResult( btnNine.getText().toString() );
        }
        if (view == btnZero) {
            limitResult( btnZero.getText().toString() );
        }
        if (view == btnDel) {
            deleteNumber();
        }
        if (view == btnOkay) {
            if (mEditAddNote.getText().toString() == null || mEditAddNote.getText().toString().length() == 0) {
                Toast.makeText( getContext(), "Please enter the note!", Toast.LENGTH_SHORT ).show();
            } else {
                if (item != null) {
                    editItemToDatabase();
                } else {
                    addItemToDatabase();
                }
                clear();
            }
        }
    }

    private void editItemToDatabase() {
        item.setmName( mEditAddNote.getText().toString() );
        item.setmMoney( resultMoney + "000" );
        item.setmType( isIncome ? ItemType.INCOME : ItemType.CONSUM );
        item.setmDate( DateUtil.getDateFromString( mEditAddDate.getText().toString() ) );
        item.setmIdGroup( itemSpinner.getcIdGroup() );

        mySQLite.updateItem( item );
        clear();
    }

    private void clear() {
        mEditAddNote.setText( "" );
        resultMoney = "0";
        mTxtAddMoney.setText( resultMoney );
        Toast.makeText( getContext(), "Saved!", Toast.LENGTH_SHORT ).show();
    }

    private void addItemToDatabase() {
        List itemList = mySQLite.getListItem();
        int countLastItem = 0;
        if (itemList != null && itemList.size() > 0) {
            countLastItem = ((Item) itemList.get( itemList.size() - 1 )).getmIdItem() + 1;
        }
        Item item = new Item();
        item.setmIdItem( countLastItem );
        item.setmDate( DateUtil.getDateFromString( mEditAddDate.getText().toString() ) );
        item.setmIdGroup( itemSpinner.getcIdGroup() );
        item.setmType( isIncome ? ItemType.INCOME : ItemType.CONSUM );
        item.setmMoney( resultMoney + "000" );
        item.setmName( mEditAddNote.getText().toString() );
        mySQLite.addItem( item );
    }

    private void limitResult(String num) {
        if (resultMoney.length() > 9) {
            mTxtAddMoney.setText( String.format( "%,d", Integer.parseInt( resultMoney ) ) );
        } else {
            resultMoney += num;
            mTxtAddMoney.setText( String.format( "%,d", Integer.parseInt( resultMoney ) ) );
        }
    }

    private void deleteNumber() {
        if (resultMoney.length() <= 1) {
            mTxtAddMoney.setText( "0" );
        } else {
            StringBuilder builder = new StringBuilder( resultMoney );
            builder.deleteCharAt( resultMoney.length() - 1 );
            resultMoney = builder.toString();
            mTxtAddMoney.setText( String.format( "%,d", Integer.parseInt( resultMoney ) ) );
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        itemSpinner = (GroupItem) adapterView.getItemAtPosition( position );
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
