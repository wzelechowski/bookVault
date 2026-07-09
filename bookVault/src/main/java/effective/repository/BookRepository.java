package effective.repository;

import effective.model.Book;

import java.util.List;

public interface BookRepository {
    void addBook(Book book);
    void removeBook(Book book);
    List<Book> getBooks();
    void replaceBook(int index, Book newBook);
    void addBooks(List<Book> books);
    void removeBooks(List<Book> books);
}
