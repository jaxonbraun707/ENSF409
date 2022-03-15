package edu.ucalgary.ensf409;

public class RewardsProfile {

    private String rewardsNum = "Not enrolled";
    private int pointsTotal = 10;

    public RewardsProfile() {
    }

    public RewardsProfile(String newNumber) throws InvalidRewardsNumException {
        if (newNumber.matches("[0-9]+")){
            this.rewardsNum = newNumber;  
        }
        else {
            throw new InvalidRewardsNumException();
         }
    }

    public void setPoints(int addPoints) {
        this.pointsTotal += addPoints;
    }

    public int getPoints() {
        return this.pointsTotal;
    }

    public String getnumber() {
        return this.rewardsNum;
    }
}