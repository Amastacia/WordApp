package edu.bistu.cs.se.wordapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by wym on 2017/11/10.
 */

public class WordsApplication extends Application {
    private static Context context;

    public static Context getContext(){
        return WordsApplication.context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        WordsApplication.context=getApplicationContext();
    }
}
