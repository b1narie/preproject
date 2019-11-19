package service;

import dao.UserDAO;
import dao.UserDAOFactory;
import dao.UserDAOHibernateImpl;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserService instance;
    private UserDAO userDAO;

    private UserServiceImpl() {
        this.userDAO = new UserDAOFactory().getFactory();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        return userDAO.getUserByLoginAndPassword(login, password);
    }
}
