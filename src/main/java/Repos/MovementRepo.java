package Repos;

import Domain.Movement;
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
public class MovementRepo implements GeneralRepository<Movement> {

    int flag;

    @Override
    public int save(Movement movement) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(movement);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public int delete(Movement movement) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(movement);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public List<Movement> fetchAll() {
        List<Movement> allMovements = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from movement");
            allMovements = q.list();
            session.close();
        } catch (Exception e) {
        }
        return allMovements;
    }

    @Override
    public Movement fetch(int id) {
        Movement movement = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            movement = (Movement) session.get(Movement.class, id);
            session.close();
        } catch (Exception e) {
        }
        return movement;
    }

    @Override
    public int update(Movement movement) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(movement);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

}
