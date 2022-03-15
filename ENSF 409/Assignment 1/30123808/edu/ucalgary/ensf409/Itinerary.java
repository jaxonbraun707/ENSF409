package edu.ucalgary.ensf409;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2022
All rights reserved.
*/

public class Itinerary {
    private Trip[] trips = new Trip[20];

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
        String outString = value + " (" + key + ")";
        return outString;
    }

    // Constructor
    public Itinerary(String[][] myTrips) {
        for (int i = 0; i < myTrips.length; i++) {
            trips[i] = new Trip(myTrips[i]);
        }
    }

    // Getter
    public Trip[] getTrips() {
        return trips;
    }

    public String formatByArrival() {
        String outputString = "";
        int tripIndex = 0;
        int tmpYear = 0;
        while (tripIndex < trips.length && trips[tripIndex] != null) {
            int year = Trip.getYear(trips[tripIndex].getArrival());
            int month = Trip.getMonth(trips[tripIndex].getArrival());

            if (year != tmpYear && tripIndex == 0) {
                outputString += fmtString("Year", String.valueOf(year));
            }
            else if (year != tmpYear) {
                outputString += '\n' + fmtString("Year", String.valueOf(year));

            }
            outputString += "\n--" + fmtString("Month", String.valueOf(month));
            
            int tmpMonth = month;

            while (tmpMonth == month){
                outputString += "\n----" + fmtString("City", trips[tripIndex].getCity()) + ", " + fmtString("Country", trips[tripIndex].getCountry()) + " (Place)";
                tripIndex++;
                if (tripIndex >= trips.length || trips[tripIndex] == null) {
                    return outputString;
                }

                else{
                    tmpMonth = Trip.getMonth(trips[tripIndex].getArrival());
                }
            }
            tmpYear = year;
        }
        return outputString;
    }

    // The first array holds years (2021-2023).
    // The second array holds months.
    // The third array holds formatted locations occurring in the year/month
    String[][][] byDate() {
        String[][][] dateArray = new String[3][12][1];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 12; j++) {
                dateArray[i][j][0] = "null";
            }
        }
        int tripIndex = 0;
        for (int year = 0; year < 3; year++) {
            for (int month = 1; month < 13; month++) {
                if (trips[tripIndex] == null) {
                    return dateArray;
                }
                if ((Trip.getMonth(trips[tripIndex].getArrival()) == month) && (Trip.getYear(trips[tripIndex].getArrival()) == year + 2021)) {
                    dateArray[year][month-1][0] = Trip.fmtString("City", trips[tripIndex].getCity()) + ", " + Trip.fmtString("Country", trips[tripIndex].getCountry());
                    for (int i = tripIndex; (Trip.getMonth(trips[i].getArrival()) == month); i++) {
                        tripIndex++;
                        if (trips[tripIndex] == null) {
                            return dateArray;
                        }
                    }
                }
            }
        }
        return dateArray;
    }



}
