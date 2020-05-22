package com.codehub.marvelheroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Database db;
    EditText e1,e2,e3,e4,e5,e6;
    Button b1,b2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



//        if (user != null) {
//            finish();
//            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
//        }


        db = new Database(this);
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.surname);
        e3=(EditText)findViewById(R.id.email);
        e4=(EditText)findViewById(R.id.usernamere);
        e5=(EditText)findViewById(R.id.password);
        e6=(EditText)findViewById(R.id.confirmpass);
        b1=(Button)findViewById(R.id.register_button);
        b2=(Button)findViewById(R.id.login_now);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                String s6 = e6.getText().toString();
                if(s3.equals("") || s5.equals("") || s6.equals("") || s1.equals("") || s2.equals("") || s4.equals(""))  {
                    Toast.makeText(getApplicationContext(),"Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(s5.equals(s6)){
                        Boolean chkuser = db.chkuser(s4);
                        Boolean chkemail = db.chkemail(s3);
                        if(chkemail==true && chkuser == true){
                            Boolean insert = db.insert(s3,s5,s4);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(), "Registered Successfully",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Email Already exists",Toast.LENGTH_SHORT).show();
                        }
                    }

                    Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
                }

            }
        });
       // DatabaseHelper db = new DatabaseHelper(this);


    }
}
