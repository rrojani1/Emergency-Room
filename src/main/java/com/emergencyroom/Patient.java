package com.emergencyroom;

import java.time.LocalDate;
import java.time.LocalTime;
//import lombok.Data;
//@Data

//import lombok.Getter;
//import lombok.Setter;
//@Getter
//@Setter
public class Patient {
    private final String name;
    private final LocalDate dob;
    private Severity severity;
    private LocalTime arrivalTime;

    public Patient(String name, LocalDate dob) {

        if (name == null || dob == null) {
            throw new IllegalArgumentException("Name and DOB cannot be null.");
        }
        this.name = name;
        this.dob = dob;
    }
    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {

        this.severity = severity;
        //this.severity = severity.ordinal() + 1; // Map Severity to 1-10
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return String.format("\n%s\nDOB=%s\nseverity=%s\narrivalTime=%s ",
                name, dob, severity.name(), arrivalTime);
    }
}
