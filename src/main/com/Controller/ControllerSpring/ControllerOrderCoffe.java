package Controller.ControllerSpring;

import Convert.ConvertToObject;
import Modal.PreOrderCoffe;
import Modal.TotalPrice;
import Service.ServiceCofe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny on 14.09.2017.
 */
@Controller
@SessionAttributes({"preOrderCoffeList","totalPrice"})
public class ControllerOrderCoffe {
    @Autowired
    ServiceCofe serviceCofe;

    @RequestMapping(value = "/assortmentcoffe",method = RequestMethod.GET)
    public ModelAndView assortment() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("assortmentcoffe");
        modelAndView.addObject("assortementCoffeList",serviceCofe.getAssortmentCoffe());
        return modelAndView;
    }

    @RequestMapping(value = "/preordercoffe",method = RequestMethod.POST)
    public ModelAndView preordercoffe(HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        String url = "";
        ConvertToObject convertToObject = new ConvertToObject();
        List orderCoffeList = convertToObject.ConvetrtToOrderCofe(request.getParameterMap());

        if(orderCoffeList!=null) {
            Map preOrderCoffeMap = serviceCofe.getPreOrderCoffe(orderCoffeList);
            TotalPrice totalPrice;
            if(preOrderCoffeMap!=null) {

                 totalPrice = (TotalPrice) preOrderCoffeMap.get("tPrice");
                List<PreOrderCoffe> preOrderCoffeList = (List<PreOrderCoffe>) preOrderCoffeMap.get("preOrderCoffeList");

                if(totalPrice!=null&&preOrderCoffeList!=null) {

                    modelAndView.setViewName("preordercoffe");
                    modelAndView.addObject("preOrderCoffeList",preOrderCoffeList);
                    modelAndView.addObject("totalPrice",totalPrice);

                }else  modelAndView.setViewName("error");

            } else  modelAndView.setViewName("error");

        } else  modelAndView.setViewName("error");

        modelAndView.setViewName("preordercoffe");
        return modelAndView;
    }



}
