package HealthCareManagement_Hibernate_refactored.Service;

import HealthCareManagement_Hibernate_refactored.Model.Appointment;
import HealthCareManagement_Hibernate_refactored.repository.AppointmentRepositoryImpl;

import java.util.List;

public class AppointmentService {

    private final AppointmentRepositoryImpl appointmentRepository;

    public AppointmentService(AppointmentRepositoryImpl appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void createAppointment(Appointment appointment) {
        appointmentRepository.createAppointment(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAllAppointments();
    }
    public Appointment getAppointmentById(int id) {
        return appointmentRepository.getAppointmentById(id);
    }
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.updateAppointment(appointment);
    }
    public void deleteAppointment(int id) {
        appointmentRepository.deleteAppointment(id);
    }
}
