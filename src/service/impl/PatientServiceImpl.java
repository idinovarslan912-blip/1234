package service.impl;

import db.Database;
import model.Hospital;
import model.Patient;
import service.PatientService;

import java.util.*;

public class PatientServiceImpl implements PatientService {

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital h : Database.hospitals) {
            if (h.getId().equals(id)) {
                h.getPatients().addAll(patients);
                return "Patients added";
            }
        }
        return "Hospital not found";
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital h : Database.hospitals) {
            for (Patient p : h.getPatients()) {
                if (p.getId().equals(id)) return p;
            }
        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        Map<Integer, Patient> map = new HashMap<>();
        for (Hospital h : Database.hospitals) {
            for (Patient p : h.getPatients()) {
                map.put(p.getAge(), p);
            }
        }
        return map;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> list = new ArrayList<>();
        Database.hospitals.forEach(h -> list.addAll(h.getPatients()));

        list.sort(Comparator.comparingInt(Patient::getAge));
        if (ascOrDesc.equalsIgnoreCase("desc")) {
            Collections.reverse(list);
        }
        return list;
    }
}
