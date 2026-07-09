package effective.service;

import effective.model.Book;
import effective.model.Rental;
import effective.model.User;
import effective.repository.RentalRepository;
import effective.repository.RentalRepositoryImpl;

import java.util.List;

public class RentalServiceImpl implements RentalService {

    private static final RentalService INSTANCE = new RentalServiceImpl(RentalRepositoryImpl.getInstance());
    private final RentalRepository rentalRepository;

    private RentalServiceImpl(RentalRepository rentalRepository) {
        if (INSTANCE != null) {
            throw new IllegalStateException("You cannot create another instance of this class");
        }
        this.rentalRepository = rentalRepository;
    }

    public static RentalService getInstance() {
        return INSTANCE;
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
