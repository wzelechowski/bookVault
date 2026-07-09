package effective.service;

import effective.model.User;
import effective.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
