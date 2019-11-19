package dao;

import model.User;
import executor.Executor;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

public class UserDAOJDBCImpl implements UserDAO {
    private Executor executor;

    public UserDAOJDBCImpl(Connection connection) {
        this.executor = new Executor(connection);
    }

    @Override
    public void addUser(User user){
        String query = "INSERT INTO users(name, login, password, role) VALUES ('"+ user.getName() +"', '" + user.getLogin() + "', '" + user.getPassword() + "', '" + user.getRole() + "')";
        executor.executeUpdate(query);
    }

    @Override
    public void deleteUser(User user) {
        String query = "DELETE FROM users WHERE id=" + user.getId();
        executor.executeUpdate(query);
    }

    @Override
    public void updateUser(User user) {
        String query = "UPDATE users SET name='" + user.getName() + "', login='" + user.getLogin() + "', password='" + user.getPassword() + "', role='" + user.getRole() + "' WHERE id=" + user.getId();
        executor.executeUpdate(query);
    }

    @Override
    public User getUserById(Long id) {
        String query = "SELECT * FROM users WHERE id=" + id;
        return executor.executeQuery(query, resultSet -> {
            resultSet.next();
            Long userId = resultSet.getLong(1);
            String userName = resultSet.getString(2);
            String userLogin = resultSet.getString(3);
            String userPassword = resultSet.getString(4);
            String userRole = resultSet.getString(5);
            return new User(userId, userName, userLogin, userPassword, userRole);
        });
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        String query = "SELECT * FROM users WHERE login='" + login +"' AND password='" + password + "'";
        return executor.executeQuery(query, resultSet -> {
            resultSet.next();
            Long userId = resultSet.getLong(1);
            String userName = resultSet.getString(2);
            String userLogin = resultSet.getString(3);
            String userPassword = resultSet.getString(4);
            String userRole = resultSet.getString(5);
            return new User(userId, userName, userLogin, userPassword, userRole);
        });
    }

    @Override
    public List<User> getAllUsers() {
        String query = "SELECT * FROM users";
        return executor.executeQuery(query, resultSet -> {
            List<User> users = new LinkedList<>();
            while (resultSet.next()) {
                Long userId = resultSet.getLong(1);
                String userName = resultSet.getString(2);
                String userLogin = resultSet.getString(3);
                String userPassword = resultSet.getString(4);
                String userRole = resultSet.getString(5);
                users.add(new User(userId, userName, userLogin, userPassword, userRole));
            }
            return users;
        });
    }
}
