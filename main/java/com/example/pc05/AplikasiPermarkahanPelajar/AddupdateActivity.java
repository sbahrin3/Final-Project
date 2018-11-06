package com.example.pc05.AplikasiPermarkahanPelajar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddupdateActivity extends AppCompatActivity {

    Button btntambah,btnkemas,btnumah;
    EditText matrik,name,subject,mark;
    Spinner kohort,sem;
    private DatabaseHelper myDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addupdatelayout);
        myDB = new DatabaseHelper(this);

        matrik =(EditText)findViewById(R.id.Tmatrik);
        name =(EditText)findViewById(R.id.Tname);
        btntambah =(Button)findViewById(R.id.btnAdd);
        btnkemas =(Button) findViewById(R.id.btnUpdate);
        btnumah =(Button) findViewById(R.id.btnHome);
        kohort =(Spinner)findViewById(R.id.tKohort);
        sem =(Spinner)findViewById(R.id.tSem);

        btnumah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(),
                        homepensyarahactivity.class);
                startActivity(home);
            }
        });

        String [] names = {"2015","2016","2017","2018"};
            ArrayAdapter<String> adapter = new
                    ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,names);
            kohort.setAdapter(adapter);

            String [] semester = {"1","2","3","4"};
        ArrayAdapter<String> newadapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,semester);
        sem.setAdapter(newadapter);

        //instantiate
        myDB = new DatabaseHelper(this);
//method to Add data and View
        AddData();
        UpdateData();


    }
    //Add Data
    private void AddData() {
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get text from layout to insert into table
                boolean insertData = myDB.insertData(matrik.getText().toString(), name.getText().toString(),
                        kohort.getSelectedItem().toString(), sem.getSelectedItem().toString());

                if (insertData == true) {
                    //create Toast to alert user
                    Toast.makeText(AddupdateActivity.this, " Data Inserted ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddupdateActivity.this, " Data NOT Inserted ", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    //Update Data
    public void UpdateData() {
        btnkemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean update =myDB.updatedata(matrik.getText().toString(), name.getText().toString(),
                        kohort.getSelectedItem().toString(), sem.getSelectedItem().toString());
                if (update == true) {
                    //create Toast to alert user
                    Toast.makeText(AddupdateActivity.this, " Data Update ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddupdateActivity.this, " Data NOT Update ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}
