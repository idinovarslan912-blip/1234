package model;

import java.util.List;

public class Department {
    private Long id;
    private String departmentName;
    private List<Doctor> doctors;

    public Department(Long id, String departmentName, List<Doctor> doctors) {
        this.id = id;
        this.departmentName = departmentName;
        this.doctors = doctors;
    }

    public Long getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}





