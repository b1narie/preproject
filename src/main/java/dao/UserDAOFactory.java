package dao;

import util.DBHelper;
import util.PropertyReader;

public class UserDAOFactory {

    public UserDAO getFactory() {
        PropertyReader.readProperties();

        if (PropertyReader.readProperty("dao.type").equals("hibernate")) {
            return new UserDAOHibernateImpl(DBHelper.getInstance().getSessionFactory());
        } else {
            return new UserDAOJDBCImpl(DBHelper.getInstance().getConnection());
        }
    }
}
