package com.example.superheltev3.services;

import com.example.superheltev3.model.Superhelt;
import com.example.superheltev3.repositories.SuperheltRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheltService {
    private SuperheltRepository superheltRepository;

    public SuperheltService(SuperheltRepository superheltRepository) {
        this.superheltRepository = superheltRepository;
    }

    public List<Superhelt> getSuperhelte() {
        return superheltRepository.getSuperhelte();
    }

    public List<Superhelt> searchForSuperhero(String searchTerm) {
        return superheltRepository.searchSuperhero(searchTerm);
    }

    public Superhelt createSuperHero(String name, String superpower, boolean human, int introyear, double strengthPoint) {
        return superheltRepository.createSuperhero(name, superpower, human, introyear, strengthPoint );
    }

    public List<Superhelt> deleteSuperhero(String navn) {
        return superheltRepository.deleteSuperhero(navn);
    }
}
