package ru.job4j.streamapi;

/*
   author Evgenii Shegai
   version 0.1
 */


import java.util.Objects;

public class Adress  {

    private String city;
    private String street;
    private int home;
    private int apartment;

    public Adress(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Adress adress = (Adress) o;
        return home == adress.home && apartment == adress.apartment && Objects.equals(city, adress.city) && Objects.equals(street, adress.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}
