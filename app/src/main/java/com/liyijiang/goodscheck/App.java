package com.liyijiang.goodscheck;

import android.app.Application;
import android.content.Context;

/**
 * Created by lili on 16/2/2.
 */
public class App extends Application{


    public static boolean debug = true;
    public static Context ctx;

    @Override
    public void onCreate() {
        super.onCreate();

        ctx = this;
    }
}
