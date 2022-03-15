package edu.ucalgary.ensf409;

public class Client {

    private String name;
    private String phoneNumber;
    private String address;
    private RewardsProfile rewardsInfo;

    public Client(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rewardsInfo = new RewardsProfile();
    }

    public boolean enrollRewards(String newNumber) {
        boolean result = false;
        try {
            this.rewardsInfo = new RewardsProfile(newNumber);
            result = true;
        } catch (InvalidRewardsNumException e) {
            result = false;
        }
        return result;
    }

    public int getRewardsPoints() {
        return this.rewardsInfo.getPoints();
    }

    public String getRewardsNumber() {
        return this.rewardsInfo.getnumber();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void updatePoints(int addPoints) {
       this.rewardsInfo.setPoints(addPoints);
    }


}
