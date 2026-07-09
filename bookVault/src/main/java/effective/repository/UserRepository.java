package effective.repository;

import effective.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getUsers();
    User getUser(int index);
    User getById(int id);
    void createUser(User user);
    void removeUser(User user);
}
