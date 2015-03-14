package com.jh.testmybackup;

import android.app.backup.BackupAgentHelper;
import android.app.backup.SharedPreferencesBackupHelper;
import android.util.Log;

public class TheBackupAgent extends BackupAgentHelper {
    // The names of the SharedPreferences groups that the application maintains.  These
    // are the same strings that are passed to getSharedPreferences(String, int).
    static final String PREFS_DISPLAY = "displayprefs";

    // An arbitrary string used within the BackupAgentHelper implementation to
    // identify the SharedPreferencesBackupHelper's data.
    static final String MY_PREFS_BACKUP_KEY = "com.jh.testmybackup";

    // Simply allocate a helper and install it
    public void onCreate() {
        Log.d("BACKUP", "ThebackupAgent.onCreate()");
        SharedPreferencesBackupHelper helper =
                new SharedPreferencesBackupHelper(this, PREFS_DISPLAY);
        addHelper(MY_PREFS_BACKUP_KEY, helper);
    }
}