package effective.repository;

import effective.model.Book;

import java.util.*;

public class BookRepositoryImpl implements BookRepository {
    private static final BookRepository INSTANCE = new BookRepositoryImpl();
    private final List<Book> books = new ArrayList<>();

    private BookRepositoryImpl() {
        if (INSTANCE != null) {
            throw new IllegalStateException("You cannot create another instance of this class");
        }
    }

    public static BookRepository getInstance() {
        return INSTANCE;
    }

    public void addBook(Book book) {
        if (book == null) {
            return;
        }

        books.add(book);
    }

    public void removeBook(Book book) {
        if (book == null) {
            return;
        }

        books.remove(book);
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void replaceBook(int index, Book newBook) {
        books.set(index, newBook);
    }

    public void addBooks(List<Book> bookToAdd) {
        books.addAll(bookToAdd);
    }

    public void removeBooks(List<Book> booksToRemove) {
        books.removeAll(booksToRemove);
    }
}
