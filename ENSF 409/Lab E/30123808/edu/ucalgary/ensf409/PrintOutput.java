package edu.ucalgary.ensf409;

import java.util.*;

public interface PrintOutput {
    public abstract void printStats(GameCharacter theCharacter);
    public abstract void printFightLog(ArrayList<String> log);
    public abstract void printMessage(String message);
}
