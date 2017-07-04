package com.example.lugoo.jeff;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lugoo on 2017-7-4.
 */

public class FruitAdapter extends ArrayAdapter {
    private int rescourceId;

    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        rescourceId = resource;
    }
   class ViewHolder{
       ImageView imageView;
       TextView textView;
       TextView textView2;
   }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = (Fruit)getItem(position); //get selected fruit object from list<Fruit>
        View view;
        ViewHolder viewHolder;
        if(convertView != null)
        {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        else
        {
            view = LayoutInflater.from(getContext()).inflate(rescourceId,null);//get selected view
            viewHolder = new ViewHolder();
            viewHolder.imageView =  (ImageView)view.findViewById(R.id.Fruit_image);
            viewHolder.textView = (TextView)view.findViewById(R.id.Fruit_name);
            viewHolder.textView2 = (TextView)view.findViewById(R.id.Fruit_name2);
            view.setTag(viewHolder);
        }
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
        viewHolder.textView2.setText(fruit.getName());
        return view;
    }
}
