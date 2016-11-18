package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/16/16.
 */

public class TaskList{

  private List<Task> coupledTasks = new ArrayList<Task>();
  private String name;
  private int id;


  public List<Task> getCoupledTasks() {
    return coupledTasks;
  }

  public void setCoupledTasks(List<Task> coupledTasks) {
    this.coupledTasks = coupledTasks;
  }


public void add(Task task){
  coupledTasks.add(task);
}
public List<Task> getAllTasks(){
return coupledTasks;
}

public String getName() { return name; }

public void setName(String name) {
    this.name = name;
  }

public int getId() {
return id;
}

public void setListId(int listId) {
    this.id = listId;
  }
}
