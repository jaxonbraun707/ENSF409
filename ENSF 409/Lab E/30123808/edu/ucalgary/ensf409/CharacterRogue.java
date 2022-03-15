package edu.ucalgary.ensf409;

public class CharacterRogue extends GameCharacter{
    private String weapon = "knife";

    public CharacterRogue(String characterName, int attackPriority) {
        super(characterName, "rogue", attackPriority, 10);
    }

    public String getWeapon() { return this.weapon; }

    @Override
    public String talk(String message) {
        return "....(" + message + ")....";
    }

    @Override
    public String getAttackMessage() {
        return super.getCharacterName() + " attacks with their " + this.getWeapon() + ".";
    }
}
