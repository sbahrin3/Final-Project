package com.example.pc05.AplikasiPermarkahanPelajar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ViewDeleteActivity extends AppCompatActivity {

    EditText noMatrik;
    Spinner sKohort,sSem;
    Button bView,bDelete,bHome;
    DatabaseHelper myDb;



    protected void onCreate (Bundle savedInstanceSaved) {
        super.onCreate(savedInstanceSaved);
        setContentView(R.layout.viewdeletelayout);
        myDb = new DatabaseHelper(this);

        noMatrik = (EditText)findViewById(R.id.noMatrik);
        bView =(Button)findViewById(R.id.bView);
        bDelete =(Button)findViewById(R.id.bDelete);
        bHome =(Button)findViewById(R.id.bHome);

        bHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(),
                        homepensyarahactivity.class);
                startActivity(home);
            }
        });

        view();
        delete();
    }

    public void view() {
        bView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = myDb.getAllData();
                if(result.getCount()==0){
                    showMessage("Error", "No Data Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext()) {
                    buffer.append("No Matrik : "+result.getString(0)+"\n");
                    buffer.append("Name : "+result.getString(1)+"\n");
                    buffer.append("Kohort : "+result.getString(2)+"\n");
                    buffer.append("Sem : "+result.getString(3)+"\n\n");

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

    public void delete(){
        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deleterows = myDb.deletedata(noMatrik.getText().toString());

                if(deleterows>0){
                    Toast.makeText(ViewDeleteActivity.this,"Data is Delete",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ViewDeleteActivity.this,"Data is NOT Delete",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
