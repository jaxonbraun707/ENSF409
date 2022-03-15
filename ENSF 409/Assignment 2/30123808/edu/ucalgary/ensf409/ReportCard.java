package edu.ucalgary.ensf409;

public class ReportCard {

    private Booking REPORT;

    public ReportCard(Booking reportInfo){
        this.REPORT = reportInfo;
    }

    public String printReport() {
        String report = this.REPORT.getCaregiver().getName()
                      + " enjoed taking care of "
                      + this.REPORT.getBookedPet().getName()
                      + ". See you next time!";

        return report;
    }
}