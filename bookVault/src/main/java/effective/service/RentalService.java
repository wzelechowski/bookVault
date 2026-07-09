package effective.service;

import effective.model.Book;
import effective.model.Rental;
import effective.model.User;

import java.util.List;

public interface RentalService {
    List<Rental> getAll();
    List<Rental> getByUser(User user);
    List<Rental> getByBook(Book book);
    void rentBook(Rental rental);
    void deleteRental(Rental rental);
}
