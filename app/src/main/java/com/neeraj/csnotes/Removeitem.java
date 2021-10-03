package com.neeraj.csnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Removeitem extends AppCompatActivity {
Button b;
EditText e;
productdb productdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_removeitem);
        b=findViewById(R.id.item);
        e=findViewById(R.id.pro);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        productdb=new productdb(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(e.getText().toString());
                long result=productdb.deleteRecords(id);
                if(result>0)
                {
                    Toast.makeText(Removeitem.this,"Record Deleted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Removeitem.this,"Invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
