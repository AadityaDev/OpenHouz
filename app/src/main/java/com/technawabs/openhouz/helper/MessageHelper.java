package com.technawabs.openhouz.helper;

import android.app.Activity;

public class MessageHelper {

    private Activity activity;
    private final String TAG;

    public MessageHelper(Activity activity) {
        this.activity = activity;
        TAG = activity.getClass().getName();
    }



}
