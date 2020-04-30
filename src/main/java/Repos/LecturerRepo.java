package Repos;

import Domain.Lecturer;
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
public class LecturerRepo implements GeneralRepository<Lecturer> {

    int flag;

    @Override
    public int save(Lecturer lecturer) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(lecturer);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public int delete(Lecturer lecturer) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(lecturer);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public List<Lecturer> fetchAll() {
        List<Lecturer> allLecturers = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from lecturer");
            allLecturers = q.list();
            session.close();
        } catch (Exception e) {
        }
        return allLecturers;
    }

    @Override
    public Lecturer fetch(int id) {
        Lecturer lecturer = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            lecturer = (Lecturer) session.get(Lecturer.class, id);
            session.close();
        } catch (Exception e) {
        }
        return lecturer;
    }

    @Override
    public int update(Lecturer lecturer) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(lecturer);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

}
