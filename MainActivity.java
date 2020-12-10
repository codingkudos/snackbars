package com.codingkudos.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View coordinatorLayout = findViewById(R.id.coordinatorLayout);

        TextView textToBeDeleted = findViewById(R.id.textToBeDeleted);

        Button buttonSnackbar = findViewById(R.id.buttonDeleteText);
        buttonSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked");
                textToBeDeleted.setText("");
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Button is clicked", Snackbar.LENGTH_INDEFINITE)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                textToBeDeleted.setText("Some text to be deleted");
                            }
                        })
                        .setActionTextColor(Color.CYAN);
                snackbar.show();
            }
        });
    }
}
