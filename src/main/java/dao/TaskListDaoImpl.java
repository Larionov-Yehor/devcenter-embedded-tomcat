package dao;

import model.Task;
import model.TaskList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/17/16.
 */
public class
TaskListDaoImpl{
    public void add(TaskList taskList) throws SQLException, ClassNotFoundException {

        MySqlConnection.createConnection();
        Connection connection = MySqlConnection.getConnection();
        Statement statement = connection.createStatement();

        String str =
                "INSERT INTO tasklists (tasklist_name)VALUES("+

                        "'"+taskList.getName()+"'"+
                        ");" ;

        statement.execute(str);

    }

    public List<TaskList> getTaskLists() throws SQLException, ClassNotFoundException {
        List<TaskList> taskLists = new ArrayList<TaskList>();

        MySqlConnection.createConnection();
        Connection connection = MySqlConnection.getConnection();
        Statement statement = connection.createStatement();

        String str = "SELECT* from tasklists;";

        ResultSet resultSet = statement.executeQuery(str);
        while (resultSet.next()){

            int id = resultSet.getInt("list_id");
            String name = resultSet.getString("tasklist_name");

           TaskList taskList = new TaskList();

           taskList.setListId(id);
           taskList.setName(name);

           taskLists.add(taskList);

        }
    return  taskLists;}

    public TaskList getParticularTaskList(int id) throws SQLException,ClassNotFoundException{
        TaskList taskList = new TaskList();

        MySqlConnection.createConnection();
        Connection connection = MySqlConnection.getConnection();
        Statement statement = connection.createStatement();

        String str = "SELECT* from tasklists where list_id=" +id +";";

        ResultSet resultSet = statement.executeQuery(str);
        while (resultSet.next()){

            int tasklist_id = resultSet.getInt("list_id");
            String name = resultSet.getString("tasklist_name");

            taskList.setListId(tasklist_id);
            taskList.setName(name);
        }

    return taskList;
    }

    public void remove(int listId) throws SQLException,ClassNotFoundException{
        Connection connection = MySqlConnection.getConnection();
        Statement statement = connection.createStatement();

        String request = "DELETE from tasklists where list_id="+listId+";" ;
        statement.execute(request);


    }

    public void mark(Task task) {

    }
}
