package effective.repository;

import effective.model.Author;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository {

    private static final AuthorRepository INSTANCE = new AuthorRepositoryImpl();
    private final List<Author> authors = new ArrayList<>();

    private AuthorRepositoryImpl() {
        if (INSTANCE != null) {
            throw new IllegalStateException("You cannot create another instance of this class");
        }
    }

    public static AuthorRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Author> getAll() {
        return Collections.unmodifiableList(authors);
    }

    @Override
    public Author getAuthor(int index) {
        return authors.get(index);
    }

    @Override
    public void createAuthor(Author author) {
        authors.add(author);
    }

    @Override
    public void removeAuthor(Author author) {
        authors.remove(author);
    }
}
