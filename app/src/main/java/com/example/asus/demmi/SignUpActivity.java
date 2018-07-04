package com.example.asus.demmi;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * A Sign up screen that offers sign up via many information.
 */

public class SignUpActivity extends AppCompatActivity {

    // The Authentication reference.

    private FirebaseAuth mAuth;

    // The database reference.

    DatabaseReference database;

    // UI References.

    private EditText mUserName;
    private EditText mPhoneNumber;
    private EditText mEmail;
    private EditText mPassword1;
    private EditText mPassword2;
    private Spinner mWilayaSpinner;
    private EditText mRegion;
    private Spinner mSexSpinner;
    private Spinner mAge;
    private Spinner mBloodRisus;
    private Spinner mBloodCategory;

    // UI TextFields Controls
    private TextView mUserNameControl;
    private TextView mPhoneNumberControl;
    private TextView mEmailControl;
    private TextView mPassword1Control;
    private TextView mPassword2Control;
    private TextView mRegionControl;
    private TextView mAgeControl;

    // .
    private TextView mInputControle;
    private View mProgressBar;
    private TextView mSignInLabel;
    // .

    Button mBackButton;
    Button mSignUpButton;

    /**
     * Boolean checks to make sure all fields are ready to go.
     * **/

    private boolean userNameCheck=false;
    private boolean phoneNumberCheck=false;
    private boolean emailCheck=false;
    private boolean password1Check=false;
    private boolean password2Check=false;
    private boolean regionCheck=false;
    private boolean ageCheck=false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        /**
         * Add all (findViews) here. **/
        defineViews();
        /**
         *
         * **/

        // Initializing the Authentication reference

        mAuth = FirebaseAuth.getInstance();

        // Initializing the database reference.

        database = FirebaseDatabase.getInstance().getReference();

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
                        if(ageCheck&&userNameCheck&&phoneNumberCheck&&password2Check&&password1Check&&emailCheck&&regionCheck) {
                            attemptSignUp();
                            mSignUpButton.setVisibility(View.GONE);
                            mProgressBar.setVisibility(View.VISIBLE);
                            TextView sign_in_text = findViewById(R.id.sign_in_text_view2);
                            sign_in_text.setVisibility(View.GONE);
                            mSignInLabel.setVisibility(View.GONE);
                            try {
                                // Simulate network access.
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            finishSignUpAction();
                        } else {
                            Toast.makeText(getApplicationContext(), mInputControle.getText(), Toast.LENGTH_SHORT).show();
                            mInputControle.setVisibility(View.VISIBLE);
                            mUserNameControl.setVisibility(View.VISIBLE);
                            mEmailControl.setVisibility(View.VISIBLE);
                            mPassword1Control.setVisibility(View.VISIBLE);
                            mAgeControl.setVisibility(View.VISIBLE);
                            mPhoneNumberControl.setVisibility(View.VISIBLE);
                            mRegionControl.setVisibility(View.VISIBLE);
                            final View scroll=(ScrollView)findViewById(R.id.scroll_sign_up);
                            scroll.scrollTo(ScrollView.SCROLL_INDICATOR_BOTTOM, ScrollView.SCROLL_INDICATOR_BOTTOM);
                        }
                        break;
                }
                return false;
            }
        });

        mSignInLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptBack();
            }
        });

        /**1
         * Let's check some inputs.
         * **/
        // Add check control handlers (listeners)
        checkUserName();
        checkPhoneNumber();
        checkEmail();
        checkPassWord();
        checkRegion();
        checkAge();
        /**
         * *****/

    }

    private void defineViews() {

        /**
         * Define all views in sign up form.
         **/

        mUserName = (EditText)findViewById(R.id.name_sign_up);
        mPhoneNumber = (EditText)findViewById(R.id.phone_number_sign_up);
        mEmail = (EditText)findViewById(R.id.email_sign_up);
        mPassword1 = (EditText)findViewById(R.id.pass_word_sign_up);
        mPassword2 = (EditText)findViewById(R.id.confirm_pass_word_sign_up);
        mWilayaSpinner = (Spinner)findViewById(R.id.spinner_wilaya);
        mRegion = (EditText)findViewById(R.id.add_region_sign_up);
        mSexSpinner = (Spinner)findViewById(R.id.spinner_sex);
        mAge = (Spinner) findViewById(R.id.spinner_age);
        mBloodCategory = (Spinner)findViewById(R.id.spinner_blood1);
        mBloodRisus = (Spinner)findViewById(R.id.spinner_blood2);
        mSignInLabel = findViewById(R.id.sign_in_text_view);

        // Button Views

        mBackButton = findViewById(R.id.back_to_main);
        mSignUpButton = findViewById(R.id.sign_up_btn);

        // Control labels Views
        mUserNameControl = findViewById(R.id.name_sign_up_control);
        mPhoneNumberControl = findViewById(R.id.phone_number_sign_up_control);
        mEmailControl = findViewById(R.id.email_sign_up_control);
        mPassword1Control = findViewById(R.id.password_sign_up_control);
        mPassword2Control = findViewById(R.id.password2_sign_up_control);
        mRegionControl = findViewById(R.id.region_sign_up_control);
        mAgeControl = findViewById(R.id.age_sign_up_control);
        mInputControle = findViewById(R.id.pleasecheckout);
        mProgressBar = (ProgressBar)findViewById(R.id.signup_progress);


        /**
         * **/
    }

    /**
     * Attempts register the account specified by the sign up form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual sign up attempt is made.
     */

    private void attemptSignUp() {

        // Store values at the time of the sign up
        final String userName = mUserName.getText().toString();
        final String phoneNumber = mPhoneNumber.getText().toString();
        final String email = mEmail.getText().toString();
        String passWord = mPassword1.getText().toString();
        String passWordConfirmation = mPassword2.getText().toString();
        final String wilaya = mWilayaSpinner.getSelectedItem().toString();
        final String region = mRegion.getText().toString();
        final String sex = mSexSpinner.getSelectedItem().toString();
        final String age = mAge.getSelectedItem().toString();
        final String bloodCategory = mBloodCategory.getSelectedItem().toString();
        final String bloodRH = mBloodRisus.getSelectedItem().toString();

        // Create a new firebase user
        mAuth.createUserWithEmailAndPassword(email, passWord)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success");
                            FirebaseUser firebaseUser = mAuth.getCurrentUser();
                            User user = new User(userName,phoneNumber,email,wilaya,region,sex,age,bloodCategory,bloodRH);
                            database.child("Users").child(firebaseUser.getUid()).setValue(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void checkUserName() {
        mUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // User name control here
                userNameCheck=false;

                int control=0;

                String[] badChar = new String[] {"*", "-", "/", "+", ",", ";",
                        ":", "!", "?", "%", "\"", "\'", "\\", "/",
                        "(", ")", "{", "}", "[", "]", "@", "_", "&",
                        "#", "^", "=", ".", "*", "°", "$", "£", "<", ">",
                        "|"};

                mUserNameControl.setTextColor(getResources().getColor(R.color.colorPrimary));

                for (String character : badChar) {
                    if(editable.toString().contains(character.toString())) {
                        control=1;
                        mUserNameControl.setVisibility(View.VISIBLE);
                        mUserNameControl.setText("*لا يجب أن يحتوي إسم المستخدم على الرموز و الأرقام");
                        break;
                    }
                }

                if(control==0) {
                    if(editable.toString().matches(".*\\d.*") && editable.length() != 0) {

                        mUserNameControl.setVisibility(View.VISIBLE);
                        mUserNameControl.setText("*لا يجب أن يحتوي إسم المستخدم على الرموز و الأرقام");

                    } else if(editable.length() < 4 && editable.length() != 0) {

                        mUserNameControl.setVisibility(View.VISIBLE);
                        mUserNameControl.setText("*الإسم قصير جدا");

                    } else if(editable.length() == 0) {

                        mUserNameControl.setVisibility(View.VISIBLE);
                        mUserNameControl.setText("*يجب إدخال إسم المستخدم");

                    } else if(!editable.toString().matches(".*\\S\\s\\S.*") && editable.length() != 0) {

                        mUserNameControl.setVisibility(View.VISIBLE);
                        if(editable.toString().contains("  ")) {
                            mUserNameControl.setText("*إسم المستخدم يحتوي على العديد من الفراغات");
                        } else {
                            mUserNameControl.setText("*يجب أن يحتوي إسم المستخدم على الإسم و اللقب");
                        }

                    } else {
                        // All right
                        mUserNameControl.setTextColor(getResources().getColor(R.color.colorAccent));
                        mUserNameControl.setText("✓ إسم المستخدم صالح");
                        userNameCheck=true;
                    }
                }
            }
        });
    }

    private void checkPhoneNumber() {
        mPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Phone number control here
                phoneNumberCheck=false;
                mPhoneNumberControl.setTextColor(getResources().getColor(R.color.colorPrimary));
                if((editable.toString().length() == 0) || (editable.length() > 10) || (editable.length() < 9)) {
                    mPhoneNumberControl.setVisibility(View.VISIBLE);
                    mPhoneNumberControl.setText("*الرجاء التأكد من رقم الهاتف");
                    // 0797417330
                } else {
                    // Must check data base.
                    /**
                     * Data base check.
                     * **/
                    mPhoneNumberControl.setTextColor(getResources().getColor(R.color.colorAccent));
                    mPhoneNumberControl.setVisibility(View.VISIBLE);
                    mPhoneNumberControl.setText("✓ رقم الهاتف صحيح و غير مستعمل");
                    phoneNumberCheck=true;
                }
            }
        });
    }

    private void checkEmail() {
        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Email control here
                emailCheck=false;
                mEmailControl.setTextColor(getResources().getColor(R.color.colorPrimary));
                mEmailControl.setVisibility(View.VISIBLE);

                if(editable.length() == 0) {
                    mEmailControl.setText("*حقل البريد الإلكتروني إجباري");
                } else if(!editable.toString().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
                    mEmailControl.setText("*البريد الإلكتروني غير صالح");
                } else {
                    mEmailControl.setTextColor(getResources().getColor(R.color.colorAccent));
                    mEmailControl.setText("✓ البريد الإلكتروني صالح");
                    emailCheck=true;
                }
            }
        });
    }

    private void checkPassWord() {

        mPassword1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                /****
                 * Second password field check
                 */

                mPassword2Control.setTextColor(getResources().getColor(R.color.colorPrimary));
                if (!mPassword2.getText().toString().equals(editable.toString())) {
                    mPassword2Control.setText("*كلمة السر غير مطابقة");
                    password2Check=false;
                } else {
                    mPassword2Control.setTextColor(getResources().getColor(R.color.colorAccent));
                    mPassword2Control.setText("✓ كلمةالسر مطابقة تماما");
                    password2Check=true;
                }

                /**
                 *
                 * **/


                // Password control here
                password1Check=false;
                mPassword1Control.setVisibility(View.VISIBLE);
                mPassword1Control.setTextColor(getResources().getColor(R.color.colorPrimary));
                if(editable.length() == 0) {
                    mPassword1Control.setText("*كلمة السر إجبارية");
                } else if(editable.length() < 5) {
                    mPassword1Control.setText("*كلمة السر ضعيفة جدا");
                } else if(editable.length() > 5 && editable.toString().matches("[\\w]*")) {
                    mPassword1Control.setTextColor(getResources().getColor(R.color.colorAccent));
                    mPassword1Control.setText("✓ كلمة السر متوسطة");
                    password1Check=true;
                } else if(editable.length() > 6 && editable.toString().matches("(.*)([\\w]*)[\\W]([\\w]*)(.*)")) {
                    mPassword1Control.setTextColor(getResources().getColor(R.color.colorAccent));
                    mPassword1Control.setText("✓ كلمة السر قوية");
                    password1Check=true;
                }
            }
        });

        mPassword2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Password confirmation control here
                password2Check=false;
                mPassword2Control.setVisibility(View.VISIBLE);
                mPassword2Control.setTextColor(getResources().getColor(R.color.colorPrimary));
                if (!mPassword1.getText().toString().equals(editable.toString())) {
                    mPassword2Control.setText("*كلمة السر غير مطابقة");
                } else {
                    mPassword2Control.setTextColor(getResources().getColor(R.color.colorAccent));
                    mPassword2Control.setText("✓ كلمةالسر مطابقة تماما");
                    password2Check=true;
                }
            }
        });
    }

    private void checkRegion() {
        mRegion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Region control here
                regionCheck=false;
                /**
                 * User can put what ever he wants.
                 * **/
                // ...
                mRegionControl.setVisibility(View.VISIBLE);
                mRegionControl.setTextColor(getResources().getColor(R.color.colorPrimary));
                if(editable.length() == 0) {
                    mRegionControl.setText("*الرجاء التأكد من الدائرة");
                } else {
                    mRegionControl.setTextColor(getResources().getColor(R.color.colorAccent));
                    mRegionControl.setText("✓ الحقل مناسب ");
                    regionCheck=true;
                }
            }
        });
    }


    private void checkAge() {
        mAge.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Age control here
                ageCheck=false;
                mAgeControl.setVisibility(View.VISIBLE);
                mAgeControl.setTextColor(getResources().getColor(R.color.colorPrimary));
                if(mAge.getSelectedItem().toString().contains("أقل")) {
                    mAgeControl.setText("*العمر غير مناسب للتبرع آسفون");
                } else {
                    mAgeControl.setTextColor(getResources().getColor(R.color.colorAccent));
                    mAgeControl.setText("✓ العمر مناسب للتبرع");
                    ageCheck=true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void finishSignUpAction() {
        // After sign up, go to main activity

        AlertDialog signUpSuccessDialog = new AlertDialog.Builder(SignUpActivity.this).create();
        signUpSuccessDialog.setTitle("تم التسجيل");
        signUpSuccessDialog.setMessage("✓ مبارك لقد تم التسجيل بنجاح في تطبيق دمي و يمكنك الآن متابعة التبرعات بالدم في كل أرجاء الوطن.");
        signUpSuccessDialog.setIcon(R.drawable.ic_assignment_turned_in_black_24dp);
        signUpSuccessDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "موافق",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent mainIntent = new Intent(SignUpActivity.this,MainActivity.class);
                        startActivity(mainIntent);
                        finish();
                    }
                });
        signUpSuccessDialog.show();

    }

    private void attemptBack() {
        Intent mainIntent = new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(mainIntent);
        finish();
    }
}
