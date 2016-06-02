package com.technawabs.openhouz.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.technawabs.openhouz.constants.OpenHouzConstants;
import com.technawabs.openhouz.R;
import com.technawabs.openhouz.models.Message;
import com.technawabs.openhouz.views.uicomponents.TypeWriter;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private final int BOT = 0;
    private final int USER = 1;
    private List<Message> messageList;

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case BOT:
                itemView = layoutInflater.inflate(R.layout.bot_message_bubble, parent, false);
                break;
            case USER:
                itemView = layoutInflater.inflate(R.layout.meessage_bubble, parent, false);
                break;
        }
        return new MessageViewHolder(parent.getContext(), itemView);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        final Message message = messageList.get(position);
        switch (message.getSender()) {
            case OpenHouzConstants.Sender.BOT:
                holder.botMessage.setCharacterDelay(150);
                if (messageList.size() == 1) {
                    holder.botMessage.animateText(message.getMessage());
                }
                break;
            case OpenHouzConstants.Sender.USER:
                holder.userMessage.setText(message.getMessage());
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        final Message message = messageList.get(position);
        if (message.getSender().equalsIgnoreCase(OpenHouzConstants.Sender.BOT)) {
            return BOT;
        } else {
            return USER;
        }

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {

        public Context context;
        public TypeWriter botMessage;
        public ImageView botImage;
        public TextView userMessage;
        public ImageView userImage;
        public EditText userTypedMessage;

        public MessageViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            botMessage = (TypeWriter) itemView.findViewById(R.id.bot_message);
            botImage = (ImageView) itemView.findViewById(R.id.bot_image);
            userImage = (ImageView) itemView.findViewById(R.id.user_image);
            userMessage = (TextView) itemView.findViewById(R.id.user_message);
            userTypedMessage = (EditText) itemView.findViewById(R.id.send_message_text);
        }
    }

}
