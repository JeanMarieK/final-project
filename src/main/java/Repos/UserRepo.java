package Repos;

import Domain.User;
import Interface.GeneralRepository;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JK
 */
@Repository
public class UserRepo implements GeneralRepository<User> {

    int flag;

    @Override
    public int save(User user) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public int delete(User user) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public List<User> fetchAll() {
        List<User> allUsers = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from user");
            allUsers = q.list();
            session.close();
        } catch (Exception e) {
        }
        return allUsers;
    }

    @Override
    public User fetch(int id) {
        User user = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            user = (User) session.get(User.class, id);
            session.close();
        } catch (Exception e) {
        }
        return user;
    }

    @Override
    public int update(User user) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

}
