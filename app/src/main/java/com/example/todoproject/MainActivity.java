package com.example.todoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public RecyclerViewFrag recyclerview = new RecyclerViewFrag();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.FContainer, FirstPageFragment.newInstance())
                    .commitNow();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.optionsmenu, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Fragment Selectedfragment = null;
        switch (item.getItemId()) {

            case R.id.NewTodo:
                //insert intent to load frag here
                break;
            case R.id.RecyclerView:
                Selectedfragment = new RecyclerViewFrag();
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.FContainer, Selectedfragment).addToBackStack(null).commit();
        return true;
    }
}
