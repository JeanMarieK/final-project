package Repos;

import Domain.Faculty;
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
public class FacultyRepo implements GeneralRepository<Faculty> {

    int flag;

    @Override
    public int save(Faculty faculty) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(faculty);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public int delete(Faculty faculty) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(faculty);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public List<Faculty> fetchAll() {
        List<Faculty> allFacultys = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Faculty");
            allFacultys = q.list();
            session.close();
        } catch (Exception e) {
        }
        return allFacultys;
    }

    @Override
    public Faculty fetch(int id) {
        Faculty faculty = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            faculty = (Faculty) session.get(Faculty.class, id);
            session.close();
        } catch (Exception e) {
        }
        return faculty;
    }

    @Override
    public int update(Faculty faculty) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(faculty);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

}
