package com.shree.ecom.contacts.activityPolicy.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shree.ecom.R;
import com.shree.ecom.contacts.activityPolicy.model.dto.PolicyEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shree on 16,May,2019
 */
public class PolicyAdapter extends RecyclerView.Adapter<PolicyAdapter.ViewHolder> {

    private List<PolicyEntity> policyEntityList;
    private Context context_dco;

    public PolicyAdapter(List<PolicyEntity> policyEntityList, Context context_dco) {
        this.policyEntityList = policyEntityList;
        this.context_dco = context_dco;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_policies, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.buyerDetail_v.setText(policyEntityList.get(i).getData().getBuyer_condition());
        viewHolder.privacyDetail_v.setText(policyEntityList.get(i).getData().getPrivacy_policy());
        Log.i("Site", "" + policyEntityList.get(i).getData().getSite_condition());
        viewHolder.sellerDetail_v.setText(policyEntityList.get(i).getData().getSeller_condition());
        viewHolder.siteDetail_v.setText(policyEntityList.get(i).getData().getSite_condition());
    }

    @Override
    public int getItemCount() {
        return policyEntityList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.privacy_detail)
        TextView privacyDetail_v;

        @BindView(R.id.seller_detail)
        TextView sellerDetail_v;

        @BindView(R.id.buyer_detail)
        TextView buyerDetail_v;

        @BindView(R.id.site_detail)
        TextView siteDetail_v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
