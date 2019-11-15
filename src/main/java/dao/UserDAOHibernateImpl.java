package dao;

import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAOHibernateImpl implements UserDAO {

    private Session session;
    private SessionFactory factory;

    public UserDAOHibernateImpl(SessionFactory factory){
        this.factory = factory;
    }

    public void addUser(User user) {
        try {
            session = factory.openSession();
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

    public void deleteUser(User user) {
        try {
            session = factory.openSession();
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

    public void updateUser(User user) {
        try {
            session = factory.openSession();
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

    public User getUserById(Long id) {
        session = factory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        session = factory.openSession();
        List<User> users = session.createQuery("FROM User", User.class).list();
        session.close();
        return users;
    }
}
