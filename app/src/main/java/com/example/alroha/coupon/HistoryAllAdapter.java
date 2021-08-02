package com.example.alroha.coupon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alroha.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryAllAdapter extends BaseAdapter {

    private final List<HistoryCoupon> historyCoupon ;


    public HistoryAllAdapter(ArrayList<HistoryCoupon> historyCouponArrayList) {
        historyCoupon = historyCouponArrayList;
    }

    @Override
    public int getCount() {
        return historyCoupon.size();
    }

    @Override
    public Object getItem(int position) {
        return historyCoupon.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();

//        if(convertView == null) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.coupon_history_all_list, parent, false);

            TextView name =(TextView)  convertView.findViewById(R.id.all_history_title);
            TextView useMember =(TextView)  convertView.findViewById(R.id.all_history_use);


            holder.title =name;
            holder.useMember = useMember;

//        }else{
//            holder = (ViewHolder) convertView.getTag();
//        }


        HistoryCoupon coupon = historyCoupon.get(position);
        holder.title.setText(coupon.getTitle());
        holder.useMember.setText(coupon.getUseMember());


        return convertView;
    }



    static class ViewHolder{
        TextView title;
        TextView useMember;

    }
}
