package service.impl;

import db.Database;
import model.Department;
import model.Doctor;
import model.Hospital;
import service.DoctorService;

import java.util.ArrayList;
import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital h : Database.hospitals) {
            for (Doctor d : h.getDoctors()) {
                if (d.getId().equals(id)) return d;
            }
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital h : Database.hospitals) {
            for (Department d : h.getDepartments()) {
                if (d.getId().equals(departmentId)) {
                    List<Doctor> assigned = new ArrayList<>();
                    for (Long docId : doctorsId) {
                        Doctor doctor = findDoctorById(docId);
                        if (doctor != null) assigned.add(doctor);
                    }
                    d.setDoctors(assigned);
                    return "Doctors assigned";
                }
            }
        }
        return "Department not found";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return Database.hospitals.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst().get().getDoctors();
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Hospital h : Database.hospitals) {
            for (Department d : h.getDepartments()) {
                if (d.getId().equals(id)) return d.getDoctors();
            }
        }
        return null;
    }
}


