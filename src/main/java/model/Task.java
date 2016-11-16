package model;

/**
 * Created by employee on 11/15/16.
 */
public class Task {

    private String title;
    private String description;
    private boolean state = false;


    private int id;

    private static int counter = 1;

    public Task(String title, String description, boolean t_state) {
        this.title = title;
        this.description = description;
        this.id = counter;
        this.state = t_state;

        counter = counter+1;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void markAsDone(){
        this.state = true;
    }

    public boolean isDone() {
        return state;
    }

    public int getStateForSql(){
        if(state==true){return 1;}
        return 0;
    }

    public static boolean setStateFromSql(int tinyInt){

        if(tinyInt==1){
        return true;
        }
        return false;
    }

}