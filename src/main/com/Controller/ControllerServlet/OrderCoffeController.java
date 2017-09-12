package Controller.ControllerServlet;

import Convert.ConvertToObject;
import Modal.AddressDelivery;
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
public class OrderCoffeController extends HttpServlet {
    ServiceCofe serviceCofe = new ImplServiceCofe();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String url = "";
        String fio = new String(request.getParameter("fio").getBytes("ISO-8859-1"),"UTF-8");
        String adres = new String(request.getParameter("adres").getBytes("ISO-8859-1"),"UTF-8");


        if(!fio.equals("")&&!adres.equals("")) {
            AddressDelivery addressDelivery = new AddressDelivery();
            addressDelivery.setName(fio);
            addressDelivery.setDelivery_address(adres);

            List preOrderCoffeList = (List<PreOrderCoffe>) request.getSession().getAttribute("preOrderCoffeList");
            TotalPrice totalPrice = (TotalPrice) request.getSession().getAttribute("totalPrice");

            if(preOrderCoffeList.size()>0&&totalPrice!=null) {
                if(serviceCofe.setOrderCoffe(preOrderCoffeList, addressDelivery, totalPrice)) {
                     url = "page/order.jsp";

                } else url = "page/error.jsp";

            } else url = "page/error.jsp";

        } else url = "page/error.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
