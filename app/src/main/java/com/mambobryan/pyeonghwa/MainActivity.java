package com.mambobryan.pyeonghwa;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Initializing string and textView variable
    String usernameString;

    TextView displayUsername;
    TextView firstProverbEnglish;
    TextView firstTitBit;

    Button proceedButton;

    RelativeLayout mainLayout;

    int clue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proverb);

        MediaPlayer myMediaPlayer = MediaPlayer.create(this, R.raw.epiphany);
        myMediaPlayer.start();
        myMediaPlayer.setLooping(true);
        myMediaPlayer.setVolume(10, 10);

        mainLayout = findViewById(R.id.proverb_layout);
        AnimationDrawable animateBackground = (AnimationDrawable) mainLayout.getBackground();
        animateBackground.setEnterFadeDuration(2000);
        animateBackground.setEnterFadeDuration(5000);
        animateBackground.start();

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

                firstProverbEnglish.setText(getResources().getString(R.string.first_english_translation));
                firstTitBit.setText(getResources().getString(R.string.first_tit_bit));

                return true;
            }
        });

    }
}
