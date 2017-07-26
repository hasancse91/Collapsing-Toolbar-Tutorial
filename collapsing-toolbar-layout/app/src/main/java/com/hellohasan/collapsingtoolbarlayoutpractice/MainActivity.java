package com.hellohasan.collapsingtoolbarlayoutpractice;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Android Operating System");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinateLayout);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);

        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if(state.equals(State.COLLAPSED)) {
                    toolbar.setBackgroundResource(R.drawable.custom_toolbar);
                    Toast.makeText(getApplicationContext(), "COLLAPSED", Toast.LENGTH_SHORT).show();
                }
                else if (state.equals(State.EXPANDED)) {
                    toolbar.setBackgroundResource(R.color.transparent);
                    Toast.makeText(getApplicationContext(), "EXPANDED", Toast.LENGTH_SHORT).show();
                }
                else if ((state.equals(State.IDLE))){
                    Toast.makeText(getApplicationContext(), "IDLE", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Snackbar.make(coordinatorLayout, "Back button pressed", Snackbar.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
