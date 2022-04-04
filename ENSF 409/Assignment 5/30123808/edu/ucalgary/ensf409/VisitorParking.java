package edu.ucalgary.ensf409;

import java.time.LocalDate;
import java.util.*;

public class VisitorParking {

    private HashMap<String, TreeSet<LocalDate>> parkingRecord;

    public VisitorParking() {
        parkingRecord = new HashMap<String, TreeSet<LocalDate>>();
    }

    public VisitorParking(String licence) throws IllegalArgumentException{
        parkingRecord = new HashMap<String, TreeSet<LocalDate>>();
        licence = Parking.standardizeAndValidateLicence(licence);
        LocalDate date = LocalDate.now();
        TreeSet<LocalDate> treeSet = new TreeSet<LocalDate>();
        treeSet.add(date);
        treeSet = (TreeSet<LocalDate>)treeSet.descendingSet();
        parkingRecord.put(licence, treeSet);
    }

    public VisitorParking(String licence, LocalDate date) throws IllegalArgumentException{
        parkingRecord = new HashMap<String, TreeSet<LocalDate>>();
        licence = Parking.standardizeAndValidateLicence(licence);
        if(date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date to add for this licence plate is in the past");
        }
        TreeSet<LocalDate> treeSet = new TreeSet<LocalDate>();
        treeSet.add(date);
        treeSet = (TreeSet<LocalDate>)treeSet.descendingSet();
        parkingRecord.put(licence, treeSet);
    }

    public void addVisitorReservation(String licence) throws IllegalArgumentException{
        licence = Parking.standardizeAndValidateLicence(licence);
        LocalDate date = LocalDate.now();
        if(getLicencesRegisteredForDate(date).size() >= 2) {
            throw new IllegalArgumentException();
        }
        if (!parkingRecord.containsKey(licence)) {
            TreeSet<LocalDate> treeSet = new TreeSet<LocalDate>();
            treeSet.add(date);
            parkingRecord.put(licence, treeSet);
            return;
        }
        if(licenceIsRegisteredForDate(licence, date)){
            throw new IllegalArgumentException();
        }
        TreeSet<LocalDate> treeSet = parkingRecord.get(licence);
        treeSet.add(date);
        treeSet = (TreeSet<LocalDate>)treeSet.descendingSet();
        parkingRecord.put(licence, treeSet);
    }

    public void addVisitorReservation(String licence, LocalDate date) throws IllegalArgumentException{
        licence = Parking.standardizeAndValidateLicence(licence);
        if(date.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Date to add for this licence plate is in the past");
        }
        ArrayList<String> registeredLicences = getLicencesRegisteredForDate(date);
        if(registeredLicences.size() >= 2) {
            throw new IllegalArgumentException();
        }
        if (!parkingRecord.containsKey(licence)) {
            TreeSet<LocalDate> treeSet = new TreeSet<LocalDate>();
            treeSet.add(date);
            parkingRecord.put(licence, treeSet);
            return;
        }
        if(licenceIsRegisteredForDate(licence, date)){
            throw new IllegalArgumentException();
        }
        TreeSet<LocalDate> treeSet = parkingRecord.get(licence);
        treeSet.add(date);
        treeSet = (TreeSet<LocalDate>)treeSet.descendingSet();
        parkingRecord.put(licence, treeSet);
    }

    public boolean licenceIsRegisteredForDate(String licence) {
        boolean result = false;
        licence = Parking.standardizeAndValidateLicence(licence);
        LocalDate date = LocalDate.now();
        ArrayList<LocalDate> registeredDates = new ArrayList<LocalDate>();
        for(LocalDate dates : parkingRecord.get(licence)) {
            registeredDates.add(dates);
            registeredDates.add(dates.plusDays(1));
            registeredDates.add(dates.plusDays(2));
        }
        if (registeredDates.contains(date)) {
            result = true;
        }
        return result;
    }

    public boolean licenceIsRegisteredForDate(String licence, LocalDate date) {
        boolean result = false;
        licence = Parking.standardizeAndValidateLicence(licence);
        ArrayList<LocalDate> registeredDates = new ArrayList<LocalDate>();
        for(LocalDate dates : parkingRecord.get(licence)) {
            registeredDates.add(dates);
            registeredDates.add(dates.plusDays(1));
            registeredDates.add(dates.plusDays(2));
        }
        if (registeredDates.contains(date)) {
            result = true;
        }
        return result;
    }

    public ArrayList<String> getLicencesRegisteredForDate() {
        ArrayList<String> licencesForDate = new ArrayList<String>();
        LocalDate date = LocalDate.now();
        Set<String> registeredLicenses = parkingRecord.keySet();
        for(String licence : registeredLicenses) {
            if (parkingRecord.get(licence).contains(date)){
                licencesForDate.add(licence);
            }
        }
        return licencesForDate;
    }

    public ArrayList<String> getLicencesRegisteredForDate(LocalDate date) {
        ArrayList<String> licencesForDate = new ArrayList<String>();
        Set<String> registeredLicenses = parkingRecord.keySet();
        for(String licence : registeredLicenses) {
            TreeSet<LocalDate> dates = parkingRecord.get(licence);
            for (LocalDate startDate : dates) {
                if (date.equals(startDate)||date.equals(startDate.plusDays(1))||date.equals(startDate.plusDays(2))){
                    licencesForDate.add(licence);
                    break;
                }
            }
        }
        return licencesForDate;
    }

    public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence) {
        licence = Parking.standardizeAndValidateLicence(licence);
        ArrayList<LocalDate> registeredDates = new ArrayList<LocalDate>();
        for (LocalDate startDate : parkingRecord.get(licence)) {
            registeredDates.add(startDate);
            registeredDates.add(startDate.plusDays(1));
            registeredDates.add(startDate.plusDays(2));
        }
        Collections.sort(registeredDates);
        return registeredDates;
    }

    public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence) {
        licence = Parking.standardizeAndValidateLicence(licence);
        ArrayList<LocalDate> registeredDates = new ArrayList<LocalDate>();
        for (LocalDate startDate : parkingRecord.get(licence)) {
            registeredDates.add(startDate);
        }
        Collections.sort(registeredDates);
        return registeredDates;
    }

    public HashMap<String, TreeSet<LocalDate>> getParkingRecord() {
        return this.parkingRecord;
    }
}
