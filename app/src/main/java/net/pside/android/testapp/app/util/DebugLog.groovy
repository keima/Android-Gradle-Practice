package net.pside.android.testapp.app.util

import android.util.Log

class DebugLog {

    private static final String TAG = "GroovyTestApp"

    public static void d(String message) {
        Log.d(TAG, message)
    }
}