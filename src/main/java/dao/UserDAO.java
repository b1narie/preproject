package dao;

import model.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserById(Long id);

    User getUserByLoginAndPassword(String login, String password);

    List<User> getAllUsers();
}
