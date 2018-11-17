package portal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import portal.PortalApp;
import portal.domain.UserInfo;
import portal.domain.UserInfoLogin;
import portal.repository.UserInfoRepository;

@Controller
public class LoginController {
	@Autowired UserInfoRepository userInfoRepo;
	
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    		binder.addValidators(new UserInfoLoginValidator());
    }
	
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landing() {
    		return "Landing";
    }
    
    @RequestMapping(value = "/login-form", method = RequestMethod.GET)
    public String login(@ModelAttribute("userInfoLogin") UserInfoLogin userInfoLogin) {
    		return "login-form";
    }

    @RequestMapping(value = "/success-login", method = RequestMethod.GET)
    public String authenticate() {
    		System.out.println("enters /success-login");
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			  if (!(auth instanceof AnonymousAuthenticationToken)) {
//				UserDetails userDetail = (UserDetails) auth.getPrincipal();
//				System.out.println("logging in as " + userDetail.getUsername());
//			  }
		
		authUser.getAuthorities().stream().forEach(c -> System.out.println (c));
		
		System.out.println("logging in as " + authUser.getUsername());
        UserInfo user = userInfoRepo.findByUsername(authUser.getUsername());
        String view;
        switch (user.getRole().getId()) {
        	case PortalApp.ADMIN: 
        		view = "redirect:/system/"; 
        		break;
        	case PortalApp.PREMIUM: 
        		view = "redirect:/system/premium"; 
        		break;
        default: //	case EMarketApp.USER: 
        		view = "redirect:/system/user"; 
        		break;
        		
        }
		
		return view;
    }

//    @RequestMapping(value = "/login", params = "cancel", method = RequestMethod.POST)
//    public String cancelAuthenticate(@ModelAttribute("userInfoLogin") UserInfoLogin userInfoLogin, Model model) {
//    		return "Landing";
//    }
    
    @RequestMapping("/logoff")
    public String logoff() {
    		return "Landing";
    }
    
    @RequestMapping("/access-denied")
    public String accessDenied() {
    	return "redirect:/login-form";
    }

    // to customize what to do at logout
//    @RequestMapping(value="/logout", method = RequestMethod.GET)
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){    
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login-form";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
//    }
}
