package com.emergencyroom;

import java.time.LocalTime;
import java.util.Comparator;

public class EmergencyRoom {
    private final Heap<Patient> priorityQueue;

    public EmergencyRoom(Comparator<Patient> comparator) {
        this.priorityQueue = new Heap<>(comparator);
    }

    public void checkIn(Patient patient, Severity severity) {
        patient.setSeverity(severity);
        patient.setArrivalTime(LocalTime.now());
        priorityQueue.add(patient);
    }

    public Patient admit() {
        return priorityQueue.remove();
    }
}
