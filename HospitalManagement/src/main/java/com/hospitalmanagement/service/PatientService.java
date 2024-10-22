package com.hospitalmanagement.service;

import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.exception.PatientNotFoundException;
import com.hospitalmanagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(
                String.format("Patient with id %s not found", id)));
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long patientId, Patient patientInput) {
        Patient patient = getPatientById(patientId);
        patient.setName(patientInput.getName());
        patient.setAge(patientInput.getAge());
        patient.setDoctorId(patientInput.getDoctorId());

        return patientRepository.save(patient);
    }

    public String deletePatient(Long patientId) {
        Patient patient = getPatientById(patientId);
        patientRepository.delete(patient);

        return "Patient with id " + patientId + " deleted";
    }
}
