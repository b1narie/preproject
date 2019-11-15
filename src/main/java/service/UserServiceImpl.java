package service;

import dao.UserDAO;
import dao.UserDAOFactory;
import dao.UserDAOHibernateImpl;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

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

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
