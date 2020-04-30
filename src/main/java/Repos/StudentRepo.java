package Repos;

import Domain.Student;
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
public class StudentRepo implements GeneralRepository<Student> {

    int flag;

    @Override
    public int save(Student student) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public int delete(Student student) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public List<Student> fetchAll() {
        List<Student> allStudents = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from student");
            allStudents = q.list();
            session.close();
        } catch (Exception e) {
        }
        return allStudents;
    }

    @Override
    public Student fetch(int id) {
        Student student = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            student = (Student) session.get(Student.class, id);
            session.close();
        } catch (Exception e) {
        }
        return student;
    }

    @Override
    public int update(Student student) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

}
