package com.karuppiah.bringit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {

    private ArrayList<Food> food;
    private LayoutInflater foodInf;

    public FoodAdapter(Context c, ArrayList<Food> food) {
        this.food = food;
        foodInf = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return food.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout foodLay = (LinearLayout) foodInf.inflate(R.layout.food, parent, false);

        TextView foodNameView = (TextView) foodLay.findViewById(R.id.food_name);
        TextView priceView = (TextView) foodLay.findViewById(R.id.food_price);

        Food currfood = food.get(position);

        foodNameView.setText(currfood.getNamet());
        priceView.setText("" + currfood.getPrice());

        foodLay.setTag(position);
        foodNameView.setTag(position);
        priceView.setTag(position);


        return foodLay;
    }
}
