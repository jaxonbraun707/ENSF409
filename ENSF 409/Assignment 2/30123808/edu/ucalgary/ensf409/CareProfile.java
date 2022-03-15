package edu.ucalgary.ensf409;

public class CareProfile {

    private String[] medList;
    private String medInstructions;
    private String feedingInstructions;

    public CareProfile(String[] medList, String meds, String feeding) {
        this.medList = medList;
        this.medInstructions = meds;
        this.feedingInstructions = feeding;
    }

    public String summarizeCareInstructions() {
        String careInstructions = "";
        for (int i = 0; i < medList.length; i++) {
            careInstructions += medList[i];
            if (i != medList.length-1) {
                careInstructions += ", ";
            }
        }
        careInstructions += '\n' + medInstructions + '\n' + feedingInstructions;
        return careInstructions;
    }
}