package effective.service;

import effective.model.Author;
import effective.repository.AuthorRepository;
import effective.repository.AuthorRepositoryImpl;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private static final AuthorService INSTANCE = new AuthorServiceImpl(AuthorRepositoryImpl.getInstance());
    private final AuthorRepository authorRepository;

    private AuthorServiceImpl(AuthorRepository authorRepository) {
        if (INSTANCE != null) {
            throw new IllegalStateException("You cannot create another instance of this class");
        }

        this.authorRepository = authorRepository;
    }

    public static AuthorService getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.getAll();
    }

    @Override
    public Author getAuthor(int index) {
        return authorRepository.getAuthor(index);
    }

    @Override
    public void createAuthor(Author author) {
        authorRepository.createAuthor(author);
    }

    @Override
    public void removeAuthor(Author author) {
        authorRepository.removeAuthor(author);
    }
}
