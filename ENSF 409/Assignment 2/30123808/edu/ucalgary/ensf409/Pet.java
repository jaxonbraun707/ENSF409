package edu.ucalgary.ensf409;

public class Pet {

    private String NAME;
    private String SPECIES;
    private String BREED;
    private String COLOUR;
    private boolean vaccineStatus = false;
    private Client owner;
    private EmergVet vet;
    private CareProfile care;

    public Pet(String name, String species, String breed, String colour, Client owner) {
        this.NAME = name;
        this.SPECIES = species;
        this.BREED = breed;
        this.COLOUR = colour;
        this.owner = owner;
    }

    public void setVet(EmergVet vet) {
        this.vet = vet;
    }

    public EmergVet getVet() {
        return this.vet;
    }

    public void updateVaccineStatus(boolean change) {
        this.vaccineStatus = change;
    }

    public boolean getVaccineStatus() {
        return this.vaccineStatus;
    }

    public void setCare(String[] meds, String medInstr, String feedingInstr) {
        CareProfile careProfile = new CareProfile(meds, medInstr, feedingInstr);
        this.care = careProfile;
    }

    public String getCareSummary() {
        return "Care for " + this.NAME + ":\n" + this.care.summarizeCareInstructions();
    }

    public Client getOwner() {
        return this.owner;
    }

    public void setOwner(Client updateOwner) {
        this.owner = updateOwner;
    }

    public String getName() {
        return this.NAME;
    }

    public String getSpecies() {
        return this.SPECIES;
    }

    public String getBreed() {
        return this.BREED;
    }

    public String getColour() {
        return this.COLOUR;
    }






}