package portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import portal.domain.Status;
import portal.repository.StatusRepository;

@Controller
@RequestMapping("/status")
public class StatusController {
	
	@Autowired StatusRepository statusRepo;
	
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    		binder.addValidators(new StatusValidator());
    }
    
//    @RequestMapping("/")
//    public String index(Model model) {
////    		model.addAttribute("productList", EMarketApp.getStore().getProductList());
//    	model.addAttribute("statusList", (List<Status>) statusRepo.findAll());
//    	return "form/statusMaster";
//    }
    
    @RequestMapping(value = "/statusDetail", method = RequestMethod.GET)
    public String statusDetail(@ModelAttribute("status") Status status, BindingResult result, @RequestParam(value="statusId", required=false, defaultValue="-1") int statusId) {
    		if (!result.hasErrors()) {
		    	if (statusId >= 0) {
		    		// modify
//		    		Product p2 = EMarketApp.getStore().getProductList().stream().filter(p -> (((Product) p).getId() == productId)).findAny().get();
		    		Status p2 = ((List<Status>) statusRepo.findAll()).stream().filter(p -> (((Status) p).getId() == statusId)).findAny().get();
		    		status.setId(p2.getId());
		    		status.setName(p2.getName());
		    		status.setDescription(p2.getDescription());
		    	} else {
		    		// add
//		    		product.setId();
		    	
		    	}
		}
    		return "form/statusDetail";
    }   
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String productMaster(@Valid @ModelAttribute("status") Status status, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    		return "form/statusDetail";
	    } else {

	    		statusRepo.save(status);
		   		
		    	model.addAttribute("statusList", (List<Status>)statusRepo.findAll());
		    	return "index";
	    }
    }   

    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String productMaster(@Valid @RequestParam(value="statusId", required=false, defaultValue="-1") int statusId, Model model) {
//	    	EMarketApp.getStore().getProductList().removeIf(p -> (p.getId() == productId));
	    	Status p = statusRepo.findById(statusId);
	    	if (p != null) statusRepo.delete(p);
//	    	model.addAttribute("productList", EMarketApp.getStore().getProductList());
	    	model.addAttribute("statusList", (List<Status>) statusRepo.findAll());
	    	return "index";
    }   
    
    
    
}
