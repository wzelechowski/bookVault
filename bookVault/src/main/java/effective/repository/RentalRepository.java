package effective.repository;

import effective.model.Book;
import effective.model.Rental;
import effective.model.User;

import java.util.List;

public interface RentalRepository {
    List<Rental> getAll();
    List<Rental> getByUser(User user);
    List<Rental> getByBooks(Book book);
    void createRental(Rental rental);
    void removeRental(Rental rental);
}
