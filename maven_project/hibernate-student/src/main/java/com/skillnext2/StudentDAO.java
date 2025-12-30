package com.skillnext2;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {

    // INSERT
    public void insert(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(student);

        tx.commit();
        session.close();
    }

    // READ ALL
    public List<Student> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> list = session.createQuery("from Student", Student.class).list();
        session.close();
        return list;
    }

    // UPDATE
    public void update(int id, int sem) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s = session.get(Student.class, id);
        if (s != null) {
            s.setSem(sem);
        }

        tx.commit();
        session.close();
    }

    // DELETE
    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student s = session.get(Student.class, id);
        if (s != null) {
            session.remove(s);
        }

        tx.commit();
        session.close();
    }
}
