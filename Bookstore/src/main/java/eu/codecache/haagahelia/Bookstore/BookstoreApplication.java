package eu.codecache.haagahelia.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import eu.codecache.haagahelia.Bookstore.model.Book;
import eu.codecache.haagahelia.Bookstore.model.BookRepository;
import eu.codecache.haagahelia.Bookstore.model.Category;
import eu.codecache.haagahelia.Bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookStore(BookRepository repository, CategoryRepository categories) {
		return (args) -> {
			Category c1 = new Category("Loistava!");
			Category c2 = new Category("Toiminta");
			categories.save(c1);
			categories.save(c2);
			repository.save(new Book("Tuntematon sotilas", "Väinö Linna", 1954, "xxx", 20.90, c1));
			repository.save(new Book("Conan taistelija", "Robert E. Howard", 1990, "951-8954-55-0", 99.90, c2));
		};
	}

}
