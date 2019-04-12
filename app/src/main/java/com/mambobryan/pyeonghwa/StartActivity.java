package com.mambobryan.pyeonghwa;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class StartActivity extends AppCompatActivity {

    //Declare startActivity button
    Button letsGo;

    //Declaring initial longPress state
    int longPressed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        //Initializing start activity button
        letsGo = findViewById(R.id.lets_go_button);

        //Method to solve the puzzle
        letsGo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setRevealText(longPressed);
                longPressed++;
                return false;
            }
        });

        //Method for going to the next page when back button is pressed
        letsGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (longPressed > 3){
                    //After it updates the last letter it goes to the next screen
                    Intent startIntent = new Intent(StartActivity.this, WelcomeActivity.class);
                    StartActivity.this.startActivity(startIntent);
                }
            }
        });
    }

    /**
     * This method sets the TextView text
     *
     * @param counter
     */
    public void setRevealText(int counter) {

        if (counter == 0) {
            TextView firstLetter = findViewById(R.id.start_puzzle_o);
            firstLetter.setText("O");
            Toast.makeText(this, "You've gotten a hint", Toast.LENGTH_SHORT).show();
        } else if (counter == 1) {
            TextView firstLetter = findViewById(R.id.start_puzzle_u);
            firstLetter.setText("U");

        } else if (counter == 2) {
            TextView firstLetter = findViewById(R.id.start_puzzle_t);
            firstLetter.setText("T");

            //After it updates the last letter it goes to the next screen
            Intent startIntent = new Intent(StartActivity.this, WelcomeActivity.class);
            StartActivity.this.startActivity(startIntent);

        }  else {
            Toast.makeText(this, "Too many long press", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        //Method for going to the next page when back button is pressed
        letsGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (longPressed > 3){
                    //After it updates the last letter it goes to the next screen
                    Intent startIntent = new Intent(StartActivity.this, WelcomeActivity.class);
                    StartActivity.this.startActivity(startIntent);
                }
            }
        });
    }
}
