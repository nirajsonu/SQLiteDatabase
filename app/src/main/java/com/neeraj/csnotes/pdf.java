package com.neeraj.csnotes;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


public class pdf extends AppCompatActivity{
    EditText e,e1,e2,e3;
    Button b;
    productdb productdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        e=findViewById(R.id.product);
        e1=findViewById(R.id.product_name);
        e2=findViewById(R.id.product_date);
        e3=findViewById(R.id.price);
        b=findViewById(R.id.add);
        productdb=new productdb(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pid=Integer.parseInt(e.getText().toString());
                String pname=e1.getText().toString();
                String date = e2.getText().toString();
                double price= Double.parseDouble(e3.getText().toString());
                product p=new product(pid,pname,date,price);
                long result=productdb.insertRecord(p);//to store result into long variable for traking purpose.
                if(result>0)
                {
                    Toast.makeText(pdf.this,"Data saved",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(pdf.this,"Data not saved",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}