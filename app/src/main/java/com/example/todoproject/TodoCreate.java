package com.example.todoproject;

import java.util.Date;

public class TodoCreate {

    private int todoID;
    private String todoTitle;
    private String todoDetail;
    private Date todoDate;
    private boolean todoIsComplete;
    private boolean todoIsPending;


    // variables for updating todos within the first fragment - not recycler list.
    public int getId() { return todoID; }
    public String getDetail() { return todoDetail; }
    public Date getDate() { return todoDate; }
    // these two variables are for changing the checkboxes in the first fragment
    public boolean isComplete() { return todoIsComplete; }
    public boolean isPending() { return todoIsPending; }



    // todorepo usages for creating setting and adding new todos.
    public void setID(int todointID) { this.todoID = todointID; }

    public String getTitle() { return todoTitle; }

    public void setTitle(String title) { this.todoTitle = title; }


    public void setDetail(String detail) { this.todoDetail = detail; }


    public void setDate (Date date) { this.todoDate = date; }


    public void setIsComplete(boolean isComplete) {this.todoIsComplete = isComplete; }

    public void setIsPending(boolean isPending) {this.todoIsPending = isPending; }


}
