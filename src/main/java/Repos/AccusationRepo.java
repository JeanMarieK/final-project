/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repos;

import Domain.Accusation;
import Interface.GeneralRepository;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author JK
 */
public class AccusationRepo implements GeneralRepository<Accusation>{
    
    int flag;

    @Override
    public int save(Accusation accusation) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(accusation);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public int delete(Accusation accusation) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(accusation);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    public List<Accusation> fetchAll() {
        List<Accusation> allAccusations = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from accusation");
            allAccusations = q.list();
            session.close();
        } catch (Exception e) {
        }
        return allAccusations;
    }

    @Override
    public Accusation fetch(int id) {
        Accusation accusation = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            accusation = (Accusation) session.get(Accusation.class, id);
            session.close();
        } catch (Exception e) {
        }
        return accusation;
    }

    @Override
    public int update(Accusation accusation) {
        flag = 0;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(accusation);
            session.getTransaction().commit();
            flag = 1;
            session.close();
        } catch (Exception e) {
        }
        return flag;
    }
}
