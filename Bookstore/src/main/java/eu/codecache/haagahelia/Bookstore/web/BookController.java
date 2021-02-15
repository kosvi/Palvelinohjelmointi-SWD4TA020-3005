package eu.codecache.haagahelia.Bookstore.web;

import eu.codecache.haagahelia.Bookstore.model.Book;
import eu.codecache.haagahelia.Bookstore.model.BookRepository;
import eu.codecache.haagahelia.Bookstore.model.CategoryRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository categoriesRepo;

	@GetMapping("/index")
	public String home(Model model) {
		return "index";
	}

	@GetMapping("/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@GetMapping("/add")
	public String addBook(Model model) {
		model.addAttribute(new Book());
		model.addAttribute("categories", categoriesRepo.findAll());
		return "addbook";
	}

	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", categoriesRepo.findAll());
		return "editbook";
	}

	@PostMapping("/edit/save")
	public String saveEdit(@Valid Book book, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "editbook";
		}
		repository.save(book);
		return "redirect:../booklist";
	}

	@PostMapping("/save")
	public String save(@Valid Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "addbook";
		}
		repository.save(book);
		return "redirect:booklist";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}

	@GetMapping("/login")
	public String loginForm(Model model) {
		return "login";
	}
}
