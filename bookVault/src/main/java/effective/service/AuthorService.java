package effective.service;

import effective.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();
    Author getAuthor(int index);
    void createAuthor(Author author);
    void removeAuthor(Author author);
}
