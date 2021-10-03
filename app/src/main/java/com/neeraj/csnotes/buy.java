package com.neeraj.csnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class buy extends AppCompatActivity {
slideshow adapter;
ViewPager viewPager;
CircleIndicator c;
Timer timer;
Handler handler;
Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        viewPager=findViewById(R.id.v);
        c=findViewById(R.id.cir);
        RecyclerView recyclerView;
        String text[]={"Alpha","Beta","CupCake","Donot"};
        Integer image[]={R.drawable.fish,R.drawable.blue,R.drawable.ad,R.drawable.ba};
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        //hide toolbar
        getSupportActionBar().hide();
        recyclerView=findViewById(R.id.rcv);
        Myadapter myadapter=new Myadapter(this,image,text);
       // StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        //recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myadapter);
        adapter=new slideshow(this);
        viewPager.setAdapter(adapter);
        c.setViewPager(viewPager);
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                int i = viewPager.getCurrentItem();
                if (i == adapter.images.length - 1) {
                    i = 0;
                    viewPager.setCurrentItem(i, true);
                } else {
                    i++;
                    viewPager.setCurrentItem(i, true);
                }

            }
        };
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            handler.post(runnable);
            }
        },4000,4000);

    }
}
