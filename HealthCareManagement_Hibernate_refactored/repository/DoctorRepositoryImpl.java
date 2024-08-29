package HealthCareManagement_Hibernate_refactored.repository;

import HealthCareManagement_Hibernate_refactored.Model.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DoctorRepositoryImpl {

    //create a private instance of sessionfactory
    private SessionFactory sessionFactory;

    public DoctorRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createDoctor(Doctor doctor) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(doctor);
        }
    }

    public Doctor getDoctorById(int id) {
        try (Session session = this.sessionFactory.openSession()) {
            return session.get(Doctor.class, id);
        }
    }

    public List<Doctor> getAllDoctors() {
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from Doctor").list();
        }
    }

    public void updateDoctor(Doctor doctor) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(doctor);
            transaction.commit();
        }
    }
    public void deleteDoctorById(int id) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Doctor doctor = session.get(Doctor.class, id);
            session.delete(doctor);
        }
    }

}
