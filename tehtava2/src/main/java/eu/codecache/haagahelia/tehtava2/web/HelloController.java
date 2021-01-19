package eu.codecache.haagahelia.tehtava2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "student") String name,
			@RequestParam(name = "age", required = false, defaultValue = "0") String age, Model model) {
		model.addAttribute("name", name);
		int ageInt;
		try {
			ageInt = Integer.valueOf(age);
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
			ageInt = -1;
		}
		model.addAttribute("age", ageInt);
		return "hello";
	}

}
