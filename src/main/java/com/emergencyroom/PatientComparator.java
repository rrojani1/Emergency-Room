package com.emergencyroom;

import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        int severityComparison = p2.getSeverity().compareTo(p1.getSeverity());
        if (severityComparison != 0) {
            return severityComparison;
        }

        int ageComparison = p1.getDob().compareTo(p2.getDob());
        if (ageComparison != 0) {
            return ageComparison;
        }

        return p1.getArrivalTime().compareTo(p2.getArrivalTime());
    }
}

