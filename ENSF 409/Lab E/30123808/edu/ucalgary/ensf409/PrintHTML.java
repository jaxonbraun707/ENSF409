package edu.ucalgary.ensf409;

import java.util.*;

public class PrintHTML implements PrintOutput{

    @Override
    public void printStats(GameCharacter theCharacter) {
        String characterName = theCharacter.characterName;
        String characterClass = theCharacter.getCharacterClass();
        System.out.println("<p>Name: " + characterName + "<br />");
        System.out.println("Life: " + theCharacter.lifeforce + "<br />");
        System.out.println("Class: " + characterClass + "<br />");
        System.out.println("Says: " + theCharacter.talk("I am " + characterName + " the " + characterClass + ".") + "<br />");
        System.out.println("Attack speed: " + theCharacter.getAttackPriority() + "<br />");
        System.out.println("Damage: " + theCharacter.getAttackDamage() + "<br />");
        System.out.println("Attack: " + theCharacter.getAttackMessage() + "</p>");
        
    }

    @Override
    public void printFightLog(ArrayList<String> log) {
        Iterator<String> i = log.iterator();
        System.out.println("<ul>");
        while(i.hasNext()) {
            System.out.println("<li>" + i.next() + "</li>");
        }
        System.out.println("</ul>");

    }

    @Override
    public void printMessage(String message) {
        System.out.println("<p>" + message + "</p>");
        
    }

}

