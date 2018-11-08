package portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import portal.PortalApp;

@Controller
@RequestMapping("/profile")
public class PersonalProfileController {

    @RequestMapping("/")
    public String index(Model model) {
        return "form/personalProfile";
    }
    
}
