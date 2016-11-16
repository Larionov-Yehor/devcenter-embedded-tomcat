package controller;

import controller.dao.MySqlConnection;
import controller.dao.TaskDAO;
import model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/16/16.
 */
public class TaskDaoImpl implements TaskDAO {

    public void addTask(Task task) throws SQLException, ClassNotFoundException {
        MySqlConnection MySqlConnection = new MySqlConnection();
        MySqlConnection.createConnection();

        Connection connection = MySqlConnection.getConnection();
        Statement statement =connection.createStatement();

                String str =
                         "INSERT INTO tasks VALUES(" +
                                 task.getId()+"," +
                                 "'"+task.getTitle()+"',"+
                                 "'"+task.getDescription()+"',"+
                                 task.getStateForSql()+
                                 ");" ;

        statement.execute(str);
        MySqlConnection.closeConnection();
    }

    public void deleteTask(Task task) {

    }

    public void markTask(Task task) {

    }

    public List<Task> getTask() throws SQLException, ClassNotFoundException {
        List<Task> tasks = new ArrayList<Task>();

        MySqlConnection MySqlConnection = new MySqlConnection();
        MySqlConnection.createConnection();
        Connection connection = MySqlConnection.getConnection();
        Statement statement =connection.createStatement();

        String str = "SELECT* from tasks";

        ResultSet resultSet = statement.executeQuery(str);
        while (resultSet.next()){

           // int id = resultSet.getInt("t_id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            boolean state = Task.setStateFromSql(Integer.valueOf(resultSet.getString("state")));

            Task task = new Task(title,description,state);
            tasks.add(task);
        }


        MySqlConnection.closeConnection();
        return tasks;}
}
