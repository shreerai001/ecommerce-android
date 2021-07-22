package com.shree.ecom.activityFilter.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import com.shree.ecom.R;
import com.shree.ecom.activityFilter.model.dto.FilterDto;
import com.shree.ecom.activityFilter.view.adapter.MyAdapter;
import com.shree.ecom.activityFilter.view.adapter.SpinnerAdapter;

import java.util.ArrayList;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        Spinner spinner = findViewById(R.id.spinner_brand);
        Spinner categorySpinner = findViewById(R.id.spinner_category);
        Spinner sortSpinner = findViewById(R.id.spinner_sortBy);
        final String[] select_qualification = {
                "Brand ", "JCB", "TaTa", "Atlas"};
        ArrayList<FilterDto> listVOs = new ArrayList<>();

        for (int i = 0; i < select_qualification.length; i++) {
            FilterDto stateVO = new FilterDto();
            stateVO.setTitle(select_qualification[i]);
            stateVO.setSelected(false);
            listVOs.add(stateVO);
        }
        MyAdapter myAdapter = new MyAdapter(FilterActivity.this, 0,
                listVOs);
        SpinnerAdapter spinnerAdapter=new SpinnerAdapter(FilterActivity.this,0,listVOs);
        spinner.setAdapter(myAdapter);
//        categorySpinner.setAdapter(spinnerAdapter);
//        sortSpinner.setAdapter(myAdapter);

    }
}
