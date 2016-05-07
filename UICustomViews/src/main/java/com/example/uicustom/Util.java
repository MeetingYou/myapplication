package com.example.uicustom;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by 80119667 on 2016-05-07.
 */
public class Util {
    private static ArrayList<Activity> arrayList = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        arrayList.add(activity);
    }
    public static void removeActivity(Activity activity) {
        arrayList.remove(activity);
    }
    public static void finishAll() {
        if (arrayList.size()>0) {
            for(Activity activity:arrayList) {
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
        }
    }
}
