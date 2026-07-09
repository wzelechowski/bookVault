package effective.service;

import effective.model.Book;
import effective.model.Rental;
import effective.model.User;
import effective.repository.RentalRepository;

import java.util.List;

public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public List<Rental> getAll() {
        return rentalRepository.getAll();
    }

    @Override
    public List<Rental> getByUser(User user) {
        return rentalRepository.getByUser(user);
    }

    @Override
    public List<Rental> getByBook(Book book) {
        return rentalRepository.getByBooks(book);
    }

    @Override
    public void rentBook(Rental rental) {
        rentalRepository.createRental(rental);
    }

    @Override
    public void deleteRental(Rental rental) {
        rentalRepository.removeRental(rental);
    }
}
