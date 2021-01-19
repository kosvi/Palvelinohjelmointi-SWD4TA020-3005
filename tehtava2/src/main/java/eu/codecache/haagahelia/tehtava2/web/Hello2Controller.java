package eu.codecache.haagahelia.tehtava2.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Student;

@Controller
public class Hello2Controller {

	@RequestMapping("/hello2")
	public String hello(Model model) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Kate", "Cole"));
		students.add(new Student("Dan", "Brown"));
		students.add(new Student("Mike", "Mars"));
		Collections.sort(students);
		model.addAttribute("students", students);
		return "hello2";
	}

}
