package effective.repository;

import effective.model.Book;
import effective.model.Rental;
import effective.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RentalRepositoryImpl implements RentalRepository {

    private static final RentalRepository INSTANCE = new RentalRepositoryImpl();
    private final List<Rental> rentals = new ArrayList<>();

    private RentalRepositoryImpl() {
        if (INSTANCE != null) {
            throw new IllegalStateException("You cannot create another instance of this class");
        }
    }

    public static RentalRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Rental> getAll() {
        return Collections.unmodifiableList(rentals);
    }

    @Override
    public List<Rental> getByUser(User user) {
        return rentals.stream()
                .filter(r -> r.getUser().equals(user))
                .toList();
    }

    @Override
    public List<Rental> getByBooks(Book book) {
        return rentals.stream()
                .filter(r -> r.getBook().equals(book))
                .toList();
    }

    @Override
    public void createRental(Rental rental) {
        rentals.add(rental);
    }

    @Override
    public void removeRental(Rental rental) {
        rentals.remove(rental);
    }
}
