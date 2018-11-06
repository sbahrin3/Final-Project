package com.example.pc05.AplikasiPermarkahanPelajar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginactivity extends AppCompatActivity {

    Button B1,Home;
    EditText user,pass;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.loginlayout );

        B1=(Button)findViewById(R.id.bLogin);
        user=(EditText)findViewById(R.id.idUser);
        pass=(EditText)findViewById(R.id.idPassword);
        Home = (Button)findViewById(R.id.bHome);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(home);
            }
        });

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user.getText().toString();
                String mystring1 ="Admin";
                String mystring3 ="Amirul";
                String password = pass.getText().toString();
                String mystring2 ="Admin";
                String mystring4 ="1234";


                if(username.equals(mystring1)||username.equals(mystring3)&& password.equals(mystring2)|| password.equals(mystring4)){
                    String mystringz = " Your login is successfully";
                    Intent intent = new Intent(getApplicationContext(),homepensyarahactivity.class);
                    startActivity(intent);

                }

                else {
                    String mystringx = " Username and password are incorrect";
                    Toast toast = Toast.makeText(getApplicationContext(),mystringx,Toast.LENGTH_SHORT);
                    toast.show();

                }



            }
        });
    }



}