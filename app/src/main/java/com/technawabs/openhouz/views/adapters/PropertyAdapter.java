package com.technawabs.openhouz.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.technawabs.openhouz.R;
import com.technawabs.openhouz.models.PropertyDetail;

import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder> {

    private List<PropertyDetail> propertyDetailList;

    public PropertyAdapter(List<PropertyDetail> propertyDetailList) {
        this.propertyDetailList = propertyDetailList;
    }

    @Override
    public PropertyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        itemView = layoutInflater.inflate(R.layout.property_card, parent, false);
        return new PropertyViewHolder(parent.getContext(), itemView);
    }

    @Override
    public void onBindViewHolder(PropertyViewHolder holder, int position) {
        final PropertyDetail propertyDetail = propertyDetailList.get(position);
        if (propertyDetail != null) {
            if (propertyDetail.getPropertyImageUrl() != null) {
//                holder.propertyImage.setImageResource();
            }
            if (propertyDetail.getPropertyTitle() != null) {
                holder.propertyTitle.setText(propertyDetail.getPropertyTitle());
            }
            if (propertyDetail.getPropertyLocation() != null) {
                holder.propertyLocation.setText(propertyDetail.getPropertyLocation());
            }
            if (propertyDetail.getPrice() != null) {
                holder.propertyRent.setText(propertyDetail.getPrice());
            }
            if (propertyDetail.getPropertyBHK() != null) {
                holder.propertyBHK.setText(propertyDetail.getPropertyBHK());
            }
            if (propertyDetail.isFavorite()) {
//                holder.isPropertyFavorite.setImageResource(R.drawable.ic);
            } else {
                holder.isPropertyFavorite.setImageResource(R.drawable.ic_favorite_border_24dp);
            }
        }
    }

    @Override
    public long getItemId(int position) {
        return propertyDetailList.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return propertyDetailList.size();
    }

    public static class PropertyViewHolder extends RecyclerView.ViewHolder {

        private Context context;
        private ImageView propertyImage;
        private ImageView isPropertyFavorite;
        private TextView propertyLocation;
        private TextView propertyTitle;
        private TextView propertyArea;
        private TextView propertyBHK;
        private TextView propertyRent;

        public PropertyViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            propertyImage = (ImageView) itemView.findViewById(R.id.property_image);
            isPropertyFavorite = (ImageView) itemView.findViewById(R.id.favorite_icon);
            propertyLocation = (TextView) itemView.findViewById(R.id.property_location);
            propertyTitle = (TextView) itemView.findViewById(R.id.property_title);
            propertyArea = (TextView) itemView.findViewById(R.id.square_feet);
            propertyBHK = (TextView) itemView.findViewById(R.id.bhk);
            propertyRent = (TextView) itemView.findViewById(R.id.rent);
        }
    }
}
