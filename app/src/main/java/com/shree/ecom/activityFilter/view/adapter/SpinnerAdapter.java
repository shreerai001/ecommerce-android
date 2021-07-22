package com.shree.ecom.activityFilter.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.shree.ecom.R;
import com.shree.ecom.activityFilter.model.dto.FilterDto;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<FilterDto> {
    private Context mContext;
    private ArrayList<FilterDto> listState;
    private SpinnerAdapter myAdapter;

    public SpinnerAdapter(Context context, int resource, List<FilterDto> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.listState = (ArrayList<FilterDto>) objects;
        this.myAdapter = this;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(final int position, View convertView,
                              ViewGroup parent) {

        final SpinnerAdapter.ViewHolder holder;
        if (convertView == null) {
            LayoutInflater layoutInflator = LayoutInflater.from(mContext);
            convertView = layoutInflator.inflate(R.layout.spinner_item, null);
            holder = new SpinnerAdapter.ViewHolder();
            holder.mTextView = (TextView) convertView
                    .findViewById(R.id.text);
            convertView.setTag(holder);
        } else {
            holder = (SpinnerAdapter.ViewHolder) convertView.getTag();
        }

        holder.mTextView.setText(listState.get(position).getTitle());

        return convertView;
    }

    class ViewHolder {
        private TextView mTextView;
    }


}
