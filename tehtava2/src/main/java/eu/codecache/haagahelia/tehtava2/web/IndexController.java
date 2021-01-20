package eu.codecache.haagahelia.tehtava2.web;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import eu.codecache.haagahelia.tehtava2.database.JDBCDao;
import eu.codecache.haagahelia.tehtava2.domain.Friend;

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
	public String friendSubmit(@Valid @ModelAttribute("name") Friend name, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "index";
		}
		JDBCDao database = new JDBCDao();
		// Heap area is not thread safe, so I am not going to store the
		// friends-list in local List
		database.addFriend(name);
		return "redirect:/index";
	}
}
