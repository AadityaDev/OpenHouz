package com.technawabs.openhouz.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.technawabs.openhouz.constants.OpenHouzConstants;
import com.technawabs.openhouz.R;
import com.technawabs.openhouz.models.Message;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<Message> messageList;
    private String sender;

    public MessageAdapter(List<Message> messageList, String sender) {
        this.messageList = messageList;
        this.sender = sender;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (sender) {
            case OpenHouzConstants.Sender.BOT:
                itemView = layoutInflater.inflate(R.layout.bot_message_bubble, parent, false);
                break;
            case OpenHouzConstants.Sender.USER:
                itemView = layoutInflater.inflate(R.layout.meessage_bubble, parent, false);
                break;
        }
        return new MessageViewHolder(parent.getContext(), itemView);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        final Message message = messageList.get(position);
        switch (sender) {
            case OpenHouzConstants.Sender.BOT:
                holder.botMessage.setText(message.getMessage());
                break;
            case OpenHouzConstants.Sender.USER:
                holder.userMessage.setText(message.getMessage());
                break;
        }

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {

        public Context context;
        public TextView botMessage;
        public ImageView botImage;
        public TextView userMessage;
        public ImageView userImage;

        public MessageViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            botMessage = (TextView) itemView.findViewById(R.id.bot_message);
            botImage = (ImageView) itemView.findViewById(R.id.bot_image);
            userImage = (ImageView) itemView.findViewById(R.id.user_image);
            userMessage = (TextView) itemView.findViewById(R.id.user_message);
        }
    }

}
