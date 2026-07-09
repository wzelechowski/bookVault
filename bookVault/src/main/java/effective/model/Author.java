package effective.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author {
    private final String firstName;
    private final String lastName;
    private final int authorId;
    private final List<Book> books = new ArrayList<>();

    public Author(String firstName, String lastName, int authorId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return authorId == author.authorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId);
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", authorId=" + authorId +
                ", books=" + books +
                '}';
    }
}
