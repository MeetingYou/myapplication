package com.orange.filepersistancetest;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by 80119667 on 2016-05-28.
 */
public class ActivityController {
    private static ArrayList<Activity> mActivityArrayList = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        mActivityArrayList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        mActivityArrayList.remove(activity);
    }

    public static void finishAllActivity() {
        for (Activity activity : mActivityArrayList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
