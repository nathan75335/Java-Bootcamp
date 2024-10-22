package com.hospitalmanagement.service;

import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.exception.DoctorNotFoundException;
import com.hospitalmanagement.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Doctor getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException(
                        String.format("The doctor with id %s was not", doctorId)));
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long doctorId, Doctor doctorInput) {
        Doctor doctor = getDoctorById(doctorId);
        doctor.setName(doctorInput.getName());
        return doctorRepository.save(doctor);
    }
    public String deleteDoctor(Long doctorId) {
        Doctor doctor = getDoctorById(doctorId);
        doctorRepository.delete(doctor);

        return "doctor deleted";
    }
}
