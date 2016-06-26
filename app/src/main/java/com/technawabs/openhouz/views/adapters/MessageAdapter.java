package com.technawabs.openhouz.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.technawabs.openhouz.constants.OpenHouzConstants;
import com.technawabs.openhouz.R;
import com.technawabs.openhouz.models.GenericArrayItem;
import com.technawabs.openhouz.models.Message;
import com.technawabs.openhouz.utils.Utility;
import com.technawabs.openhouz.views.uicomponents.TypeWriter;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<Message> messageList;
    public static GenericArrayAdapter typeArrayAdapter;
    public MessageViewHolder messageViewHolder;

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case OpenHouzConstants.BOT:
                itemView = layoutInflater.inflate(R.layout.bot_message_bubble, parent, false);
                break;
            case OpenHouzConstants.USER:
                itemView = layoutInflater.inflate(R.layout.meessage_bubble, parent, false);
                break;
            case OpenHouzConstants.APARTMENT_BUDGET:
                itemView = layoutInflater.inflate(R.layout.property_rooms_list, parent, false);
                break;
            case OpenHouzConstants.APARTMENT_NEIGHBOURHOODS:
                itemView = layoutInflater.inflate(R.layout.property_rooms_list, parent, false);
                break;
            case OpenHouzConstants.APARTMENT_TYPE:
                itemView = layoutInflater.inflate(R.layout.property_rooms_list, parent, false);
                break;
        }
        messageViewHolder = new MessageViewHolder(parent.getContext(), itemView);
        return messageViewHolder;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        final Message message = messageList.get(position);
        switch (message.getSender()) {
            case OpenHouzConstants.Sender.BOT:
                holder.botMessage.setCharacterDelay(50);
                if (messageList.size() == 1) {
                    holder.botMessage.animateText(message.getMessage());
                } else {
                    holder.botMessage.setText(message.getMessage());
                }
                break;
            case OpenHouzConstants.Sender.USER:
                holder.userMessage.setText(message.getMessage());
                break;
            case OpenHouzConstants.ApartmentProperties.BUDGET:
                holder.botMessage.setText(message.getMessage());
                setupApartmentProperty(OpenHouzConstants.ApartmentProperties.BUDGET);
                break;
            case OpenHouzConstants.ApartmentProperties.NEIGHBOURHOODS:
                holder.botMessage.setText(message.getMessage());
                setupApartmentProperty(OpenHouzConstants.ApartmentProperties.NEIGHBOURHOODS);
                break;
            case OpenHouzConstants.ApartmentProperties.TYPE:
                holder.botMessage.setText(message.getMessage());
                setupApartmentProperty(OpenHouzConstants.ApartmentProperties.TYPE);
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        final Message message = messageList.get(position);
        switch (message.getSender()) {
            case OpenHouzConstants.Sender.BOT:
                return OpenHouzConstants.BOT;
            case OpenHouzConstants.Sender.USER:
                return OpenHouzConstants.USER;
            case OpenHouzConstants.ApartmentProperties.BUDGET:
                return OpenHouzConstants.APARTMENT_BUDGET;
            case OpenHouzConstants.ApartmentProperties.NEIGHBOURHOODS:
                return OpenHouzConstants.APARTMENT_NEIGHBOURHOODS;
            case OpenHouzConstants.ApartmentProperties.TYPE:
                return OpenHouzConstants.APARTMENT_TYPE;
            default:
                return OpenHouzConstants.BOT;
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    @Override
    public long getItemId(int position) {
        return messageList.get(position).getId();
    }

    public void setupApartmentProperty(String type) {
        List<String> restrictionList = new ArrayList<>();
        switch (type) {
            case OpenHouzConstants.ApartmentProperties.BUDGET:
                for (int i = 0; i < 6; i++) {
                    String restriction = new String();
                    restriction = "No House Party";
                    restrictionList.add(restriction);
                }
                GenericArrayAdapter genericArrayAdapter = new GenericArrayAdapter(messageViewHolder.context, Utility.getArrayForRestrictions(restrictionList), OpenHouzConstants.APARTMENT_BUDGET);
                messageViewHolder.apartmentBudget.setAdapter(genericArrayAdapter);
                if (messageList.size() == 4) {
                    Utility.setListViewHeightBasedOnChildrenHalf(messageViewHolder.apartmentNeighbourhoods);
                } else {
                    Utility.setListViewHeightBasedOnChildrenHalf(messageViewHolder.apartmentBudget);
                }
                break;
            case OpenHouzConstants.ApartmentProperties.NEIGHBOURHOODS:
                for (int i = 0; i < 2; i++) {
                    String restriction = new String();
                    restriction = "No House Party";
                    restrictionList.add(restriction);
                }
                GenericArrayAdapter neigbourhoodAdapter = new GenericArrayAdapter(messageViewHolder.context, Utility.getArrayForRestrictions(restrictionList), OpenHouzConstants.APARTMENT_NEIGHBOURHOODS);
                messageViewHolder.apartmentNeighbourhoods.setAdapter(neigbourhoodAdapter);
                if (messageList.size() == 3) {
                    Utility.setListViewHeightBasedOnChildrenHalf(messageViewHolder.apartmentNeighbourhoods);
                } else {
                    Utility.setListViewHeightBasedOnChildren(messageViewHolder.apartmentNeighbourhoods);
                }
                break;
            case OpenHouzConstants.ApartmentProperties.TYPE:
                for (int i = 0; i < 6; i++) {
                    String restriction = new String();
                    restriction = "No House Party";
                    restrictionList.add(restriction);
                }
                typeArrayAdapter = new GenericArrayAdapter(messageViewHolder.context, Utility.getArrayForRestrictions(restrictionList), OpenHouzConstants.APARTMENT_TYPE);
                messageViewHolder.apartmentTypes.setAdapter(typeArrayAdapter);
                typeArrayAdapter.notifyDataSetChanged();
                if (messageList.size() == 2) {
                    Utility.setListViewHeightBasedOnChildrenHalf(messageViewHolder.apartmentTypes);
                } else {
                    Utility.setListViewHeightBasedOnChildren(messageViewHolder.apartmentTypes);
                }
                break;
        }
    }

    public ListView getListView(int type) {
        ListView listView = null;
        switch (type) {
            case OpenHouzConstants.APARTMENT_BUDGET:
                listView = messageViewHolder.apartmentBudget;
                break;
            case OpenHouzConstants.APARTMENT_NEIGHBOURHOODS:
                listView = messageViewHolder.apartmentNeighbourhoods;
                break;
            case OpenHouzConstants.APARTMENT_TYPE:
                listView = messageViewHolder.apartmentTypes;
                break;
        }
        return listView;
    }

    public List<GenericArrayItem> getArrayList(int type) {
        List<GenericArrayItem> genericArrayItemList = new ArrayList<GenericArrayItem>();
        switch (type) {
            case OpenHouzConstants.APARTMENT_BUDGET:
                break;
            case OpenHouzConstants.APARTMENT_NEIGHBOURHOODS:
                genericArrayItemList.addAll(typeArrayAdapter.getValues());
                break;
            case OpenHouzConstants.APARTMENT_TYPE:
                genericArrayItemList.addAll(typeArrayAdapter.getValues());
                break;
        }
        return genericArrayItemList;
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {

        public Context context;
        public TypeWriter botMessage;
        public ImageView botImage;
        public TextView userMessage;
        public ImageView userImage;
        public ListView apartmentBudget;
        public ListView apartmentTypes;
        public ListView apartmentNeighbourhoods;

        public MessageViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            botMessage = (TypeWriter) itemView.findViewById(R.id.bot_message);
            botImage = (ImageView) itemView.findViewById(R.id.bot_image);
            userImage = (ImageView) itemView.findViewById(R.id.user_image);
            userMessage = (TextView) itemView.findViewById(R.id.user_message);
            apartmentBudget = (ListView) itemView.findViewById(R.id.room_type_list);
            apartmentNeighbourhoods = (ListView) itemView.findViewById(R.id.room_type_list);
            apartmentTypes = (ListView) itemView.findViewById(R.id.room_type_list);
        }
    }
}
