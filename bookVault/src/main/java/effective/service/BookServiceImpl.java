package effective.service;

import effective.model.Book;
import effective.repository.BookRepository;
import effective.repository.BookRepositoryImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    public static final BookServiceImpl INSTANCE = new BookServiceImpl(BookRepositoryImpl.getInstance());
    private final BookRepository bookRepository;

    private BookServiceImpl(BookRepository bookRepository) {
        if (INSTANCE != null) {
            throw new IllegalStateException("You cannot create another instance of this class");
        }

        this.bookRepository = bookRepository;
    }

    public static BookServiceImpl getInstance() {
            return INSTANCE;
    }

    public List<Book> getAll() {
        return bookRepository.getBooks();
    }

    public Book getByTitle(String title) {

        return bookRepository.getBooks().stream()
                .filter(b -> b.getTitle().equals(title))
                .findAny().orElseThrow(NoSuchElementException::new);
    }

    public Book getByISBN(String ISBN) {
        return bookRepository.getBooks().stream()
                .filter(b -> b.getISBN().equals(ISBN))
                .findAny().orElseThrow(NoSuchElementException::new);
    }

    public Set<Book> getByCategory(Book.Category category) {
        return bookRepository.getBooks().stream()
                .filter(book -> book.getCategories().contains(category))
                .collect(Collectors.toSet());
    }

    public List<Book> getBooksSortedByTitle() {
        return bookRepository.getBooks().stream()
                .sorted(Book.BY_TITLE)
                .toList();
    }

    public List<Book> getBooksSortedByLanguage() {
        return bookRepository.getBooks().stream()
                .sorted(Book.BY_LANGUAGE)
                .toList();
    }

    public List<Book> getBooksSortedByPrice() {
        return bookRepository.getBooks().stream()
                .sorted(Book.BY_PRICE)
                .toList();
    }

    public List<Book> getBooksSortedByReleaseYear() {
        return bookRepository.getBooks().stream()
                .sorted(Book.BY_RELEASE_YEAR)
                .toList();
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public void addBooks(List<Book> books) {
        bookRepository.addBooks(books);
    }

    public void removeBook(Book book) {
        bookRepository.removeBook(book);
    }

    public void removeBooks(List<Book> books) {
        bookRepository.removeBooks(books);
    }

    public Book updateBook(int index, Book.Builder builder) {
        Book newBook = builder.build();
        bookRepository.replaceBook(index, newBook);
        return newBook;
    }
}
