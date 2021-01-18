package eu.codecache.haagahelia.tehtava1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("hello")
	@ResponseBody
	public String returnHello(@RequestParam(name = "name", required = false, defaultValue = "student") String name,
			@RequestParam(name = "location", required = false, defaultValue = "school") String location) {
		return "Welcome to the " + location + " " + name + "!";
	}

}
