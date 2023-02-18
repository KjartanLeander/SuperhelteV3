package com.example.superheltev3.services;

import com.example.superheltev3.model.Superhero;
import com.example.superheltev3.repositories.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheroService {
    private SuperheroRepository superheroRepository;

    public SuperheroService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    public List<Superhero> getSuperheroes() {
        return superheroRepository.getSuperhelte();
    }

    public List<Superhero> searchForSuperhero(String searchTerm) {
        return superheroRepository.searchSuperhero(searchTerm);
    }

    public Superhero createSuperHero(String name, String superpower, boolean human, int introyear, double strengthPoint) {
        return superheroRepository.createSuperhero(name, superpower, human, introyear, strengthPoint );
    }

    public List<Superhero> deleteSuperhero(String name) {
        return superheroRepository.deleteSuperhero(name);
    }
    public void editSuperhero(Superhero superhero, String newName, String newSuperpower, boolean newHuman, int newIntroYear, double newStrengthPoint) {
        superheroRepository.editSuperhero(superhero, newName, newSuperpower, newHuman, newIntroYear, newStrengthPoint);
    }
}
