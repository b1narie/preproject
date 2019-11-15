package executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {

    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void executeUpdate(String update) {
        try {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public <T> T executeQuery(String query, ResultHandler<T> handler) {
        try {
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
        }
    }
}
