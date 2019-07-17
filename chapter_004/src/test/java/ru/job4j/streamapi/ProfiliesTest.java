package ru.job4j.streamapi;

/*
   author Evgenii Shegai
   version 0.1
 */


import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfiliesTest {

    @Test
    public void whenGetListAdress() {
        List<Profile> profiles = List.of(new Profile(new Adress("qqq", "www", 1, 12)),
                 new Profile(new Adress("aaa", "sss", 2, 22)));
        List<Adress> result = new Profilies().colect(profiles);
        List<Adress> expect = List.of(new Adress("qqq", "www", 1, 12), new Adress(
                "aaa", "sss", 2, 22));
        assertThat(result, is(expect));

    }

    @Test
    public void whenGetUniqueListAdress() {
        List<Profile> profiles = List.of(new Profile(new Adress("q", "www", 1, 12)), new Profile(new Adress("aaaa", "sss", 2, 22)), new Profile(new Adress(("q"), "www", 1, 12)), new Profile(new Adress(
                        "zz", "sss", 2, 22)));
        List<Adress> result = new Profilies().colect(profiles);
        List<Adress> expect = List.of(new Adress("q", "www", 1, 12), new Adress("zz", "sss", 2, 22), new Adress(
           "aaaa", "sss", 2, 22));
        assertThat(result, is(expect));

    }


}