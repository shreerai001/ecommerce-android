package com.shree.ecom.activityMain.view.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shree.ecom.Main2Activity;
import com.shree.ecom.R;
import com.shree.ecom.categories.model.dto.CategoryDto;
import com.shree.ecom.categories.model.dto.Datum;

import java.util.List;

public class NavMenuExpandableAdapter extends BaseExpandableListAdapter {
    private Context context;
private List<Datum> subCategoryList;
    public NavMenuExpandableAdapter(Context main2Activity) {
        this.context = main2Activity;

    }

    @Override
    public int getGroupCount() {
        if (subCategoryList == null) {
            return 0;
        } else
            return subCategoryList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (subCategoryList == null) {
            return 0;
        } else if (subCategoryList.get(groupPosition).getSubCategory() == null) {
            return 0;
        } else return subCategoryList.get(groupPosition).getSubCategory().size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int grouprotateUpPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater groupInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = groupInflater.inflate(R.layout.side_nav_expandable_title, null);
        }
        TextView textView = convertView.findViewById(R.id.title_text);
        textView.setText(subCategoryList.get(groupPosition).getName());
        if (isExpanded) {
            textView.setTextColor(parent.getResources().getColor(R.color.colorPrimaryDark));
        } else
            textView.setTextColor(context.getResources().getColor(R.color.black));
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater childInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = childInflater.inflate(R.layout.side_nav_expandable_sub, null);
        }
        TypedValue outValue = new TypedValue();
        TextView textView = convertView.findViewById(R.id.subCategories);
        textView.setText(subCategoryList.get(groupPosition).getSubCategory().get(childPosition).getName());
        final LinearLayout linearLayout = convertView.findViewById(R.id.linearLayout);
        final int size = subCategoryList.get(groupPosition).getSubCategory().get(childPosition).getSubCategory().size();
        linearLayout.removeAllViews();
        if (size != 0) {
            linearLayout.removeAllViews();
            for (int i = 0; i < subCategoryList.get(groupPosition).getSubCategory().get(childPosition).getSubCategory().size(); i++) {
                final TextView valueTV = new TextView(context);
                valueTV.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                valueTV.setText(subCategoryList.get(groupPosition).getSubCategory().get(childPosition).getSubCategory().get(i).getName());
                valueTV.setId(subCategoryList.get(groupPosition).getSubCategory().get(childPosition).getSubCategory().get(i).getId());
                valueTV.setBackgroundColor(context.getResources().getColor(R.color.white));
                valueTV.setPadding(30, 30, 30, 30);
                valueTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12.0F);
                valueTV.setTextColor(context.getResources().getColor(R.color.black));
                context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
                valueTV.setBackgroundResource(outValue.resourceId);
                valueTV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (context instanceof Main2Activity) {
                            ((Main2Activity) context).closeDrawer();
                        }
                        Toast.makeText(context, "" + valueTV.getId(), Toast.LENGTH_SHORT).show();
                    }
                });
                linearLayout.addView(valueTV);
            }
            linearLayout.setVisibility(View.VISIBLE);
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (size == 0) {
                    Toast.makeText(context, "Intent Required", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(context, CategoriesActivity.class);
//                    int id = categoryList.get(groupPosition).getSubCategory().get(childPosition).getId();
//                    intent.putExtra("catid", id);
//                    context.startActivity(intent);
                }
//                else {
//                    if (linearLayout.getVisibility() == View.VISIBLE)
//                        linearLayout.setVisibility(View.GONE);
//                    else
//                        linearLayout.setVisibility(View.VISIBLE);
//
//                }
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public void setValues(List<Datum> datum) {
        this.subCategoryList = datum;
        notifyDataSetChanged();
    }
}
