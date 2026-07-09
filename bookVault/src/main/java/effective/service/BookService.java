package effective.service;

import effective.model.Book;

import java.util.List;
import java.util.Set;

public interface BookService {
    List<Book> getAll();
    Book getByTitle(String title);
    Book getByISBN(String ISBN);
    Set<Book> getByCategory(Book.Category category);
    List<Book> getBooksSortedByTitle();
    List<Book> getBooksSortedByLanguage();
    List<Book> getBooksSortedByPrice();
    List<Book> getBooksSortedByReleaseYear();
    void addBook(Book book);
    void addBooks(List<Book> books);
    void removeBook(Book book);
    void removeBooks(List<Book> books);
    Book updateBook(int index, Book.Builder builder);
}
