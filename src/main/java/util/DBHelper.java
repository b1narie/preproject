package util;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBHelper {

    private static Connection connection;
    private static Configuration configuration;
    private static DBHelper instance;

    private DBHelper() {}

    public static DBHelper getInstance() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }

    @SuppressWarnings("UnusedDeclaration")
    public Configuration getMySqlConfiguration() {
        configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        Properties properties = PropertyReader.readProperties("hibernate");
        configuration.setProperties(properties);
        return configuration;
    }

    public Connection getConnection() {
        Properties properties = PropertyReader.readProperties("jdbc");
        try {
            Class.forName(properties.getProperty("jdbc.driver_class"));
            connection = DriverManager.getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}