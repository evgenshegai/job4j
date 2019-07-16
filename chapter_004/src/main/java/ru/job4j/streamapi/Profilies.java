package ru.job4j.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class Profilies {

    public List<Adress> colect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAdress).collect(Collectors.toList());
    }
}
