package com.neeraj.csnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
Button b;
EditText e,e1,e2;
database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        database=new database(this);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        //hide toolbar
        getSupportActionBar().hide();
       b = findViewById(R.id.b);
        e=findViewById(R.id.e);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=e.getText().toString();
                String password=e1.getText().toString();
                int mobile_no= Integer.parseInt(e2.getText().toString());
                    user s=new user(username,password,mobile_no);
                    long result=database.insertRecord(s);
                    if(result>0)
                    {
                        Toast.makeText(signup.this,"Data saved",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(signup.this,"Data not saved",Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }
}
