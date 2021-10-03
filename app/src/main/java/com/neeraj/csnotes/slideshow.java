package com.neeraj.csnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

public class slideshow extends PagerAdapter {
private Context context;
LayoutInflater inflater;

public int[] images={
      R.drawable.blue,
      R.drawable.fish,
      R.drawable.cute,
      R.drawable.grand,
      R.drawable.grass,
      R.drawable.peacock,
      R.drawable.puffin,
};
public slideshow(Context context)
{
    this.context=context;
}

    @Override
    public int getCount() {

        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return(view==(LinearLayout)object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    container.removeView((LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
    inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view=inflater.inflate(R.layout.slideshow,container,false);
        ImageView im=view.findViewById(R.id.i);
        Glide.with(context).load(images[position]).into(im);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"image"+(position+1),Snackbar.LENGTH_LONG).show();
            }
        });
        container.addView(view);
        return view;
    }
}
