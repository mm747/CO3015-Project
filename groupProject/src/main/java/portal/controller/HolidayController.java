package portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/holiday")
public class HolidayController {

    @RequestMapping("/")
    public String index(Model model) {
        return "form/Holiday";
    }
    
}