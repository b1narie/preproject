package dao;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import util.DBHelper;
import util.PropertyReader;

public class UserDAOFactory {

    public UserDAO getFactory() {
        if (PropertyReader.readProperties("dao").getProperty("dao.type").equals("hibernate")) {
            Configuration configuration = DBHelper.getInstance().getMySqlConfiguration();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
            builder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = builder.build();
            return new UserDAOHibernateImpl(configuration.buildSessionFactory(serviceRegistry));
        } else {
            return new UserDAOJDBCImpl(DBHelper.getInstance().getConnection());
        }
    }
}
