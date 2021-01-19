package eu.codecache.haagahelia.tehtava2.web;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import database.JDBCDao;
import domain.Friend;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String friendForm(Model model) {
		JDBCDao database = new JDBCDao();
		List<Friend> friends = database.getFriends();
		Collections.sort(friends);
		model.addAttribute("friends", friends);
		model.addAttribute("name", new Friend());
		return "index";
	}

	@PostMapping("/index")
	public String friendSubmit(@ModelAttribute Friend name, Model model) {
		JDBCDao database = new JDBCDao();
		database.addFriend(name);
		return "redirect:/index";
	}
}
