package ru.rt.navigator.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.rt.navigator.R;
import ru.rt.navigator.presenter.NavigatorPresenter;
import ru.rt.navigator.view.adapters.NavigatorAdapter;
import ru.rt.navigator.view.adapters.NavigatorAdapterEvent;
import ru.rt.navigator.view.dto.EventDto;
import ru.rt.navigator.view.dto.ProgramDto;

import static ru.rt.navigator.R.id.checkBox;

public class MainActivity extends AppCompatActivity implements ViewNavigator {

    @BindView(R.id.spinnerTerritory) Spinner spinnerTerritory;
    @BindView(R.id.spinnerAge) Spinner spinnerAge;
    @BindView(R.id.spinnerAge1) Spinner spinnerAge1;
    @BindView(checkBox) CheckBox checkBoxTeh;
    @BindView(R.id.checkBox1) CheckBox checkBoxHud;
    @BindView(R.id.checkBox2) CheckBox checkBoxEst;
    @BindView(R.id.checkBox3) CheckBox checkBoxSpt;
    @BindView(R.id.checkBox4) CheckBox checkBoxGra;
    @BindView(R.id.checkBox5) CheckBox checkBoxSoc;
    @BindView(R.id.checkBox6) CheckBox checkBoxTur;
    @BindView(R.id.checkBox9)  CheckBox checkBox9;
    @BindView(R.id.checkBox10) CheckBox checkBox10;
    @BindView(R.id.checkBox11) CheckBox checkBox11;
    @BindView(R.id.radioGroup) RadioGroup realis1;
    @BindView(R.id.radioGroup1) RadioGroup realis2;
    @BindView(R.id.searchText) TextView searchText;
    @BindView(R.id.rv) RecyclerView recyclerView;
    @BindView(R.id.spinnerForm) Spinner spinnerForm;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.imageMenu) AppCompatImageView appCompatImageView;
    @BindView(R.id.frame) FrameLayout frameLayout;
    @BindView(R.id.textViewMenu) TextView textViewMenu;
    @BindView(R.id.textViewMenuNoResult) TextView textViewMenuNoResult;

    NavigatorPresenter navigatorPresenter;
    RequestBody requestBody;
    LinearLayout llBottomSheet;
    String realizationForm;
    String paidForm;
    List<String> childCategory;
    int minAge;
    int maxAge;
    boolean isTech;
    boolean isArtisticallyAesthetic;
    boolean isNatural;
    boolean isSport;
    boolean isCivilPatriotic;
    boolean isSocio;
    boolean isTouristic;
    NavigatorAdapter navigatorAdapter;
    NavigatorAdapterEvent navigatorAdapterEvent;
    List<EventDto> listEvent;
    List<ProgramDto> listProgram;
    ArrayAdapter<String>  arrayAdapterAge2;
    BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(MainActivity.this);

        navigatorPresenter = new NavigatorPresenter(this, spinnerTerritory.getSelectedItemId());
        childCategory = new ArrayList<>();
        llBottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        int heightPixels = getWindowManager().getDefaultDisplay().getHeight();
        int px = (int) convertDpToPixel(130, this);
        llBottomSheet.getLayoutParams().height = heightPixels - px;

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    //appCompatImageView.setImageResource(R.mipmap.ic_keyboard_arrow_down_white_24dp);
                     }

                if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    //appCompatImageView.setImageResource(R.mipmap.ic_keyboard_arrow_up_white_24dp);
                    //getFormElements();
                    //addRequestBody();
                    //navigatorPresenter.setSpinnerForm(spinnerForm.getSelectedItemId());
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    //navigatorPresenter.requestGetListNavigator(requestBody);
                    //recyclerView.setVisibility(View.INVISIBLE);
                    //textViewMenu.setVisibility(View.VISIBLE);
                }
            }
        });

        bottomSheetBehavior.setHideable(false);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    appCompatImageView.setImageResource(R.mipmap.ic_keyboard_arrow_up_white_24dp);
                    textViewMenuNoResult.setVisibility(View.INVISIBLE);
                    getFormElements();
                    addRequestBody();
                    //showError(String.valueOf(spinnerForm.getSelectedItemId()));
                    navigatorPresenter.setSpinnerForm(spinnerForm.getSelectedItemId());
                    navigatorPresenter.requestGetListNavigator(requestBody);
                }

                if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    appCompatImageView.setImageResource(R.mipmap.ic_keyboard_arrow_down_white_24dp);
                    recyclerView.setVisibility(View.INVISIBLE);
                    textViewMenuNoResult.setVisibility(View.INVISIBLE);
                    hideDialog();
                    //textViewMenu.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                int a = (int) Math.round((slideOffset * 100)* 2.5);

                textViewMenu.setTextColor(Color.argb( a , 117, 117, 117));

                textViewMenuNoResult.setTextColor(Color.argb( 250 - a , 117, 117, 117));


            }
        });


/*
        List<ProgramDto> list = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        navigatorAdapter = new NavigatorAdapter(list);

        recyclerView.setAdapter(navigatorAdapter);
*/

        listEvent = new ArrayList<>();
        listProgram = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.getItemAnimator().setAddDuration(5000);
        recyclerView.getItemAnimator().setRemoveDuration(5000);
        recyclerView.getItemAnimator().setMoveDuration(5000);
        recyclerView.getItemAnimator().setChangeDuration(5000);

        navigatorAdapter = new NavigatorAdapter(listProgram,this);
        navigatorAdapterEvent = new NavigatorAdapterEvent(listEvent, this);

        List<String> arrayAge2 = new ArrayList<>();
        for (int i = 5; i <= 17; i++) {
            arrayAge2.add(String.valueOf(i));
        }

        arrayAdapterAge2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayAge2);

        spinnerAge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                arrayAdapterAge2.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinnerAge1.setAdapter(arrayAdapterAge2);
                arrayAdapterAge2.clear();
                for (int i = 17; i >=(5+position) ; i--) {
                    arrayAdapterAge2.add(String.valueOf(i));
                }
                arrayAdapterAge2.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public void showPrograms(List<ProgramDto> programDtos) {
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(navigatorAdapter);
            navigatorAdapter.add(0, programDtos);

    }

    @Override
    public void showEvents(List<EventDto> eventDtos) {
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(navigatorAdapterEvent);
            navigatorAdapterEvent.add(0, eventDtos);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Override
    public void showNoResult() {
            textViewMenuNoResult.setVisibility(View.VISIBLE);
    }

    @Override
    public void showDialog() {
        if (progressBar != null && !progressBar.isShown()) {
            recyclerView.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            //textViewMenu.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void hideDialog() {
        if (progressBar != null && progressBar.isShown()) {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }


    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    private void getFormElements() {

        switch (realis1.indexOfChild(findViewById(realis1.getCheckedRadioButtonId()))) {
            case 0: realizationForm = "FULL_TIME";
                break;
            case 1: realizationForm = "EXTRAMURAL";
                break;
            case 2: realizationForm = "ANY";
                break;
            default: realizationForm = "ANY";
                break;
        }

        switch (realis2.indexOfChild(findViewById(realis2.getCheckedRadioButtonId()))) {
            case 0: paidForm = "FREE_OF_CHARGE";
                break;
            case 1: paidForm = "PAID";
                break;
            case 2: paidForm = "ANY";
                break;
            default: paidForm = "ANY";
                break;
        }

        if(!childCategory.isEmpty())
            childCategory.clear();

        if(checkBox9.isChecked()){
            childCategory.add("isForLimitedHealth");}
        if(checkBox10.isChecked()){
            childCategory.add("isForDisabled");}
        if(checkBox11.isChecked()){
            childCategory.add("isForUnlimitedHealth");}

        minAge = Integer.valueOf(spinnerAge.getSelectedItem().toString());
        maxAge = Integer.valueOf(spinnerAge1.getSelectedItem().toString());

        isTech =checkBoxTeh.isChecked();
        isArtisticallyAesthetic = checkBoxHud.isChecked();
        isNatural = checkBoxEst.isChecked();
        isSport =checkBoxSpt.isChecked();
        isCivilPatriotic = checkBoxGra.isChecked();
        isSocio = checkBoxSoc.isChecked();
        isTouristic =checkBoxTur.isChecked();
    }

    private void addRequestBody() {
        requestBody = new RequestBody((spinnerTerritory.getSelectedItemId()+1),
                realizationForm,
                paidForm,
                childCategory,
                minAge,
                maxAge,
                isTech,
                isArtisticallyAesthetic,
                isNatural,
                isSport,
                isCivilPatriotic,
                isSocio,
                isTouristic
        );
    }
}
