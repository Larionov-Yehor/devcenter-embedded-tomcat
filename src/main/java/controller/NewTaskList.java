package controller;

import dao.TaskListDaoImpl;
import model.TaskList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by employee on 11/17/16.
 */
@WebServlet({"/newTaskList"})
public class NewTaskList extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String taskListName = req.getParameter("tasklist_name");

        System.out.println(taskListName);

        TaskList taskList = new TaskList();
        taskList.setName(taskListName);

        TaskListDaoImpl taskListDao = new TaskListDaoImpl();


        try {
        try {
              taskListDao.add(taskList);
            } catch (SQLException s) {s.printStackTrace();}
        } catch (ClassNotFoundException c){c.printStackTrace();}


        resp.sendRedirect("/home");
    }


}