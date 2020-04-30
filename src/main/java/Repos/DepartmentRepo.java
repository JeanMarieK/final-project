package Repos;

import Domain.Department;
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
public class DepartmentRepo implements GeneralRepository<Department> {

    int flag;

    @Override
    public int save(Department department) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public int delete(Department department) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(department);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public List<Department> fetchAll() {
        List<Department> allDepartments = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Department");
            allDepartments = q.list();
            session.close();
        } catch (Exception e) {
        }
        return allDepartments;
    }

    @Override
    public Department fetch(int id) {
        Department department = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            department = (Department) session.get(Department.class, id);
            session.close();
        } catch (Exception e) {
        }
        return department;
    }

    @Override
    public int update(Department department) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(department);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

}
