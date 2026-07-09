package effective.service;

import effective.model.Author;
import effective.repository.AuthorRepository;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
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
