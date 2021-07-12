package com.example.alroha.wish;

public class Wish {
    private String contents;
    private boolean checked;

    public Wish(String contents, boolean checked) {
        this.contents = contents;
        this.checked = checked;
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
