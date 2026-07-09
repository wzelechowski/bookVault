package effective.repository;

import effective.model.Author;

import java.util.List;

public interface AuthorRepository {
    List<Author> getAll();
    Author getAuthor(int index);
    void createAuthor(Author author);
    void removeAuthor(Author author);
}
