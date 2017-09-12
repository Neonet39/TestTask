package Controller.ControllerServlet;

import Service.ImplServiceCofe;
import Service.ServiceCofe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 11.09.2017.
 */
public class AssortmentCoffeController extends HttpServlet {

    ServiceCofe serviceCofe = new  ImplServiceCofe();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

        RequestDispatcher dispatcher = request.getRequestDispatcher("page/assortmentcoffe.jsp");
        request.setAttribute("assortementCoffeList",serviceCofe.getAssortmentCoffe());
        dispatcher.forward(request,response);
    }
}
