//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import enums.Gender;
import model.*;
import service.impl.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalServiceImpl hospitalService = new HospitalServiceImpl();
        PatientServiceImpl patientService = new PatientServiceImpl();

        while (true) {
            System.out.println("""
                    1. Hospital кошуу
                    2. Patient кошуу
                    3. Hospital дагы бардык patient тер
                    0. Exit
                    """);

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Hospital id: ");
                    Long id = sc.nextLong();

                    System.out.println("Hospital name: ");
                    String name = sc.next();

                    System.out.print("Address: ");
                    String address = sc.next();

                    Hospital hospital = new Hospital(
                            id, name, address,
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new ArrayList<>()
                    );

                    System.out.println(hospitalService.addHospital(hospital));
                }

                case 2 -> {
                    System.out.print("Hospital id: ");
                    Long hid = sc.nextLong();

                    System.out.print("Patient id: ");
                    Long pid = sc.nextLong();

                    System.out.print("First name: ");
                    String fname = sc.next();

                    System.out.print("Last name: ");
                    String lname = sc.next();

                    System.out.print("Age: ");
                    int age = sc.nextInt();

                    Patient patient = new Patient(
                            pid, fname, lname, age, Gender.MALE
                    );

                    patientService.addPatientsToHospital(hid, List.of(patient));
                    System.out.println("Patient кошулду");
                }

                case 3 -> {
                    System.out.print("Hospital id: ");
                    Long hid = sc.nextLong();
                    System.out.println(
                            hospitalService.getAllPatientFromHospital(hid)
                    );
                }

                case 0 -> {
                    System.out.println("Программа токтотулду");
                    return;
                }

                default -> System.out.println("Туура эмес");
            }
        }
    }
}














