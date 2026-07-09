package effective.repository;

import effective.model.Book;
import effective.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private static final UserRepository INSTANCE = new UserRepositoryImpl();
    private final List<User> users = new ArrayList<>();

    private UserRepositoryImpl() {
        if (INSTANCE != null) {
            throw new IllegalStateException("You cannot create another instance of this class");
        }
    }

    public static UserRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public User getUser(int index) {
        return users.get(index);
    }

    @Override
    public User getById(int id) {
        return users.stream()
                .filter(u -> u.getLibraryCardId() == id)
                .findAny()
                .orElseThrow();
    }

    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public void removeUser(User user) {
        users.remove(user);
    }
}
