package com.example.assignment1.Model;

public class ToDo {
    private String note_title;
    private String note_details;

    public ToDo(String note_title, String note_details) {
        this.note_title = note_title;
        this.note_details = note_details;
    }

    public String getNote_title() {
        return note_title;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }

    public String getNote_details() {
        return note_details;
    }

    public void setNote_details(String note_details) {
        this.note_details = note_details;
    }
}
