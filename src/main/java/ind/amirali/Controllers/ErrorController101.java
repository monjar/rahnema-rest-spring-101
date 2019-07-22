package ind.amirali.Controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class ErrorController101 implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    public Map showError(HttpServletRequest request, Model model){
        model.addAttribute("code", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));

        model.addAttribute("message", request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        return model.asMap();





        // in vase safe khoshgel neshoon dadan bood
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        model.addAttribute("status", status);
//        return "errorView";


    }
}
