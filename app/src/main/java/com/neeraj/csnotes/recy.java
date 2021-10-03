package com.neeraj.csnotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
public class recy extends AppCompatActivity{
    EditText e,e1;
    Button b,b1;
    database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy);
        e=findViewById(R.id.user);
        e1=findViewById(R.id.pas);
        b=findViewById(R.id.b);
        b1=findViewById(R.id.b1);
        db=new database(this);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        //hide toolbar
        getSupportActionBar().hide();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=e.getText().toString().trim();
                String pass=e1.getText().toString().trim();
                Boolean res=db.checkUser(user,pass);
                if(res==true)
                {
                    Toast.makeText(recy.this,"Login sucess",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(recy.this,seco.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(recy.this,"try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(recy.this,signup.class);
                startActivity(i);
            }
        });
}
}
