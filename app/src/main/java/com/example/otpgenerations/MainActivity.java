package com.example.otpgenerations;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    EditText enternumber;
    Button getotpbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
     enternumber=findViewById(R.id.input_mobile_number);
     getotpbutton=findViewById(R.id.buttongetotp);

        ProgressBar progressBar=findViewById(R.id.progressbar_sending_otp);
        getotpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!enternumber.getText().toString().trim().isEmpty())

                {
                    if((enternumber.getText().toString().trim()).length()==10)
                    {

                        progressBar.setVisibility(view.VISIBLE);
                        getotpbutton.setVisibility(view.INVISIBLE);
                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + enternumber.getText().toString(), 60,
                                TimeUnit.SECONDS, MainActivity.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        progressBar.setVisibility(view.VISIBLE);
                                        getotpbutton.setVisibility(view.INVISIBLE);
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(view.VISIBLE);
                                        getotpbutton.setVisibility(view.INVISIBLE);
                                        Toast.makeText(MainActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        progressBar.setVisibility(view.VISIBLE);
                                        getotpbutton.setVisibility(view.INVISIBLE);

                        Intent intent=new Intent(getApplicationContext(),Verifyenterotptwo.class);
                        intent.putExtra("mobile",enternumber.getText().toString());
                        intent.putExtra("backendotp",backendotp);
                       startActivity(intent);
                                    }
                                }


                        );



                    }
                    else {
                        Toast.makeText(MainActivity.this, "Please enter correct number", Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Enter Mobile number", Toast.LENGTH_SHORT).show();
                }
            }
        });


















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}