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

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Initializing string and textView variable
    String usernameString;

    TextView displayUsername;
    TextView koreanProverbTexView;
    TextView proverbEnglishTranslation;
    TextView koreanTitBit;

    Button proceedButton;

    RelativeLayout mainLayout;

    MediaPlayer myMediaPlayer;

    int myRandomNumber;

    Proverb myProverbObject;

    Boolean buttonIsClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proverb);

        myMediaPlayer = MediaPlayer.create(this, R.raw.epiphany);
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


        final ArrayList<Proverb> proverbs = new ArrayList<>();

        proverbs.add(new Proverb(getResources().getString(R.string.first_korean_proverb),
                getResources().getString(R.string.second_english_translation),
                getResources().getString(R.string.second_tit_bit)));

        proverbs.add(new Proverb(getResources().getString(R.string.second_korean_proverb),
                getResources().getString(R.string.second_english_translation),
                getResources().getString(R.string.second_tit_bit)));

        proverbs.add(new Proverb(getResources().getString(R.string.third_korean_proverb),
                getResources().getString(R.string.third_english_translation),
                getResources().getString(R.string.third_tit_bit)));

        proverbs.add(new Proverb(getResources().getString(R.string.fourth_korean_proverb),
                getResources().getString(R.string.fourth_english_translation),
                getResources().getString(R.string.fourth_tit_bit)));

        proverbs.add(new Proverb(getResources().getString(R.string.fifth_korean_proverb),
                getResources().getString(R.string.fifth_english_translation),
                getResources().getString(R.string.fifth_tit_bit)));

        proverbs.add(new Proverb(getResources().getString(R.string.sixth_korean_proverb),
                getResources().getString(R.string.sixth_english_translation),
                getResources().getString(R.string.sixth_tit_bit)));

        proverbs.add(new Proverb(getResources().getString(R.string.seventh_korean_proverb),
                getResources().getString(R.string.seventh_korean_proverb),
                getResources().getString(R.string.seventh_tit_bit)));

        proverbs.add(new Proverb(getResources().getString(R.string.eighth_korean_proverb),
                getResources().getString(R.string.eighth_english_translation),
                getResources().getString(R.string.eighth_tit_bit)));

        proverbs.add(new Proverb(getResources().getString(R.string.ninth_korean_proverb),
                getResources().getString(R.string.ninth_english_translation),
                getResources().getString(R.string.ninth_tit_bit)));

        proverbs.add(new Proverb(getResources().getString(R.string.last_korean_proverb),
                getResources().getString(R.string.last_english_translation),
                getResources().getString(R.string.last_tit_bit)));


        //Get the TextView and ButtonView of the different components
        koreanProverbTexView = findViewById(R.id.korean_proverb_text_view);
        proverbEnglishTranslation = findViewById(R.id.first_proverb_english);
        koreanTitBit = findViewById(R.id.first_tit_bit);

        displayUsername = findViewById(R.id.username_display_text);
        displayUsername.setText(usernameString);

        proceedButton = findViewById(R.id.first_puzzle_button);


        //Sets the initial korean proverb and also the translations
        koreanProverbTexView.setText(getResources().getString(R.string.start_korean_proverb));
        proverbEnglishTranslation.setText(getResources().getString(R.string.start_english_translation));
        koreanTitBit.setText(getResources().getString(R.string.start_tit_bit));

        //This method sets the next proverb
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get a proverb object at the randomNumber position
                myProverbObject = proverbs.get(myRandomNumber);

                //Reset random number on button click
                myRandomNumber = new Random().nextInt(10);

                //get object proverb, translation and Titbit then set to the respective TextViews
                koreanProverbTexView.setText(myProverbObject.getKoreanProverb());

                proverbEnglishTranslation.setText(" ");
                koreanTitBit.setText(" ");
            }
        });

        //This gives extra information about the proverb
        proceedButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                proverbEnglishTranslation.setText(myProverbObject.getEnglishTranslation());
                koreanTitBit.setText(myProverbObject.getTitBit());

                return true;
            }
        });
    }

    /**
     * This method releases the mediaPlayer object
     */
    public void releaseMediaPlayer() {
        if (myMediaPlayer != null) {
            myMediaPlayer.release();
            myMediaPlayer = null;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        myMediaPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        myMediaPlayer.start();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        myMediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
    }
}
