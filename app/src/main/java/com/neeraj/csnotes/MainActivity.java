package com.neeraj.csnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.agrawalsuneet.dotsloader.loaders.LazyLoader;
import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity {
public static int ST=6000;
    LazyLoader l;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=findViewById(R.id.i);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        //hide toolbar
        getSupportActionBar().hide();
        l=findViewById(R.id.l);
        LazyLoader loader = new LazyLoader(this, 30, 20, ContextCompat.getColor(this, R.color.loader_selected),
                ContextCompat.getColor(this, R.color.loader_selected),
                ContextCompat.getColor(this, R.color.loader_selected)
        );
        loader.setAnimDuration(500);
        loader.setFirstDelayDuration(100);
        loader.setSecondDelayDuration(200);
        loader.setInterpolator(new LinearInterpolator());
        l.addView(loader);
     new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               Intent i=new Intent(MainActivity.this,recy.class);
                startActivity(i);
                customType(MainActivity.this,"left-to-right");
                finish();
            }
        },ST);
    }

}

