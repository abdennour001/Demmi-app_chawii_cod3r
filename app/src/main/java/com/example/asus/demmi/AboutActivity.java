package com.example.asus.demmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    // UI references.
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        mBackButton = findViewById(R.id.back_to_main);
        // Back event handler
        mBackButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mBackButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonstylepink_over_red_on_click));
                        break;
                    case MotionEvent.ACTION_UP:
                        view.performClick();
                        mBackButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonstylepink));
                        // On click sign up dummy.
                        attemptBack();
                        break;
                }
                return false;
            }
        });

    }

    private void attemptBack() {
        Intent mainIntent = new Intent(AboutActivity.this,LoginActivity.class);
        startActivity(mainIntent);
    }
}
