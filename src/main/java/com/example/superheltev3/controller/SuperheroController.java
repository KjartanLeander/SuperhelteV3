package com.example.superheltev3.controller;

import com.example.superheltev3.model.Superhero;
import com.example.superheltev3.services.SuperheroService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("Superhero")
public class SuperheroController {
    private SuperheroService superheroService;
    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @RequestMapping("/")
    public ResponseEntity<?> printSuperhelte(@RequestParam(required = false) String format) {
        List<Superhero> superheroes = superheroService.getSuperheroes();
        if (format != null && format.equals("html")) {
            StringBuilder html = new StringBuilder();
            html.append("<table>");
            html.append("<tr><th>Name</th><th>Superpower</th><th>Human</th><th>IntroYear</th>" +
                    "<th>Is StrengthPoint</tr>");
            for (Superhero superhero : superheroes) {
                html.append("<tr><td>").append(superhero.getName()).append("</td>");
                html.append("<tr><td>").append(superhero.getSuperpower()).append("</td>");
                html.append("<td>").append(superhero.isHuman()).append("</td>");
                html.append("<td>").append(superhero.getIntroYear()).append("</td>");
                html.append("<td>").append(superhero.getStrengthPoint()).append("</td>");
            }

            html.append("</table>");
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type", "text/html");
            return new ResponseEntity<>(html.toString(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(superheroes, HttpStatus.OK);
        }
    }
    @RequestMapping(path = "/{name}")
    public ResponseEntity<List<Superhero>> printSpecifikSuperhero(@PathVariable String name) {
        List<Superhero> searchResults = superheroService.searchForSuperhero(name);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Superhero> createSuperhero(@RequestBody Superhero superhero) {
        Superhero newSuperhero = superheroService.createSuperHero(superhero.getName(), superhero.getSuperpower(), superhero.isHuman(), superhero.getIntroYear(), superhero.getStrengthPoint());
        return new ResponseEntity<Superhero>(newSuperhero, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{name}")
    public ResponseEntity<List<Superhero>> deleteSuperhero(@PathVariable String name) {
        List<Superhero> deletedSuperhero = superheroService.deleteSuperhero(name);
        return new ResponseEntity(deletedSuperhero,HttpStatus.OK);
    }
    @PutMapping(path = {"/edit"})
    public ResponseEntity<Superhero> putMessage(@RequestBody Superhero superhero) {
        superheroService.editSuperhero(superhero,superhero.getName(),superhero.getSuperpower(),superhero.isHuman(),superhero.getIntroYear(),superhero.getStrengthPoint());
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

}




