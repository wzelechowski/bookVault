package effective.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Rental {
    private final User user;
    private final Book book;
    private final LocalDateTime rentedAt;

    public Rental(User user, Book book) {
        this.user = user;
        this.book = book;
        this.rentedAt = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDateTime getRentedAt() {
        return rentedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rental rental)) return false;
        return Objects.equals(user, rental.user) && Objects.equals(book, rental.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, book);


    }

    @Override
    public String toString() {
        return "Rental{" +
                "user=" + user +
                ", book=" + book +
                ", rentedAt=" + rentedAt +
                '}';
    }
}
