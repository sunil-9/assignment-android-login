package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class Signup extends AppCompatActivity  implements SwipeGesture.onSwipeListener {
    SwipeGesture onSwipeTouchListener;
    FrameLayout frameLayout;
    EditText username;
    EditText password;
    EditText email;
    RadioButton radioButton;
    Button button;


    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeTop() {

    }

    @Override
    public void swipeBottom() {
        Toast.makeText(getApplicationContext(), "Swiped Up done!", Toast.LENGTH_SHORT).show();
        openFragment();
    }

    @Override
    public void swipeLeft() {

    }


    public static View makeMeShake(View view, int duration, int offset) {
        Animation anim = new TranslateAnimation(-offset,offset,0,0);
        anim.setDuration(duration);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(5);
        view.startAnimation(anim);
        return view;
    }
    public void openFragment(){
        Login fragment = Login.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.left_enter, R.anim.right_enter, R.anim.left_enter, R.anim.right_enter);
        transaction.addToBackStack(null);
        setTitle("Login");
        transaction.replace(R.id.login_frag, fragment).commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        onSwipeTouchListener = new SwipeGesture(this, findViewById(R.id.login_frag));
        frameLayout = (FrameLayout) findViewById(R.id.login_frag);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        radioButton = (RadioButton) findViewById(R.id.acceptTerms);
        button = (Button) findViewById(R.id.signup);

//        swipe gerture

        //validation
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.length() < 3 ) {
                    Toast.makeText(getApplicationContext(), "Username must be more than 3 digits", Toast.LENGTH_SHORT).show();
                    makeMeShake(username,20,9);
                }
                else if (email.length() <5) {
                    Toast.makeText(getApplicationContext(), "Enter valid email address", Toast.LENGTH_SHORT).show();
                    makeMeShake(email,20,9);
                }
                else if (password.length()  < 3 ) {
                    Toast.makeText(getApplicationContext(), "Password must be more than 3 digits", Toast.LENGTH_SHORT).show();
                    makeMeShake(password,20,9);
                }
                else if (!(radioButton.isChecked())) {
                    Toast.makeText(getApplicationContext(), "Please accept our terms and conditions", Toast.LENGTH_SHORT).show();
                    makeMeShake(radioButton,20,9);
                }
                else {

                    openFragment();

                }
            }
        });

    }

}

