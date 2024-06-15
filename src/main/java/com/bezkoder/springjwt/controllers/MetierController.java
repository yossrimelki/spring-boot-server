package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Metier;
import com.bezkoder.springjwt.service.MetierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metier")
public class MetierController {

    private final MetierServiceImpl metierService;

    @Autowired
    public MetierController(MetierServiceImpl metierService) {
        this.metierService = metierService;
    }

    @GetMapping("/retrieve-metier/{metierId}")
    public ResponseEntity<Metier> retrieveMetier(@PathVariable Long metierId) {
        Optional<Metier> metier = metierService.retrieveMetier(metierId);
        return metier.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add-metier")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Metier> addMetier(@Valid @RequestBody Metier metier) {
        Metier newMetier = metierService.addMetier(metier);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMetier);
    }

    @PutMapping("/modify-metier")
    public ResponseEntity<Metier> modifyMetier(@Valid @RequestBody Metier metier) {
        Metier updatedMetier = metierService.modifyMetier(metier);
        return ResponseEntity.ok(updatedMetier);
    }

    @DeleteMapping("/remove-metier/{metierId}")
    public ResponseEntity<Void> removeMetier(@PathVariable Long metierId) {
        metierService.removeMetier(metierId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/retrieve-all-metiers")
    public ResponseEntity<List<Metier>> retrieveAllMetiers() {
        List<Metier> metiers = metierService.retrieveAllMetiers();
        if (metiers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(metiers);
        }
    }
}
