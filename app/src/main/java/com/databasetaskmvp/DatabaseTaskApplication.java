package com.databasetaskmvp;

import android.app.Application;
import android.content.Context;

import com.databasetaskmvp.data.InstituteDatabase;

/**
 * Created by appinventiv on 20/4/18.
 */

public class DatabaseTaskApplication extends Application {

    public static InstituteDatabase instituteDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        instituteDatabase = new InstituteDatabase(getApplicationContext());
    }
}
