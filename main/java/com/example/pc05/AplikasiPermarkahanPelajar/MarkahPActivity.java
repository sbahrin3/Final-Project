package com.example.pc05.AplikasiPermarkahanPelajar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MarkahPActivity extends AppCompatActivity {

    Button btnCheckin,btnView,btnUpdate,btnDelete,btnBack;
    EditText idMarkah,NoMatrik,markah,subjek;
    DatabaseHelper myDB;

    protected void onCreate(final Bundle savedInstanceState) {



        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.markahlayout );
        myDB = new DatabaseHelper(this);

        btnCheckin = (Button)findViewById(R.id.bCheckin);
        btnView = (Button)findViewById(R.id.bView);
        btnUpdate = (Button)findViewById(R.id.bUpdate);
        btnDelete = (Button)findViewById(R.id.bDelete);
        btnBack = (Button)findViewById(R.id.btnBack);
        idMarkah = (EditText)findViewById(R.id.idMarkah);
        NoMatrik = (EditText)findViewById(R.id.noMatrik);
        markah = (EditText)findViewById(R.id.markah);
        subjek = (EditText)findViewById(R.id.subjek);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent balik = new Intent(getApplicationContext(),
                        homepensyarahactivity.class);
                startActivity(balik);
            }
        });


        tambah();
        papar();
        kemas();
        padam();
    }
     public void tambah() {
        btnCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean masukdata = myDB.masukdata(NoMatrik.getText().toString(), markah.getText().toString(),
                        subjek.getText().toString());

                if (masukdata == true) {
                    //create Toast to alert user
                    Toast.makeText(MarkahPActivity.this, " Data Inserted ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MarkahPActivity.this, " Data NOT Inserted ", Toast.LENGTH_SHORT).show();
                }
            }

        });
     }

    public void papar() {
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = myDB.dapatsemuadata();
                if(result.getCount()==0){
                    showMessage("Error", "No Data Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext()) {
                    buffer.append("Id_Markah : "+result.getString(0)+"\n");
                    buffer.append("No_Matrik : "+result.getString(1)+"\n");
                    buffer.append("Markah : "+result.getString(2)+"\n");
                    buffer.append("Subjek : "+result.getString(3)+"\n\n");

                }
                //show all data
                showMessage("All Data",buffer.toString());
            }
        });
    }

    public  void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

    public void kemas() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean kemasdata =myDB.kemasdata(idMarkah.getText().toString(), NoMatrik.getText().toString(),
                        markah.getText().toString(), subjek.getText().toString());
                if (kemasdata == true) {
                    //create Toast to alert user
                    Toast.makeText(MarkahPActivity.this, " Data Update ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MarkahPActivity.this, " Data NOT Update ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void padam() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int padamdata = myDB.padamdata(idMarkah.getText().toString());

                if(padamdata>0){
                    Toast.makeText(MarkahPActivity.this,"Data is Delete",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MarkahPActivity.this,"Data is NOT Delete",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
