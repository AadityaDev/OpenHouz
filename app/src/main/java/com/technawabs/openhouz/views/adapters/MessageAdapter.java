package com.technawabs.openhouz.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.technawabs.openhouz.constants.OpenHouzConstants;
import com.technawabs.openhouz.R;
import com.technawabs.openhouz.models.Message;
import com.technawabs.openhouz.utils.Utility;
import com.technawabs.openhouz.views.uicomponents.TypeWriter;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private Context context;
    private List<Message> messageList;

    public MessageAdapter(Context context, List<Message> messageList) {
        this.context=context;
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
                break;
            case OpenHouzConstants.APARTMENT_NEIGHBOURHOODS:
                break;
            case OpenHouzConstants.APARTMENT_TYPE:
                itemView = layoutInflater.inflate(R.layout.property_rooms_list, parent, false);
                break;
        }
        return new MessageViewHolder(parent.getContext(), itemView);
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
                break;
            case OpenHouzConstants.ApartmentProperties.NEIGHBOURHOODS:
                holder.botMessage.setText(message.getMessage());
                break;
            case OpenHouzConstants.ApartmentProperties.TYPE:
                holder.botMessage.setText(message.getMessage());
                setupApartmentType(holder);
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

    public void setupApartmentType(MessageViewHolder holder) {
        List<String> restrictionList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String restriction = new String();
            restriction = "No House Party";
            restrictionList.add(restriction);
        }
        GenericArrayAdapter genericArrayAdapter = new GenericArrayAdapter(holder.context, Utility.getArrayForRestrictions(restrictionList), OpenHouzConstants.APARTMENT_TYPE);
        holder.apartmentTypes.setAdapter(genericArrayAdapter);
        genericArrayAdapter.notifyDataSetChanged();
        Utility.setListViewHeightBasedOnChildren(holder.apartmentTypes);
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
            apartmentTypes = (ListView) itemView.findViewById(R.id.room_type_list);
        }
    }

}
