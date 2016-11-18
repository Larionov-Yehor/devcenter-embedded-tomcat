package model;

import java.time.LocalDate;

/**
 * Created by employee on 11/15/16.
 */
public class Task {

    private int id;
    private String title;
    private String description;
    private boolean state = false;
    private LocalDate date;
    private int listId;


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void markAsDone(){
        this.state = true;
    }


    public boolean getStatus() {
        return state;
    }

    public int getStateForSql(){
        if(getStatus()==true){
        return 1;
        }
        return 0;
    }

    public static boolean setStateFromSql(int tinyInt){
        if(tinyInt==1){
        return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTaskDueDate() {
        return date;
    }

    public void setTaskDueDate(LocalDate taskDueDate) {
        this.date = taskDueDate;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}