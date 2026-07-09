package effective.service;

import effective.model.Book;
import effective.model.User;
import effective.repository.UserRepository;
import effective.repository.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final UserService INSTANCE = new UserServiceImpl(UserRepositoryImpl.getInstance());
    private final UserRepository userRepository;

    private UserServiceImpl(UserRepository userRepository) {
        if (INSTANCE != null) {
            throw new IllegalStateException("You cannot create another instance of this class");
        }
        this.userRepository = userRepository;
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    @Override
    public List<User> getAll() {
        return userRepository.getUsers();
    }

    @Override
    public User getUser(int index) {
        return userRepository.getUser(index);
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public void addUser(User user) {
        userRepository.createUser(user);
    }

    @Override
    public void removeUser(User user) {
        userRepository.removeUser(user);
    }
}
