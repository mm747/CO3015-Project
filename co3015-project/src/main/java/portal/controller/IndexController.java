package portal.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import portal.PortalApp;

@Controller
public class IndexController {

	@InitBinder
    protected void initBinder(WebDataBinder binder) {
    		binder.addValidators(new IndexValidator());
    }

    @RequestMapping("/system")
    public String index(@ModelAttribute("indexFormDto") IndexFormDto indexFormDto) {
    		indexFormDto.setDate(PortalApp.getSystemDate());
        return "index";
    }
    
    @RequestMapping(value = "/setDate", method = RequestMethod.POST)
    public String setDate(@Valid @ModelAttribute("indexFormDto") IndexFormDto indexFormDto, BindingResult result, Model model) {
    		if (!result.hasErrors() ) {
    			System.out.println("changing date to " + indexFormDto.getDate().toString());
    			PortalApp.setSystemDate(indexFormDto.getDate());
    		}
    		return "index";
    }
    
    @RequestMapping("/file")
    public String index(Model model) {
        return "fileView";
    }
   
}
