package eu.codecache.haagahelia.tehtava1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

	@RequestMapping("contact")
	@ResponseBody
	public String returnHello() {
		return "This is the contact page";
	}
}
