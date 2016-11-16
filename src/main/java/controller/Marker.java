package controller;

import model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by employee on 11/15/16.
 */
@WebServlet({"/marker"})
public class Marker extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        if(!session.isNew()){

            String taskNumber = req.getParameter("task");

            Task task = (Task) session.getAttribute(taskNumber);

            task.markAsDone();
            System.out.println(task.isDone());

            session.setAttribute(taskNumber,  task);

        }
        resp.sendRedirect("/home");

    }
}
