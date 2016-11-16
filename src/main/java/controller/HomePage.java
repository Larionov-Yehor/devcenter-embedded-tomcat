package controller;

import model.Task;
import org.apache.catalina.Session;
import org.apache.catalina.connector.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/15/16.
 */
@WebServlet({"/home"})
public class HomePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Task> taskList = new ArrayList();
        List<Task> doneTasks = new ArrayList();

        HttpSession session = req.getSession(true);

        if (!session.isNew()) {

            int listLength = (Integer)session.getAttribute("counter");

            for (int i = 1; i <= listLength; i++) {

                Task task = (Task) session.getAttribute(String.valueOf(i));

                if(task==null){}

                else if (!task.isDone()) {
                    taskList.add(task);
                }
                else{
                    doneTasks.add(task);
                }

            }
        }


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");

        req.setAttribute("taskList", taskList);
        req.setAttribute("doneTasks", doneTasks);
        dispatcher.forward(req, resp);
    }
}