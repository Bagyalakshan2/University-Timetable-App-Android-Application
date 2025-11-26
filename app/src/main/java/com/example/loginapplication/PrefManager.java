package com.example.loginapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class   PrefManager {
    private static final String PREF_NAME = "USER_PREF";
    private static final String KEY_COURSE = "COURSE";
    private final SharedPreferences prefs;

    public PrefManager(Context context){
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveCourse(String course){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_COURSE, course);
        editor.apply();
    }

    public String getCourse(){
        return prefs.getString(KEY_COURSE, null);
    }

    public void clearCourse(){
        prefs.edit().remove(KEY_COURSE).apply();
    }

}
