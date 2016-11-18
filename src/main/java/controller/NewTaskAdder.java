package controller;

import dao.TaskDaoImpl;
import dao.TaskListDaoImpl;
import model.Task;
import model.TaskList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

/**
 * Created by employee on 11/17/16.
 */
@WebServlet({"/newTaskAdder"})
public class NewTaskAdder extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String title = req.getParameter("title");
        String description = req.getParameter("task_description");
        String dateStr = req.getParameter("task_date");
        String taskListId = req.getParameter("task_list");


        String [] parts = dateStr.split("-");
        LocalDate date = LocalDate.of(
                Integer.valueOf(parts[0]),
                Integer.valueOf(parts[1]),
                Integer.valueOf(parts[2]));

        Task task = new Task();
        task.setTitle(title);
        task.setState(false);
        task.setTaskDueDate(date);
        task.setDescription(description);
        task.setListId(Integer.valueOf(taskListId));

        TaskDaoImpl taskDao =  new TaskDaoImpl();
        try {
            taskDao.addTask(task);
        } catch (SQLException e) { e.printStackTrace();
        } catch (ClassNotFoundException e) {  e.printStackTrace();}

        resp.sendRedirect("/home");

    }
}