package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.entity.Employee;

public class ManageEmployee {

    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(
                    cfg.getProperties()).build();
            SessionFactory sessionFactory = cfg.buildSessionFactory(registry);

            session = sessionFactory.openSession();
            // tx = session.beginTransaction();

            List<Employee> employees = session.createQuery("From Employee").list();
            for (Employee employee : employees) {
                System.out.println(employee.getName());
            }
            Employee e = new Employee();
            e.setName("Sunil");
            session.persist(e);
            session.flush();
            // tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // tx.rollback();
        } finally {

            session.close();
        }
    }
}
