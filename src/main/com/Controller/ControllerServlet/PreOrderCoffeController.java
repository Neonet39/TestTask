package Controller.ControllerServlet;

import Convert.ConvertToObject;
import Modal.PreOrderCoffe;
import Modal.TotalPrice;
import Service.ImplServiceCofe;
import Service.ServiceCofe;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny on 11.09.2017.
 */
public class PreOrderCoffeController extends HttpServlet {
    ServiceCofe serviceCofe = new ImplServiceCofe();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        String url = "";
        ConvertToObject convertToObject = new ConvertToObject();
        List orderCoffeList = convertToObject.ConvetrtToOrderCofe(request.getParameterMap());

        if(orderCoffeList!=null) {
            Map preOrderCoffeMap = serviceCofe.getPreOrderCoffe(orderCoffeList);

            if(preOrderCoffeMap!=null) {

                TotalPrice totalPrice = (TotalPrice) preOrderCoffeMap.get("tPrice");
                List<PreOrderCoffe> preOrderCoffeList = (List<PreOrderCoffe>) preOrderCoffeMap.get("preOrderCoffeList");

                if(totalPrice!=null&&preOrderCoffeList!=null) {

                    request.getSession().setAttribute("preOrderCoffeList", preOrderCoffeList);
                    request.getSession().setAttribute("totalPrice", totalPrice);


                    request.setAttribute("preOrderCoffeList", preOrderCoffeList);
                    request.setAttribute("totalPrice", totalPrice);
                    url = "page/preordercoffe.jsp";

                }else url = "page/error.jsp";

            } else url = "page/error.jsp";

        } else url = "page/error.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
