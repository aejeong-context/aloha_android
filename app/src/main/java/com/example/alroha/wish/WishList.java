package com.example.alroha.wish;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.alroha.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class WishList extends BaseAdapter {

    private final List<Wish> wishList;

    public WishList(ArrayList<Wish> wishArrayList) {
        wishList = wishArrayList;
    }

    @Override
    public int getCount() {
        return wishList.size();
    }

    @Override
    public Object getItem(int i) {
        return wishList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = new ViewHolder();

        if(view == null) {

            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wish_list, viewGroup, false);
            TextView content = (TextView) view.findViewById(R.id.wishText);
            RadioButton checked = (RadioButton) view.findViewById(R.id.checked);


            holder.content =content;
            holder.checked = checked;
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Wish wish = wishList.get(i);
        holder.content.setText(wish.getContents());
        holder.checked.setClickable(false);
        holder.checked.setFocusable(false);
        holder.checked.setChecked(wish.isChecked());


        return view;
    }



    static class ViewHolder{
        TextView content;
        RadioButton checked;
    }
}
