package com.libraryApplication.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter // From lombok library. Generates getters, setters, and no arg constructor
@Setter
@NoArgsConstructor
@Entity // from JPA
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "book_category",
                joinColumns = @JoinColumn(name="book_id"),
                inverseJoinColumns = @JoinColumn(name="category_id"))
    private Set<Category> categories = new HashSet<>();

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "book_publisher",
            joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="publisher_id"))
    private Publisher publisher;

    public Book(String isbn, String name, String description) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
    }

    public void removeFromPublisher(Publisher publisher){
        publisher.removeBook(this);
    }

    public void addPublisher(Publisher publisher){
        this.setPublisher(publisher);
        publisher.addBook(this);
    }

    public void removeAuthor(Author author){
        this.authors.remove(author);
        author.removeBook(this);
    }

    public void addAuthor(Author author){
        this.authors.add(author);
        author.addBook(this);
    }

    public void removeCategory(Category category){
        this.categories.remove(category);
        category.removeBook(this);
    }

    public void addCategory(Category category){
        this.categories.add(category);
        category.addBook(this);
    }
}
