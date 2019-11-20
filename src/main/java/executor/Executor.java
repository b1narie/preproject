package executor;

import util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {

    private Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void executeUpdate(String update) {

        try {
            if (connection.isClosed()){
                connection = DBHelper.getInstance().getConnection();
            }
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute(update);
            connection.commit();
            statement.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                //ignore
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public <T> T executeQuery(String query, ResultHandler<T> handler) {
        try {
            if (connection.isClosed()) {
                connection = DBHelper.getInstance().getConnection();
            }
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            T value = handler.handle(resultSet);
            resultSet.close();
            statement.close();
            return value;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
