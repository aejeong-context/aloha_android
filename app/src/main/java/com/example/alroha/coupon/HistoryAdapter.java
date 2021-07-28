package com.example.alroha.coupon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alroha.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView useMember;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.historyTitle);
            useMember = (TextView) itemView.findViewById(R.id.historyUserMember);
        }
    }

    private ArrayList<HistoryCoupon> historyCouponArrayList = new ArrayList<>();

    public HistoryAdapter(ArrayList<HistoryCoupon> historyCouponArrayList) {
        this.historyCouponArrayList = historyCouponArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.coupon_history_list,parent,false);
        HistoryAdapter.ViewHolder viewHolder = new HistoryAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  HistoryAdapter.ViewHolder holder, int position) {
        HistoryCoupon item = historyCouponArrayList.get(position);

        holder.title.setText(item.getTitle());
        holder.useMember.setText(item.getUseMember());

    }

    @Override
    public int getItemCount() {
        return historyCouponArrayList.size();
    }


}
