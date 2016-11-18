package dao;

import model.Task;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by employee on 11/16/16.
 */
public interface TaskDAO {

    public void addTask(Task task) throws SQLException, ClassNotFoundException;
    public void deleteTask(Task task);
    public void markTask(Task task);

    public List<Task> getTask() throws SQLException, ClassNotFoundException;


}
