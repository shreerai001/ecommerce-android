package com.shree.ecom.reviews.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shree.ecom.R;
import com.shree.ecom.reviews.contract.ReviewsContract;
import com.shree.ecom.reviews.model.dto.ReviewsDataDto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ViewHolder> {
    private List<ReviewsDataDto> reviewsDataDtoList;
    private Context context_dco;

    public ReviewsAdapter(List<ReviewsDataDto> reviewsDataDtoList, Context context_dco) {
        this.reviewsDataDtoList = reviewsDataDtoList;
        this.context_dco = context_dco;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_reviews, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.commentTextView_v.setText(reviewsDataDtoList.get(i).getComment());
        viewHolder.textViewDate_v.setText(reviewsDataDtoList.get(i).getDate());
        viewHolder.usernameTextView_v.setText(reviewsDataDtoList.get(i).getFullname());
        viewHolder.productRating_v.setText(String.valueOf(reviewsDataDtoList.get(i).getStar()));
    }

    @Override
    public int getItemCount() {
        return reviewsDataDtoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.date)
        TextView textViewDate_v;

        @BindView(R.id.comment)
        TextView commentTextView_v;

        @BindView(R.id.username)
        TextView usernameTextView_v;

        @BindView(R.id.productRating)
        TextView productRating_v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
