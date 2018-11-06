package com.example.pc05.AplikasiPermarkahanPelajar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class homepelajaractivity extends AppCompatActivity{
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.homepelajarlayout );

        Button btnback,btnSubmit;
        EditText editNoMatrik;
        Spinner spinnerKohort,spinnerSem;

        btnback = (Button)findViewById(R.id.btnBack);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(back);
            }
        });

    }
}