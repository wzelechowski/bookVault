package effective.repository;

import effective.model.Book;
import effective.model.Rental;
import effective.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRentalRepository implements RentalRepository {

    private final String filePath;
    private final ObjectMapper objectMapper;
    private final List<Rental> rentals = new ArrayList<>();

    public JsonRentalRepository(String filePath, ObjectMapper objectMapper) {
        this.filePath = filePath;
        this.objectMapper = objectMapper;
    }

    private void saveToFile() {
        try(FileWriter fileWriter = new FileWriter(filePath)) {
            objectMapper.writeValue(fileWriter, getAll());
            System.out.println("JSON file have been written successfully at path: " + filePath);
        } catch (IOException e) {
            System.err.println("Critical error during writing json file: " + e.getMessage());
        }
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
        saveToFile();
    }

    @Override
    public void removeRental(Rental rental) {
        rentals.remove(rental);
    }
}
