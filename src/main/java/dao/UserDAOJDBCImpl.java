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

    public void addUser(User user){
        String query = "INSERT INTO users(name, login, password) VALUES ('"+ user.getName() +"', '" + user.getLogin() + "', '" + user.getPassword() + "')";
        executor.executeUpdate(query);
    }

    public void deleteUser(User user) {
        String query = "DELETE FROM users WHERE id=" + user.getId();
        executor.executeUpdate(query);
    }

    public void updateUser(User user) {
        String query = "UPDATE users SET name='" + user.getName() + "', login='" + user.getLogin() + "', password='" + user.getPassword()+ "' WHERE id=" + user.getId();
        executor.executeUpdate(query);
    }

    public User getUserById(Long id) {
        String query = "SELECT * FROM users WHERE id=" + id;
        return executor.executeQuery(query, resultSet -> {
            resultSet.next();
            return new User(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
        });
    }

    public List<User> getAllUsers() {
        String query = "SELECT * FROM users";
        return executor.executeQuery(query, resultSet -> {
            List<User> users = new LinkedList<>();
            while (resultSet.next()) {
                Long userId = resultSet.getLong(1);
                String userName = resultSet.getString(2);
                String userLogin = resultSet.getString(3);
                String userPassword = resultSet.getString(4);
                users.add(new User(userId, userName, userLogin, userPassword));
            }
            return users;
        });
    }
}
