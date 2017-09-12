package Controller.ControllerServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 12.09.2017.
 */
public class CotrollerError extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("page/error.jsp");
        dispatcher.forward(request,response);
    }
}
