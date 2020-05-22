package com.codehub.marvelheroapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    TextView registernow;

    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        final EditText e1,e2;

        Button b1;
        final Database db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Database(this);
        e1 = (EditText)findViewById(R.id.username);
        e2 = (EditText)findViewById(R.id.pass);
        b1 = (Button)findViewById(R.id.login_button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean chkemailpass = db.emailpassword(username,password);
                if(chkemailpass==true) {
                    Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong username or password",Toast.LENGTH_SHORT).show();
                }
                gotoNextScreen();
            }
        });

        registernow=(TextView)findViewById(R.id.register_now);
        registernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoNextScreen();
            }
        });
    }

    private void gotoNextScreen() {
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }


}
