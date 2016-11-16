package controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by employee on 11/16/16.
 */
public class MySqlConnection {

    Connection connection = null;

    public void createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mySql://localhost/todolist", "root", "employee");

    }

    public void closeConnection() throws  SQLException{
    connection.close();
    }

    public Connection getConnection(){
    return connection;
    }

}

