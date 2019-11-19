package dao;

import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOHibernateImpl implements UserDAO {

    private SessionFactory factory;

    public UserDAOHibernateImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void addUser(User user) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteUser(User user) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void updateUser(User user) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public User getUserById(Long id) {
        Session session = factory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        Session session = factory.openSession();
        Query<User> query = session.createQuery("FROM User user WHERE user.login =: login AND user.password =: password", User.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        User user = query.getSingleResult();
        session.close();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = factory.openSession();
        List<User> users = session.createQuery("FROM User", User.class).list();
        session.close();
        return users;
    }
}
