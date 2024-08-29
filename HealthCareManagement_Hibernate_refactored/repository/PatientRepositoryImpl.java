package HealthCareManagement_Hibernate_refactored.repository;

import HealthCareManagement_Hibernate_refactored.Model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PatientRepositoryImpl {

    private SessionFactory sessionFactory;

    public PatientRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //create a Patient and save it in the DB as a transaction
    public void createPatient(Patient patient) {
        try(Session session = this.sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(patient);
            transaction.commit();
        }
    }

    //reading data from the DB is not a transaction
    public Patient getPatientById(int id) {
        try(Session session = this.sessionFactory.openSession()){
            return session.get(Patient.class, id);
        }
    }

    // update the patient in the DB
    public void updatePatient(Patient patient) {
        try(Session session = this.sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(patient);
            transaction.commit();
        }
    }

    //delete from DB
    public void deletePatient(int id) {
        try(Session session = this.sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(getPatientById(id));
            transaction.commit();
        }
    }

    public List<Patient> getAllPatients() {
        try(Session session = this.sessionFactory.openSession()){
            return session.createQuery("from Patient").list();
        }
    }

}
