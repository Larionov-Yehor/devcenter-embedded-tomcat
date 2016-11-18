package dao;

import model.Task;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

/**
 * Created by employee on 11/16/16.
 */
public class TaskDaoImpl {

    public void addTask(Task task) throws SQLException, ClassNotFoundException {
        Connection connection = MySqlConnection.getConnection();
        Statement statement =connection.createStatement();

         String str ="insert into tasks (task_name, task_description, task_state, task_due_date, list_id)"+
                "values(" +
                "'"+task.getTitle()+"',"+
                "'"+task.getDescription()+"',"+
                task.getStateForSql()+",'"+
                task.getTaskDueDate()+"',"+
                task.getListId()+
                ");" ;


        statement.execute(str);

    }

    public void removeTask(int taskId) throws SQLException, ClassNotFoundException  {

        Connection connection = MySqlConnection.getConnection();
        Statement statement = connection.createStatement();

        String request = "DELETE from tasks where task_id="+taskId+";" ;
        statement.execute(request);


    }

    public void removeCoupledTask(int listId) throws SQLException, ClassNotFoundException  {

        Connection connection = MySqlConnection.getConnection();
        Statement statement = connection.createStatement();

        String request = "DELETE from tasks where list_id="+listId+";" ;
        statement.execute(request);


    }

    public void markAsDone(int taskId) throws SQLException, ClassNotFoundException{
        Connection connection = MySqlConnection.getConnection();
        Statement statement = connection.createStatement();

        String request = "UPDATE tasks set task_state = not task_state where task_id="+taskId+";" ;

        statement.execute(request);
    }

    public List<Task> getTasksForParticularList(int list_id) throws SQLException, ClassNotFoundException {

        List<Task> tasks = new ArrayList<Task>();
        Connection connection = MySqlConnection.getConnection();
        Statement statement = connection.createStatement();

        String str = "SELECT* from tasks where list_id = "+list_id +";";

        ResultSet resultSet = statement.executeQuery(str);
        while (resultSet.next()){

            int id = resultSet.getInt("task_id");
            String title = resultSet.getString("task_name");
            String description = resultSet.getString("task_description");
            String dateStr = resultSet.getString("task_due_date");
            boolean state = resultSet.getBoolean("task_state");

            String [] parts = dateStr.split("-");
            LocalDate date = LocalDate.of(
                    Integer.valueOf(parts[0]),
                    Integer.valueOf(parts[1]),
                    Integer.valueOf(parts[2]));

            Task task = new Task();
            task.setId(id);
            task.setTitle(title);
            task.setDescription(description);
            task.setTaskDueDate(date);
            task.setState(state);

            tasks.add(task);
        }

        return tasks;}
}
