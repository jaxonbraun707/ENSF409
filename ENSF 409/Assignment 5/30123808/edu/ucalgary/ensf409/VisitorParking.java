package edu.ucalgary.ensf409;

import java.time.LocalDate;
import java.util.*;

public class VisitorParking {

    private HashMap<String, TreeSet<LocalDate>> parkingRecord;

    public VisitorParking() {}

    public VisitorParking(String licence) throws IllegalArgumentException{

    }

    public VisitorParking(String licence, LocalDate date) throws IllegalArgumentException{

    }

    public void addVisitorReservation(String licence) throws IllegalArgumentException{

    }

    public void addVisitorReservation(String licence, LocalDate date) throws IllegalArgumentException{

    }

    public boolean licenceIsRegisteredForDate(String licence) {

        return false;
    }

    public boolean licenceIsRegisteredForDate(String licence, LocalDate date) {

        return false;
    }

    public ArrayList<String> getLicencesRegisteredForDate() {

        ArrayList<String> tmp = new ArrayList<String>();
        return tmp;
    }

    public ArrayList<String> getLicencesRegisteredForDate(LocalDate date) {

        ArrayList<String> tmp = new ArrayList<String>();
        return tmp;
    }

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence) {

        ArrayList<LocalDate> tmp = new ArrayList<LocalDate>();
        return tmp;
    }

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence) {

        ArrayList<LocalDate> tmp = new ArrayList<LocalDate>();
        return tmp;
    }

    public HashMap<String, TreeSet<LocalDate>> getParkingRecord() {

        return this.parkingRecord;
    }

}
