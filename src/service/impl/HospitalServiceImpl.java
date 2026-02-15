package service.impl;

import db.Database;
import model.Hospital;
import model.Patient;
import service.HospitalService;

import java.util.*;

public class HospitalServiceImpl implements HospitalService {

    @Override
    public String addHospital(Hospital hospital) {
        Database.hospitals.add(hospital);
        return "Hospital added";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return Database.hospitals.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return Database.hospitals;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return findHospitalById(id).getPatients();
    }

    @Override
    public String deleteHospitalById(Long id) {
        Database.hospitals.removeIf(h -> h.getId().equals(id));
        return "Deleted";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> map = new HashMap<>();
        for (Hospital h : Database.hospitals) {
            if (h.getAddress().equalsIgnoreCase(address)) {
                map.put(h.getHospitalName(), h);
            }
        }
        return map;
    }
}
