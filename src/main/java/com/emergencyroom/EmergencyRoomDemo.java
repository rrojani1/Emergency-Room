package com.emergencyroom;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class EmergencyRoomDemo {

    public static void main(String[] args) throws InterruptedException {
        EmergencyRoom eRoom = new EmergencyRoom(new PatientComparator());

        // Check in 5 patients
        eRoom.checkIn(new Patient("Mirabella Jones", LocalDate.of(1973, 7, 11)), Severity.SEVEN);
        TimeUnit.MILLISECONDS.sleep(10);
        eRoom.checkIn(new Patient("Ruth Mendez", LocalDate.of(1965, 1, 22)), Severity.SEVEN);
        TimeUnit.MILLISECONDS.sleep(10);
        eRoom.checkIn(new Patient("Melvin Ingram", LocalDate.of(1965, 1, 22)), Severity.SEVEN);
        TimeUnit.MILLISECONDS.sleep(10);
        eRoom.checkIn(new Patient("Tara Silva", LocalDate.of(1975, 5, 8)), Severity.EIGHT);
        TimeUnit.MILLISECONDS.sleep(10);
        eRoom.checkIn(new Patient("Jeff Barnes", LocalDate.of(1968, 12, 19)), Severity.EIGHT);

        // Admit patients
        Patient patient;
        while ((patient = eRoom.admit()) != null) {
            System.out.println(patient + " admitted");
        }

    }
}