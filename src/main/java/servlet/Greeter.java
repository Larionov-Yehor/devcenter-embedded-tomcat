package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "Greeter",
        urlPatterns = {"/greeter"}
)
public class Greeter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/jsp/greeter.jsp");
        String nameParameter = request.getParameter("name");

        if(nameParameter == null){
            nameParameter = "Incognito";
        }

        request.setAttribute("name", nameParameter);
        requestDispatcher.forward(request, response);
    }
}