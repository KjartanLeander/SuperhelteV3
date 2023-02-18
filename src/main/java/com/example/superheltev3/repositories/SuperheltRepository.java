package com.example.superheltev3.repositories;

import com.example.superheltev3.model.Superhelt;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SuperheltRepository {
    Superhelt superhelt1 = new Superhelt("Batman", "Rig", true, 2000, 2);
    Superhelt superhelt2 = new Superhelt("Superman", "Flyve", false, 1999, 10);
    Superhelt superhelt3 = new Superhelt("Flash", "Hurtig", true, 1998, 4);
    Superhelt superhelt4 = new Superhelt("Spiderman", "Stærk", true, 1997, 3);
    private List<Superhelt> superhelte = new ArrayList<>(List.of(superhelt1,superhelt2,superhelt3,superhelt4));

    public Superhelt createSuperhero(String name, String superpower, boolean human, int introYear, double strengthPoint) {

        Superhelt hero = new Superhelt(name, superpower, human, introYear, strengthPoint);
        superhelte.add(hero);
        return hero;
    }
    public List<Superhelt> deleteSuperhero(String navn) {
        List<Superhelt> søgeResultater;
        søgeResultater = searchSuperhero(navn);
            for (Superhelt superhelt : søgeResultater) {
                getSuperhelte().remove(superhelt);
            }
            return søgeResultater;
        }



    public List<Superhelt> searchSuperhero(String searchTerm) {
        List<Superhelt> searchResult = new ArrayList<>();

        for (Superhelt hero : superhelte) {
            if (hero.getName().toLowerCase().contains(searchTerm.toLowerCase().trim())) {
                searchResult.add(hero);
            }
        }
        return searchResult;
    }
    public List<Superhelt> getSuperhelte() {
        return superhelte;
    }





}
