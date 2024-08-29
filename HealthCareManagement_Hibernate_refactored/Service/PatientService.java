package HealthCareManagement_Hibernate_refactored.Service;

import HealthCareManagement_Hibernate_refactored.Model.Patient;
import HealthCareManagement_Hibernate_refactored.repository.PatientRepositoryImpl;

import java.util.List;

public class PatientService {

    private final PatientRepositoryImpl patientRepository;


    public PatientService(PatientRepositoryImpl patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void createPatient(Patient patient) {
        patientRepository.createPatient(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.getAllPatients();
    }

    public Patient getPatientById(int id) {
        return patientRepository.getPatientById(id);
    }

    public void updatePatient(Patient patient) {
        patientRepository.updatePatient(patient);
    }

    public void deletePatient(int id) {
        patientRepository.deletePatient(id);
    }


}
