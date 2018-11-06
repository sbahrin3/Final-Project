package com.example.pc05.AplikasiPermarkahanPelajar;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.homelayout );

        Button btnhomePensyarah,btnhomePelajar,btnkiraMarkah;

        btnhomePensyarah = (Button)findViewById ( R.id.btnPensyarah );
        btnhomePelajar = (Button)findViewById ( R.id.btnPelajar );
        btnkiraMarkah = (Button)findViewById ( R.id.btnMarkah );

        btnhomePensyarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create object calculator from class Intent
                Intent pensyarah = new Intent(getApplicationContext(),
                        loginactivity.class);
                startActivity(pensyarah);
            }
        });

        btnhomePelajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create object calculator from class Intent
                Intent pelajar = new Intent(getApplicationContext(),
                        homepelajaractivity.class);
                startActivity(pelajar);
            }
        });

        btnkiraMarkah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create object calculator from class Intent
                Intent kirakira = new Intent(getApplicationContext(),
                        MarkahPActivity.class);
                startActivity(kirakira);
            }
        });


    }
}
