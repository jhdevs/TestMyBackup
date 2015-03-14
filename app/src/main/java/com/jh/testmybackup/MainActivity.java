package com.jh.testmybackup;

import android.app.backup.BackupManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    SharedPreferences prefs;
    static final String PREFS_KEY = "tstpfr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(TheBackupAgent.PREFS_DISPLAY, Context.MODE_PRIVATE);
        Toast.makeText(this, "pref " + prefs.getString(PREFS_KEY, ""), Toast.LENGTH_LONG).show();

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().putString(PREFS_KEY, "TtTtTtTtT").commit();
                BackupManager bm = new BackupManager(MainActivity.this);
                bm.dataChanged();
            }
        });
    }
}
