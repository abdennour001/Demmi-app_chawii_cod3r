package com.example.asus.demmi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * A login screen that offers login via email or phone number/password.
 */

public class LoginActivity extends AppCompatActivity {

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "0797417330:hello", "abdou@example.com:world"
    };


    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private TextView mInputControl;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        mEmailView = (EditText)findViewById(R.id.emailtext_login);
        mPasswordView = (EditText)findViewById(R.id.passwordtext_login);
        final Button mSignInButton = (Button)findViewById(R.id.signinbtn);
        final Button mSignUpButton = (Button)findViewById(R.id.joinusbtn);
        final Button mLearnMore = (Button)findViewById(R.id.learnmorebtn);

        // Sign in button event handler
        mSignInButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mSignInButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonstylepink_on_click));
                        break;
                    case MotionEvent.ACTION_UP:
                        view.performClick();
                        mProgressView.setVisibility(View.VISIBLE);
                        mSignInButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonstylepink));
                        // On click sign up dummy.
                        attemptLogin();
                        break;
                }
                return false;
            }
        });

        // Sign up event handler
        mSignUpButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mSignUpButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonstylepink_over_red_on_click));
                        break;
                    case MotionEvent.ACTION_UP:
                        view.performClick();
                        mSignUpButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonstylepink));
                        // On click sign up dummy.
                        attemptSignUp();
                        break;
                }
                return false;
            }
        });

        // Learn more button event handler
        mLearnMore.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mLearnMore.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonstylestroke_on_click));
                        break;
                    case MotionEvent.ACTION_UP:
                        view.performClick();
                        mLearnMore.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonstylestroke));
                        attemptLearnMore();
                        break;
                }
                return false;
            }
        });



        mInputControl = (TextView)findViewById(R.id.pleasecheckout);
        mProgressView = findViewById(R.id.login_progress);
        mLoginFormView = findViewById(R.id.email_login_form);
    }

    private void attemptLearnMore() {
        Intent mainIntent = new Intent(LoginActivity.this,AboutActivity.class);
        startActivity(mainIntent);
        finish();
    }

    private void attemptSignUp() {
        Intent mainIntent = new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(mainIntent);
        finish();
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Reset errors
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;


        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            //mPasswordView.setError(getString(R.string.error_invalid_password));
            mInputControl.setVisibility(TextView.VISIBLE);
            mInputControl.setText(getString(R.string.error_invalid_password));
            Toast.makeText(getApplicationContext(), getString(R.string.error_invalid_email), Toast.LENGTH_SHORT).show();
            mPasswordView.setText(null);
            mProgressView.setVisibility(View.INVISIBLE);
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            //mEmailView.setError(getString(R.string.error_field_required));
            mInputControl.setVisibility(TextView.VISIBLE);
            mInputControl.setText(getString(R.string.error_field_required));
            Toast.makeText(getApplicationContext(), getString(R.string.error_field_required), Toast.LENGTH_SHORT).show();
            mPasswordView.setText(null);
            mProgressView.setVisibility(View.INVISIBLE);
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            //mEmailView.setError(getString(R.string.error_invalid_email));
            mInputControl.setVisibility(TextView.VISIBLE);
            mInputControl.setText(getString(R.string.error_invalid_email));
            Toast.makeText(getApplicationContext(), getString(R.string.error_invalid_email), Toast.LENGTH_SHORT).show();
            mPasswordView.setText(null);
            mProgressView.setVisibility(View.INVISIBLE);
            focusView = mEmailView;
            cancel = true;
        }

        // All clear.
        Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(mainIntent);
        finish();
        /*for (String credential : DUMMY_CREDENTIALS) {
            String[] pieces = credential.split(":");
            if (pieces[0].equals(email)) {
                // Account exists, return true if the password matches.
                if(pieces[1].equals(password)) {
                    mInputControl.setVisibility(View.GONE);
                    try {
                        // Simulate network access.
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                } else {
                    mInputControl.setVisibility(TextView.VISIBLE);
                    mInputControl.setText(getString(R.string.error_incorrect_password));
                    Toast.makeText(getApplicationContext(), getString(R.string.error_incorrect_password), Toast.LENGTH_SHORT).show();

                    mPasswordView.setText(null);
                    mProgressView.setVisibility(View.INVISIBLE);
                }
            }
        }*/

    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

}
