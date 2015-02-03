package com.example.blake.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class DieActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.die_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // Already in this menu
        if (id == R.id.optionMenuDieItem)
        {
            return true;
        }

        // Roll the dice option
        if(id == R.id.optionMenuCoinItem)
        {
            // Switch to the rolling dice activity
            Intent dieIntent = new Intent(this, MainActivity.class);
            startActivity(dieIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
