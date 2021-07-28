package com.example.alroha.coupon;

public class HistoryCoupon {
    private String title;
    private String useMember;

    public HistoryCoupon(String title, String useMember) {
        this.title = title;
        this.useMember = useMember;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUseMember() {
        return useMember;
    }

    public void setUseMember(String useMember) {
        this.useMember = useMember;
    }
}
