package com.technawabs.openhouz.utils;

import android.graphics.Path;

import com.technawabs.openhouz.constants.OpenHouzConstants;
import com.technawabs.openhouz.models.Message;

public class Utility {

    public static Message userSentMessage(String message) {
        final Message userMessage = new Message();
        userMessage.setMessage(message);
        userMessage.setSender(OpenHouzConstants.Sender.USER);
        return userMessage;
    }

    public static Message botSentMessage(String message) {
        final Message botMessage = new Message();
        botMessage.setMessage(message);
        botMessage.setSender(OpenHouzConstants.Sender.BOT);
        return botMessage;
    }
}
