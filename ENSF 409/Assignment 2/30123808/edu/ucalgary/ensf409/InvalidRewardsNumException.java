package edu.ucalgary.ensf409;

public class InvalidRewardsNumException extends Exception {
    public InvalidRewardsNumException() {
        super("Rewards number must be only digits and must be 7 digits long");
    }
}
