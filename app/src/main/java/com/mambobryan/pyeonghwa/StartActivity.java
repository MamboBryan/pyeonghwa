package com.mambobryan.pyeonghwa;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    }

    /**
     * This method sets the TextView text
     *
     * @param counter
     */
    public void setRevealText(int counter) {

        if (counter == 0) {
            Toast.makeText(this, "You've gotten a hint", Toast.LENGTH_SHORT).show();
        } else if (counter == 1) {
            TextView firstLetter = findViewById(R.id.start_puzzle_o);
            firstLetter.setText("O");

        } else if (counter == 2) {
            TextView firstLetter = findViewById(R.id.start_puzzle_u);
            firstLetter.setText("U");

        } else if (counter == 3) {
            TextView firstLetter = findViewById(R.id.start_puzzle_t);
            firstLetter.setText("T");

        } else {
            Toast.makeText(this, "Too many long press", Toast.LENGTH_SHORT).show();
        }

    }
}
