package ru.job4j.streamapi;

/*
   author Evgenii Shegai
   version 0.1
 */


public class Profile {

    private Adress adress;

    public Profile(Adress adress) {
        this.adress = adress;
    }

    public Adress getAdress() {
        return adress;
    }
}
