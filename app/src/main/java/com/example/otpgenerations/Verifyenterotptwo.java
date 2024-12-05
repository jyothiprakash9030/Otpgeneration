package com.example.otpgenerations;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Verifyenterotptwo extends AppCompatActivity {
EditText inputotp1,inputotp2,inputotp3,inputotp4,inputotp5,inputotp6;
String getoptbackend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verifyenterotptwo);
        Button verifybuttonclick=findViewById(R.id.buttongetsubmit);


        inputotp1=findViewById(R.id.inputotp1);
        inputotp2=findViewById(R.id.inputotp2);
        inputotp3=findViewById(R.id.inputotp3);
        inputotp4=findViewById(R.id.inputotp4);
        inputotp5=findViewById(R.id.inputotp5);
        inputotp6=findViewById(R.id.inputotp6);
        TextView textView=findViewById(R.id.textmobileshownumber);

        textView.setText(String.format("+91-%s",getIntent().getStringExtra("mobile")));

        getoptbackend=getIntent().getStringExtra("backend");
        ProgressBar progressBarverifyotp=findViewById(R.id.verifyotp);
        verifybuttonclick.setOnClickListener(view ->{


            if(!inputotp1.getText().toString().trim().isEmpty()&&!inputotp2.getText().toString().trim().isEmpty()&&!inputotp3.getText().toString().trim().isEmpty()&&!inputotp4.getText().toString().trim().isEmpty()&&!inputotp5.getText().toString().trim().isEmpty()&&!inputotp6.getText().toString().trim().isEmpty()&&!inputotp1.getText().toString().trim().isEmpty())
            {
                String entercodeotp=inputotp1.getText().toString()+
                        inputotp2.getText().toString()+
                        inputotp3.getText().toString()+
                        inputotp4.getText().toString()+
                        inputotp5.getText().toString()+
                        inputotp6.getText().toString();
                if(getoptbackend!=null)
                {
                    progressBarverifyotp.setVisibility(view.VISIBLE);
                    verifybuttonclick.setVisibility(view.INVISIBLE);
                    PhoneAuthCredential phoneAuthCredential= PhoneAuthProvider.getCredential(getoptbackend,entercodeotp);
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBarverifyotp.setVisibility(view.VISIBLE);
                            verifybuttonclick.setVisibility(view.INVISIBLE);
                            if(task.isSuccessful())
                            {
                                Intent intent=new Intent(getApplicationContext(),Dashboard.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(Verifyenterotptwo.this, "Please correct otp", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(this, "Please check  internet connection", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(Verifyenterotptwo.this, "Otp verify", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(Verifyenterotptwo.this, "Please enter all numberthis", Toast.LENGTH_SHORT).show();
            }
            });
        numbertomove();







        TextView resedlabel=findViewById(R.id.textresendotp);
        resedlabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 
                 
                                         PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                                 "+91" + getIntent().getStringExtra("mobile"), 60,
                                                 TimeUnit.SECONDS, Verifyenterotptwo.this,
                                                 new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                                     @Override
                                                     public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {


                                                     }

                                                     @Override
                                                     public void onVerificationFailed(@NonNull FirebaseException e) {


                                                         Toast.makeText(Verifyenterotptwo.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                                                     }

                                                     @Override
                                                     public void onCodeSent(@NonNull String newbackendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                                                                     getoptbackend=newbackendotp;
                                                         Toast.makeText(Verifyenterotptwo.this, "Resend otp sucessfully", Toast.LENGTH_SHORT).show();





                                                     }
                                                 }


                                         );



















         ///////////////////////
            }
        });

    }

    private void numbertomove()
    {
        inputotp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2)
            {
                  if(!s.toString().trim().isEmpty())
                  {
                      inputotp2.requestFocus();
                  }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputotp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2)
            {
                if(!s.toString().trim().isEmpty())
                {
                    inputotp3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputotp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2)
            {
                if(!s.toString().trim().isEmpty())
                {
                    inputotp4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputotp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2)
            {
                if(!s.toString().trim().isEmpty())
                {
                    inputotp5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        inputotp5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2)
            {
                if(!s.toString().trim().isEmpty())
                {
                    inputotp6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}