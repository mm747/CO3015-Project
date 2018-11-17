package portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

	@RequestMapping("/system/user")
	public String user() {
		return "indexUser";
	}

	@RequestMapping("/system/premium")
	public String premium() {
		return "indexPremium";
	}

}
