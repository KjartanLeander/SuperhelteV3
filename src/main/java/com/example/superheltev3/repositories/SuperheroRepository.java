package com.example.superheltev3.repositories;

import com.example.superheltev3.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepository {
    Superhero superhero1 = new Superhero("Batman", "Rich", true, 2000, 2);
    Superhero superhero2 = new Superhero("Superman", "Flying", false, 1999, 10);
    Superhero superhero3 = new Superhero("Flash", "Fast", true, 1998, 4);
    Superhero superhero4 = new Superhero("Spiderman", "Strong", true, 1997, 3);
    private List<Superhero> superheroes = new ArrayList<>(List.of(superhero1, superhero2, superhero3, superhero4));
    public Superhero createSuperhero(String name, String superpower, boolean human, int introYear, double strengthPoint) {
        Superhero hero = new Superhero(name, superpower, human, introYear, strengthPoint);
        superheroes.add(hero);
        return hero;
    }
    public List<Superhero> deleteSuperhero(String name) {
        List<Superhero> SearchResults;
        SearchResults = searchSuperhero(name);
            for (Superhero superhero : SearchResults) {
                getSuperhelte().remove(superhero);
            }
            return SearchResults;
        }

    public List<Superhero> searchSuperhero(String searchTerm) {
        List<Superhero> searchResult = new ArrayList<>();

        for (Superhero hero : superheroes) {
            if (hero.getName().toLowerCase().contains(searchTerm.toLowerCase().trim())) {
                searchResult.add(hero);
            }
        }
        return searchResult;
    }
    public List<Superhero> getSuperhelte() {
        return superheroes;
    }



}
