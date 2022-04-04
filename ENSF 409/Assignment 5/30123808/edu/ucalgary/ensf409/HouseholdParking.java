/*
Copyright Ann Barcomb and Emily Marasco, 2021
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.ensf409;
import java.time.LocalDate;
import java.util.*;

public class HouseholdParking extends CalgaryProperty {
    // Each residental property is allowed one street parking permit
    private String residentLicence;
    private VisitorParking visitors = new VisitorParking();

    public HouseholdParking(int taxRollNumber, String zoning, String streetName, int buildingNumber, String postCode, String buildingAnnex) throws IllegalArgumentException {
        super(taxRollNumber,zoning,streetName,buildingNumber,postCode,buildingAnnex);
    }

    public HouseholdParking(int taxRollNumber, String zoning, String streetName, int buildingNumber, String postCode) throws IllegalArgumentException {
        super(taxRollNumber,zoning,streetName,buildingNumber,postCode);
    }

    /*
     * Add a licence to the first empty spot in residentLicence, or replace the most recent
     * Ignore if the licence is already stored
     * @param licence - The licence plate to be added
     * @throws IllegalArgumentException if licence plate isn't a valid Alberta licence
    */
    public void addOrReplaceResidentLicence(String licence) throws IllegalArgumentException {
        licence = Parking.standardizeAndValidateLicence(licence);
        this.residentLicence = licence;
    }

    /*
     * Remove all listed licences
     * @return whether the operation succeeded or not
    */
    public boolean removeResidentLicence() {
        this.residentLicence = "";
        return true;
    }

    /*
     * Remove a specific listed licence 
     * @param licence - the licence to be removed
     * @return whether the operation succeeded or not
    */


    // public boolean removeResidentLicence(String licence) {
    //     // Standardize the licence name. If it is invalid, it can't exist so return false.
    //     try {
    //         licence = Parking.standardizeAndValidateLicence(licence);
    //     }
    //     catch (Exception e) {
    //         return false;
    //     }

    //     for (int i=0; i < this.residentLicence.size(); i++) {
    //         if (licence.equals(this.residentLicence.get(i))) {
    //             this.residentLicence.remove(i);
    //             return true;
    //         }
    //     }

    //     // Couldn't find entry
    //     return false;
    // }
        


    /*
     * Get all the licences stored for the resident
     * @return An array containing the resident's licences
    */
    public String getResidentLicence() {
       return this.residentLicence;
    }

    public VisitorParking getVisitors() {
        return this.visitors;
    }

    public void addVisitorReservation(String licence) {
        visitors.addVisitorReservation(licence);
    }

    public void addVisitorReservation(String licence, LocalDate date) {
        visitors.addVisitorReservation(licence, date);
    }

    public ArrayList<String> getLicencesRegisteredForDate() {
        return visitors.getLicencesRegisteredForDate();
    }

    public ArrayList<String> getLicencesRegisteredForDate(LocalDate date) {
        return visitors.getLicencesRegisteredForDate(date);
    }    

    public boolean licenceIsRegisteredForDate(String licence) {
        return visitors.licenceIsRegisteredForDate(licence);
    }

    public boolean licenceIsRegisteredForDate(String licence, LocalDate date) {
        return visitors.licenceIsRegisteredForDate(licence, date);
    }

    public String getAllDaysLicenceIsRegistered(String licence) {
        return visitors.getAllDaysLicenceIsRegistered(licence).toString();
    }

    public String getStartDaysLicenceIsRegistered(String licence) {
        return visitors.getStartDaysLicenceIsRegistered(licence).toString();
    }

}

