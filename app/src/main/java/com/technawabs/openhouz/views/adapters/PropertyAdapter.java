package com.technawabs.openhouz.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.technawabs.openhouz.R;
import com.technawabs.openhouz.constants.OpenHouzConstants;
import com.technawabs.openhouz.models.PropertyDetail;
import com.technawabs.openhouz.models.PropertyViewing;

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
        switch (viewType) {
            case OpenHouzConstants.CardType.PROPERTY_CARD:
                itemView = layoutInflater.inflate(R.layout.property_card, parent, false);
                break;
            case OpenHouzConstants.CardType.UPCOMING_VIEWING_CARD:
                itemView = layoutInflater.inflate(R.layout.property_viewing_card, parent, false);
                break;
            case OpenHouzConstants.CardType.UPCOMING_VIEWED_CARD:
                break;
        }
        return new PropertyViewHolder(parent.getContext(), itemView);
    }

    @Override
    public void onBindViewHolder(PropertyViewHolder holder, int position) {
        final PropertyDetail propertyDetail = propertyDetailList.get(position);
        if (propertyDetail != null) {
            switch (propertyDetail.getCardType()) {
                case OpenHouzConstants.CardType.UPCOMING_VIEWED_CARD:
                    break;
                case OpenHouzConstants.CardType.UPCOMING_VIEWING_CARD:
                    bindUpcomingViewingPropertyCard(propertyDetail, holder);
                    break;
                default:
                    bindPropertyCard(propertyDetail, holder);
                    break;
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

    @Override
    public int getItemViewType(int position) {
        final PropertyDetail propertyDetail = propertyDetailList.get(position);
        if (propertyDetail != null) {
            switch (propertyDetail.getCardType()) {
                case OpenHouzConstants.CardType.UPCOMING_VIEWING_CARD:
                    return OpenHouzConstants.CardType.UPCOMING_VIEWING_CARD;
                case OpenHouzConstants.CardType.UPCOMING_VIEWED_CARD:
                    return OpenHouzConstants.CardType.UPCOMING_VIEWED_CARD;
                default:
                    return OpenHouzConstants.CardType.PROPERTY_CARD;
            }
        }
        return OpenHouzConstants.CardType.PROPERTY_CARD;
    }

    private void bindPropertyCard(PropertyDetail propertyDetail, PropertyViewHolder holder) {
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
            holder.isPropertyFavorite.setImageResource(R.drawable.ic_favorite_24dp);
        } else {
            holder.isPropertyFavorite.setImageResource(R.drawable.ic_favorite_border_24dp);
        }
    }

    private void bindUpcomingViewingPropertyCard(PropertyDetail propertyDetail, PropertyViewHolder holder) {
        PropertyViewing propertyViewing = propertyDetail.getPropertyViewing();
        if (propertyDetail.getPropertyImageUrl() != null) {
//                holder.propertyImage.setImageResource();
        }
        if (propertyDetail.getPropertyLocation() != null) {
            holder.propertyAddress.setText(propertyDetail.getPropertyLocation());
        }
    }

    private void bindViewedPropertyCard(PropertyDetail propertyDetail, PropertyViewHolder holder) {
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
        //Property Viewing Card
        private TextView propertyAddress;
        private TextView propertyViewingTime;
        private TextView propertyAgentName;
        private TextView propertyAgentContactNumber;
        private TextView propertyPrice;
        private Button cancelViewing;
        private Button getPropertyDirection;


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
            //Upcoming card
            propertyImage = (ImageView) itemView.findViewById(R.id.property_image);
            propertyAddress = (TextView) itemView.findViewById(R.id.property_address);

        }
    }
}
