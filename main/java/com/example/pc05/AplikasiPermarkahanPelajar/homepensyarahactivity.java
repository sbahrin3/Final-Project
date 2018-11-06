package com.example.pc05.AplikasiPermarkahanPelajar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class homepensyarahactivity extends AppCompatActivity {

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.homepensyarahlayout );


        Button btnadd,btnview,btnsgout,btnMarkah;

        btnadd = (Button)findViewById(R.id.btnAdd);
        btnview = (Button)findViewById(R.id.btnView);
        btnsgout = (Button)findViewById(R.id.btnOut);
        btnMarkah = (Button)findViewById(R.id.btnMarkah);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addupdate = new Intent(getApplicationContext(),
                        AddupdateActivity.class);
                startActivity(addupdate);

            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewdelete = new Intent(getApplicationContext(),
                        ViewDeleteActivity.class);
                startActivity(viewdelete);
            }
        });

        btnsgout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signout = new Intent(getApplicationContext(),
                        loginactivity.class);
                startActivity(signout);
            }
        });

        btnMarkah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent markah = new Intent(getApplicationContext(),
                        MarkahPActivity.class);
                startActivity(markah);
            }
        });
    }



}