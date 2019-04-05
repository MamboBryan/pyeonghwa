package com.mambobryan.pyeonghwa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstPuzzleActivity extends AppCompatActivity {

    //Initializing string and textView variable
    String usernameString;

    TextView displayUsername;
    TextView firstProverbEnglish;
    TextView firstTitBit;

    Button proceedButton;

    int clue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proverb);

        //get the username entered in previous activity
        final Intent firstPuzzleIntent = getIntent();
        usernameString = firstPuzzleIntent.getStringExtra("username");

        firstTitBit = findViewById(R.id.first_tit_bit);
        firstProverbEnglish = findViewById(R.id.first_proverb_english);
        displayUsername = findViewById(R.id.username_display_text);
        displayUsername.setText(usernameString);

        proceedButton = findViewById(R.id.first_puzzle_button);
        proceedButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (clue == 0) {

                    firstProverbEnglish.setText(getResources().getString(R.string.first_english_translation));

                    clue++;

                } else if (clue == 1) {

                    firstTitBit.setText(getResources().getString(R.string.first_tit_bit));

                    clue++;

                } else if (clue > 1) {
                    //Proceeds to the next proverb
                }

                return false;
            }
        });

    }
}
