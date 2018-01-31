package com.example.joaovitor.shared;

import android.app.Application;

import com.example.joaovitor.shared.network.RetroFitManager;

/**
 * Created by joaovitor on 31/08/17.
 */

public class MarvelApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetroFitManager.getInstance();
    }
}
