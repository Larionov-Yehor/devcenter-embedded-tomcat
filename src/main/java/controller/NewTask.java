package controller;

import model.Task;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by yurik on 14.11.16.
 */
@WebServlet({"/newTask"})
public class NewTask extends HttpServlet{

    private int counter = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

        HttpSession session = req.getSession(true);


        if (!session.isNew()) {

            session.setAttribute("counter", counter);

            String taskTitle = req.getParameter("task_name");
            String taskDescription = req.getParameter("task_description");

            Task task = new Task(taskTitle, taskDescription, false);

            session.setAttribute(String.valueOf(counter), task);

            counter = counter + 1;

            TaskDaoImpl taskDao = new TaskDaoImpl();
            System.out.println(taskDao);
            try {
            try{
                taskDao.addTask(task);
            } catch (SQLException s) {s.printStackTrace();}
            } catch (ClassNotFoundException c){c.printStackTrace();}

        }



        resp.sendRedirect("/home");
    }


}