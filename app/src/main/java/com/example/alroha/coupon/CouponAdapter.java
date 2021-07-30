package com.example.alroha.coupon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.alroha.R;
import com.example.alroha.wish.Wish;
import com.example.alroha.wish.WishList;

import java.util.ArrayList;
import java.util.List;

public class CouponAdapter extends BaseAdapter {

    private final List<Coupon> couponList;

    public CouponAdapter(ArrayList<Coupon> couponArrayList) {
        couponList = couponArrayList;
    }

    @Override
    public int getCount() {
        return couponList.size();
    }

    @Override
    public Object getItem(int position) {
        return couponList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();

        if(convertView == null) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.coupon_list, parent, false);
            TextView name = (TextView) convertView.findViewById(R.id.couponName);
            TextView date = (TextView) convertView.findViewById(R.id.createDate);


            holder.name =name;
            holder.date = date;
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Coupon coupon = couponList.get(position);
        holder.name.setText(coupon.getName());
        holder.date.setText(coupon.getDate());


        return convertView;
    }



    static class ViewHolder{
        TextView name;
        TextView date;
    }
}
