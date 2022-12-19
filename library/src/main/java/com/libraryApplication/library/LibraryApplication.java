package com.libraryApplication.library;

import com.libraryApplication.library.entity.Author;
import com.libraryApplication.library.entity.Book;
import com.libraryApplication.library.entity.Category;
import com.libraryApplication.library.entity.Publisher;
import com.libraryApplication.library.service.AuthorService;
import com.libraryApplication.library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService){
		return(args) ->{
			Book book1 = new Book("123456", "Dune", "Book Description 1");
			Author author1 = new Author("Herbert", "Author description 1");
			Category category1 = new Category("science fiction");
			Publisher publisher1 = new Publisher("Publisher 1");

			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);

			bookService.createBook(book1);

			Book book2 = new Book("222222", "Alchemist", "Book Description 2");
			Author author2 = new Author("Coehlo", "Author description 2");
			Category category2 = new Category("fiction");
			Category category2b = new Category("spiritual");
			Publisher publisher2 = new Publisher("Publisher 2");

			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addCategory(category2b);
			book2.addPublisher(publisher2);

			bookService.createBook(book2);

			Book book3 = new Book("333333", "Debt", "Book Description 3");
			Author author3 = new Author("Graeber", "Author description 3");
			Category category3 = new Category("history");
			Publisher publisher3 = new Publisher("Publisher 3");

			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);

			bookService.createBook(book3);
		};
	}
}
