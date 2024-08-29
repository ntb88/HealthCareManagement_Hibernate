package HealthCareManagement_Hibernate_refactored;

import HealthCareManagement_Hibernate_refactored.Model.Appointment;
import HealthCareManagement_Hibernate_refactored.Model.Doctor;
import HealthCareManagement_Hibernate_refactored.Model.Patient;
import HealthCareManagement_Hibernate_refactored.Service.AppointmentService;
import HealthCareManagement_Hibernate_refactored.Service.DoctorService;
import HealthCareManagement_Hibernate_refactored.Service.PatientService;
import HealthCareManagement_Hibernate_refactored.repository.AppointmentRepositoryImpl;
import HealthCareManagement_Hibernate_refactored.repository.DoctorRepositoryImpl;
import HealthCareManagement_Hibernate_refactored.repository.PatientRepositoryImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //build session
        SessionFactory sessionFactory = new Configuration().configure("HealthCareManagement_Hibernate_refactored.cfg.xml").buildSessionFactory();

        PatientRepositoryImpl patientRepository  = new PatientRepositoryImpl(sessionFactory);
        DoctorRepositoryImpl doctorRepository  = new DoctorRepositoryImpl(sessionFactory);
        AppointmentRepositoryImpl appointmentRepository = new AppointmentRepositoryImpl(sessionFactory);

        PatientService patientService = new PatientService(patientRepository);
        DoctorService doctorService = new DoctorService(doctorRepository);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("1. Manage Patients");
        System.out.println("2. Manage Doctors");
        System.out.println("3. Manage Appointments");
        choice = scanner.nextInt();
        scanner.nextLine();
        try {
            switch (choice) {
                case 1:
                    managePatients(patientService, scanner);
                    break;
                case 2:
                    manageDoctors(doctorService, scanner);
                    break;
                case 3:
                    manageAppointments(appointmentService, scanner);
                    break;
            }

        } finally {
            scanner.close();
        }

    }


    // patient management
    private static void managePatients(PatientService patientService, Scanner scanner){
        System.out.println("1. Create Patient");
        System.out.println("2. Read Patient");
        System.out.println("3. Update Patient");
        System.out.println("4. Delete Patient");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // Create Patient
                Patient newPatient = new Patient();
                System.out.print("Enter first name: ");
                newPatient.setFirstName(scanner.nextLine());
                System.out.print("Enter last name: ");
                newPatient.setLastName(scanner.nextLine());
                System.out.print("Enter date of birth (YYYY-MM-DD): ");
                newPatient.setDateOfBirth(scanner.nextLine());
                System.out.print("Enter email: ");
                newPatient.setEmail(scanner.nextLine());
                System.out.print("Enter phone number: ");
                newPatient.setPhoneNumber(scanner.nextLine());
                patientService.createPatient(newPatient);
                System.out.println("Patient created successfully.");
                break;
            case 2:
                // Read Patient
                System.out.print("Enter Patient ID: ");
                int patientId = scanner.nextInt();
                Patient patient = patientService.getPatientById(patientId);
                if (patient != null) {
                    System.out.println("Patient ID: " + patient.getPatientId());
                    System.out.println("Name: " + patient.getFirstName() + " " + patient.getLastName());
                    System.out.println("Date of Birth: " + patient.getDateOfBirth());
                    System.out.println("Email: " + patient.getEmail());
                    System.out.println("Phone: " + patient.getPhoneNumber());
                } else {
                    System.out.println("Patient not found.");
                }
                break;
            case 3:
                // Update Patient
                System.out.print("Enter Patient ID: ");
                patientId = scanner.nextInt();
                scanner.nextLine();  // consume newline
                patient = patientService.getPatientById(patientId);
                if (patient != null) {
                    System.out.print("Enter new first name: ");
                    patient.setFirstName(scanner.nextLine());
                    System.out.print("Enter new last name: ");
                    patient.setLastName(scanner.nextLine());
                    System.out.print("Enter new date of birth (YYYY-MM-DD): ");
                    patient.setDateOfBirth(scanner.nextLine());
                    System.out.print("Enter new email: ");
                    patient.setEmail(scanner.nextLine());
                    System.out.print("Enter new phone number: ");
                    patient.setPhoneNumber(scanner.nextLine());
                    patientService.updatePatient(patient);
                    System.out.println("Patient updated successfully.");
                } else {
                    System.out.println("Patient not found.");
                }
                break;
            case 4:
                // Delete Patient
                System.out.print("Enter Patient ID: ");
                patientId = scanner.nextInt();
                patientService.deletePatient(patientId);
                System.out.println("Patient deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void manageDoctors(DoctorService doctorService, Scanner scanner){
        System.out.println("1. Create Doctor");
        System.out.println("2. Read Doctor");
        System.out.println("3. Update Doctor");
        System.out.println("4. Delete Doctor");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // Create Patient
                Doctor newDoctor = new Doctor();
                System.out.print("Enter first name: ");
                newDoctor.setFirstName(scanner.nextLine());
                System.out.print("Enter last name: ");
                newDoctor.setLastName(scanner.nextLine());
                System.out.print("Enter specialty: ");
                newDoctor.setSpecialty(scanner.nextLine());
                System.out.print("Enter email: ");
                newDoctor.setEmail(scanner.nextLine());
                doctorService.createDoctor(newDoctor);
                System.out.println("Doctor created successfully.");
                break;
            case 2:
                // Read Patient
                System.out.print("Enter Doctor ID: ");
                int doctorId = scanner.nextInt();
                // use the getDoctorById method from DoctorDAO
                // and us that doctor object
                Doctor doctor = doctorService.getDoctorById(doctorId);
                //if the object is not null
                if (doctor != null) {
                    System.out.println("Doctor ID: " + doctor.getDoctorId());
                    System.out.println("Name: " + doctor.getFirstName() + " " + doctor.getLastName());
                    System.out.println("Specialty: " + doctor.getSpecialty());
                    System.out.println("Email: " + doctor.getEmail());

                } else {
                    System.out.println("doctor not found.");
                }
                break;
            case 3:
                // Update Doctor
                System.out.print("Enter doctor ID: ");
                doctorId = scanner.nextInt();
                scanner.nextLine();  // consume newline
                doctor = doctorService.getDoctorById(doctorId);
                if (doctor != null) {
                    System.out.print("Enter new first name: ");
                    doctor.setFirstName(scanner.nextLine());
                    System.out.print("Enter new last name: ");
                    doctor.setLastName(scanner.nextLine());
                    System.out.print("Enter new specialty: ");
                    doctor.setSpecialty(scanner.nextLine());
                    System.out.print("Enter new email: ");
                    doctor.setEmail(scanner.nextLine());

                    doctorService.updateDoctor(doctor);
                    System.out.println("Doctor updated successfully.");
                } else {
                    System.out.println("Doctor not found.");
                }
                break;
            case 4:
                // Delete Patient
                System.out.print("Enter Doctor ID: ");
                doctorId = scanner.nextInt();
                doctorService.deleteDoctorById(doctorId);
                System.out.println("Doctor deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void manageAppointments(AppointmentService appointmentService, Scanner scanner){
        System.out.println("1. Create Appointment");
        System.out.println("2. Read Appointment");
        System.out.println("3. Update Appointment");
        System.out.println("4. Delete Appointment");
        System.out.println("5. Display all Appointments");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // Create Appointment
                Appointment newAppointment = new Appointment();
                System.out.print("Enter patient id: ");
                newAppointment.setPatientId(scanner.nextInt());
                System.out.print("Enter doctor id: ");
                newAppointment.setDoctorId(scanner.nextInt());
                System.out.print("Enter appointment date: ");
                newAppointment.setAppointmentDate(scanner.next());
                System.out.print("Enter appointment notes: ");
                newAppointment.setNotes(scanner.nextLine());
                appointmentService.createAppointment(newAppointment);
                System.out.println("Appointment created successfully.");
                break;
            case 2:
                // Read Appointment
                System.out.print("Enter Appointment ID: ");
                int appointmentId = scanner.nextInt();
                Appointment appt = appointmentService.getAppointmentById(appointmentId);
                if (appt != null) {
                    System.out.println("Appintment ID: " + appt.getAppointmentId());
                    System.out.println("Patient ID: " + appt.getPatientId());
                    System.out.println("Doctor ID: " + appt.getDoctorId());
                    System.out.println("Appointment date: " + appt.getAppointmentDate());
                    System.out.println("Appointment notes: " + appt.getNotes());
                } else {
                    System.out.println("Appointment not found.");
                }
                break;
            case 3:
                // Update Appointment
                System.out.print("Enter Appointment ID: ");
                appointmentId = scanner.nextInt();
                scanner.nextLine();  // consume newline
                Appointment appointment = appointmentService.getAppointmentById(appointmentId);
                if (appointment != null) {
                    System.out.print("Enter patient id: ");
                    appointment.setPatientId(scanner.nextInt());
                    System.out.print("Enter doctor id: ");
                    appointment.setDoctorId(scanner.nextInt());
                    System.out.print("Enter appointment date: ");
                    appointment.setAppointmentDate(scanner.next());
                    System.out.print("Enter appointment notes: ");
                    appointment.setNotes(scanner.next());
                    appointmentService.updateAppointment(appointment);
                    System.out.println("Appointment updated successfully.");
                } else {
                    System.out.println("Appointment not found.");
                }
                break;
            case 4:
                // Delete Patient
                System.out.print("Enter Appointment ID: ");
                appointmentId = scanner.nextInt();
                appointmentService.deleteAppointment(appointmentId);
                System.out.println("Appointment deleted successfully.");
                break;
            case 5:
                //Print all
                List<Appointment> appointments = appointmentService.getAllAppointments();
                appointments.forEach((appts) -> System.out.println(appts.toString()));
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}



