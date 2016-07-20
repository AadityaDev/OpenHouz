package com.technawabs.openhouz;

import android.app.Application;
import android.support.multidex.MultiDex;

public class AndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }

}
