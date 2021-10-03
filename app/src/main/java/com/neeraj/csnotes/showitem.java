package com.neeraj.csnotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class showitem extends AppCompatActivity {
    Button gen;
    ListView li;
    ArrayAdapter arrayAdapter;
    List<product> allproduct;
    ArrayList<String> a;
    Spinner s1;
    productdb productdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showitem);
        s1=findViewById(R.id.s1);
       productdb=new productdb(this);
       gen=findViewById(R.id.gen);
       gen.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              

           }
       });
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
       allproduct=productdb.getAllRecord();
       a=new ArrayList<>();
       if(allproduct.size()>0) {
           for (int i = 0; i < allproduct.size(); i++) {
               product product = allproduct.get(i);
               a.add(product.getId()+"            "+product.getName()+"           "+product.getDate()+"           "+product.getPrice());
           }
       }
       li=findViewById(R.id.li);
       arrayAdapter=new ArrayAdapter(showitem.this,android.R.layout.simple_list_item_1,a);
       li.setAdapter(arrayAdapter);
       s1.setAdapter(arrayAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.my,menu);
        return true;
    }
}
