package HealthCareManagement_Hibernate_refactored.repository;

import HealthCareManagement_Hibernate_refactored.Model.Appointment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AppointmentRepositoryImpl {

    private SessionFactory sessionFactory;

    public AppointmentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createAppointment(Appointment appointment) {
        try(Session session = this.sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(appointment);
            transaction.commit();
        }
    }

    public List<Appointment> getAllAppointments() {
        try(Session session = this.sessionFactory.openSession()){
            List<Appointment> appointments = session.createQuery("from Appointment").list();
            return appointments;
        }
    }

    public Appointment getAppointmentById(int id) {
        try(Session session = this.sessionFactory.openSession()){
            Appointment appointment = (Appointment) session.get(Appointment.class, id);
            return appointment;
        }
    }

    public void updateAppointment(Appointment appointment) {
        try(Session session = this.sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(appointment);
            transaction.commit();
        }
    }

    public void deleteAppointment(int id) {
        try(Session session = this.sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Appointment appointment = (Appointment) session.get(Appointment.class, id);
            session.delete(appointment);
            transaction.commit();
        }
    }

}
