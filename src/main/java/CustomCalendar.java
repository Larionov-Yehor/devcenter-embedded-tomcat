import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;


import static java.lang.Integer.parseInt;

/**
 * Created by employee on 11/14/16.
 */


    @WebServlet(
            name = "Calendar",
            urlPatterns = {"/calendar"}
    )

    public class CustomCalendar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;

        String htmlCalendar = getCalendar(request);

        requestDispatcher = getServletContext().getRequestDispatcher("/jsp/calendar.jsp");
        request.setAttribute("calendar", htmlCalendar);
        requestDispatcher.forward(request, response);
    }

    private String getCalendar(HttpServletRequest request){

        LocalDate currentDate = LocalDate.now();

        String yearParameter = request.getParameter("Year");
        String monthParameter = request.getParameter("Month");
        String firstDayOfWeekParameter = request.getParameter("FirstDayOfWeek");

        if(yearParameter==null){
            yearParameter = String.valueOf(currentDate.getYear());
        }

        if (monthParameter==null){
            monthParameter = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        }

        if(firstDayOfWeekParameter==null){
            firstDayOfWeekParameter = currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.ENGLISH);
        }

        LocalDate localDateToCreateCalendar = LocalDate.of(Integer.valueOf(yearParameter),
                                                           Month.valueOf(monthParameter.toUpperCase()),
                                                           1);

        HtmlCalendar htmlCalendar = new HtmlCalendar(localDateToCreateCalendar,
                                                     DayOfWeek.valueOf(firstDayOfWeekParameter.toUpperCase()));

        String fullCalendar = htmlCalendar.returnCalendarTable();


        return fullCalendar;
    }

    }
