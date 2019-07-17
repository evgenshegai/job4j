package ru.job4j.streamapi;

/*
   author Evgenii Shegai
   version 0.1
 */


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profilies {

    public List<Adress> colect(List<Profile> profiles) {
        Comparator<Adress> comparator = (s1, s2) -> s1.getCity().length() - s2.getCity().length();
        return profiles.stream().map(Profile::getAdress).sorted(comparator).distinct().collect(Collectors.toList());
    }
}
