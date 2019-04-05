package com.mambobryan.pyeonghwa;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    //Initialize welcomeActivity username edit text
    EditText username;

    //Initialize start button
    Button startButton;

    //Initialize TextView for the username
    TextView userText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        username = findViewById(R.id.username);
        startButton = findViewById(R.id.welcome_start_button);
        userText = findViewById(R.id.welcome_user_text);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameString = username.getText().toString();
                if (TextUtils.isEmpty(usernameString)){
                    userText.setText(getString(R.string.welcome_text_on_tap_empty));
                } else {
                    userText.setText(getString(R.string.welcome_text_on_tap) + " " + usernameString);
                }

            }
        });
    }
}
