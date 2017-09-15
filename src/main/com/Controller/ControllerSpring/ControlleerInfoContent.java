package Controller.ControllerSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Evgeny on 14.09.2017.
 */
@Controller
public class ControlleerInfoContent {
    @RequestMapping(value = "/greeting",method = RequestMethod.GET)
    public String greeting(){

        return "greeting";
    }
}
