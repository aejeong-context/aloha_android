package com.example.alroha.wish;

public class Wish {
    private String contents;
    private boolean checked;
    private String completeDate;

    public Wish(String contents, boolean checked, String completeDate) {
        this.contents = contents;
        this.checked = checked;
        this.completeDate = completeDate;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
