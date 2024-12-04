package com.example.otpgenerations;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Verifyenterotptwo extends AppCompatActivity {
EditText inputotp1,inputotp2,inputotp3,inputotp4,inputotp5,inputotp6;
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

        verifybuttonclick.setOnClickListener(view ->{


            if(!inputotp1.getText().toString().trim().isEmpty()&&!inputotp2.getText().toString().trim().isEmpty()&&!inputotp3.getText().toString().trim().isEmpty()&&!inputotp4.getText().toString().trim().isEmpty()&&!inputotp5.getText().toString().trim().isEmpty()&&!inputotp6.getText().toString().trim().isEmpty()&&!inputotp1.getText().toString().trim().isEmpty())
            {
                Toast.makeText(Verifyenterotptwo.this, "Otp verify", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(Verifyenterotptwo.this, "Please enter all numberthis", Toast.LENGTH_SHORT).show();
            }
            });
        numbertomove();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


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