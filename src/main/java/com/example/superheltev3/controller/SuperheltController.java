package com.example.superheltev3.controller;

import com.example.superheltev3.model.Superhelt;
import com.example.superheltev3.services.SuperheltService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("Superhelt")
public class SuperheltController {
    private SuperheltService superheltService;
    public SuperheltController(SuperheltService superheltService) {
        this.superheltService = superheltService;
    }

    @RequestMapping("/")
    public ResponseEntity<?> printSuperhelte(@RequestParam(required = false) String format) {
        List<Superhelt> superhelte = superheltService.getSuperhelte();
        if (format != null && format.equals("html")) {
            StringBuilder html = new StringBuilder();
            html.append("<table>");
            html.append("<tr><th>Superhero Name</th><th>Real Name</th><th>Creation Year</th><th>Superpower</th>" +
                    "<th>Is Human</th><th>Power</th></tr>");
            for (Superhelt superhelt : superhelte) {
                html.append("<tr><td>").append(superhelt.getName()).append("</td>");
                html.append("<tr><td>").append(superhelt.getSuperpower()).append("</td>");
                html.append("<td>").append(superhelt.isHuman()).append("</td>");
                html.append("<td>").append(superhelt.getIntroYear()).append("</td>");
                html.append("<td>").append(superhelt.getStrengthPoint()).append("</td>");
            }

            html.append("</table>");
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type", "text/html");
            return new ResponseEntity<>(html.toString(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(superhelte, HttpStatus.OK);
        }
    }
    @RequestMapping(path = "/{navn}")
    public ResponseEntity<List<Superhelt>> printSpecifikSuperhelt(@PathVariable String navn) {
        List<Superhelt> searchResults = superheltService.searchForSuperhero(navn);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @PostMapping(path = "/opret")
    public ResponseEntity<Superhelt> opretSuperhelt(@RequestBody Superhelt superhelt) {
        Superhelt newSuperhelt = superheltService.createSuperHero(superhelt.getName(), superhelt.getSuperpower(), superhelt.isHuman(), superhelt.getIntroYear(), superhelt.getStrengthPoint());
        return new ResponseEntity<Superhelt>(newSuperhelt, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/slet/{navn}")
    public ResponseEntity<List<Superhelt>> sletSuperhelt(@PathVariable String navn) {
        List<Superhelt> slettetSuperhelt = superheltService.deleteSuperhero(navn);
        return new ResponseEntity(slettetSuperhelt,HttpStatus.OK);
    }
}




