package eu.codecache.haagahelia.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import eu.codecache.haagahelia.Bookstore.model.Book;
import eu.codecache.haagahelia.Bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookStore(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("Tuntematon sotilas", "Väinö Linna", 1954, "xxx", 20.90));
			repository.save(new Book("Conan taistelija", "Robert E. Howard", 1990, "951-8954-55-0", 99.90));
		};
	}

}
