package effective.service;

import effective.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUser(int index);
    User getById(int id);
    void addUser(User user);
    void removeUser(User user);
}
