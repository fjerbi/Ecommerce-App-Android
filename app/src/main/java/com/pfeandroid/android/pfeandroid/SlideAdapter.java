package com.pfeandroid.android.pfeandroid;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {

   Context context;

   LayoutInflater inflater;
   public int[]lst_images= {
           R.drawable.image_1,
           R.drawable.image_2,
           R.drawable.image_3,
           R.drawable.image_4
   };

//liste des titre

    public String[] lst_title={
            "Cosmetic",
            "Satellite",
            "Contactus",
            "Edited"


    };

    //liste des description
    public String[] lst_description={
            "Description1",
            "Description2",
            "Description3",
            "Description4"
    };

    //liste des background
    public int[] lst_backgroundcolor={
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)

    };
public SlideAdapter(Context context){
    this.context=context;
}
    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view==(LinearLayout)o);
    }





    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide=(LinearLayout)view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide =(ImageView) view.findViewById(R.id.slideimg);
        TextView txttitle=(TextView) view.findViewById(R.id.txttitle);
        TextView description=(TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
container.removeView((LinearLayout)object);
    }
}
