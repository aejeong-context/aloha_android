package com.example.alroha.coupon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alroha.R;

import java.util.ArrayList;

public class Fragment4 extends Fragment {

    ViewGroup viewGroup;
    RecyclerView recyclerView;
    ArrayList<HistoryCoupon> historyCouponArrayList;
    ArrayList<HistoryCoupon> apiResponse;
    HistoryAdapter historyAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        historyCouponArrayList = new ArrayList<>();
        apiResponse = new ArrayList<>();

        historyCouponArrayList.add(new HistoryCoupon("욕먹기","지수"));
        historyCouponArrayList.add(new HistoryCoupon("한대 맞기","지수"));
        historyCouponArrayList.add(new HistoryCoupon("엉덩이 맞기","지수"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment4, container, false);
       historyAdapter = new HistoryAdapter(historyCouponArrayList);
       recyclerView = (RecyclerView) viewGroup.findViewById(R.id.historyCouponList);
       recyclerView.setAdapter(historyAdapter);
       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(),RecyclerView.HORIZONTAL,false));


        return viewGroup;
    }
}
