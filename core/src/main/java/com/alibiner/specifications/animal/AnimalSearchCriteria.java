package com.alibiner.specifications.animal;

public class AnimalSearchCriteria {
    private String animalName;
    private String ownerPhone;
    private String ownerMail;


    public AnimalSearchCriteria(String animalName, String ownerPhone, String ownerMail) {
        this.animalName = animalName;
        this.ownerPhone = ownerPhone;
        this.ownerMail = ownerMail;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public String getOwnerMail() {
        return ownerMail;
    }
}
