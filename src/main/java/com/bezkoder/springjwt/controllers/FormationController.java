package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Formation;
import com.bezkoder.springjwt.service.FormationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formation")
public class FormationController {

    private final FormationServiceImp formationService;

    @Autowired
    public FormationController(FormationServiceImp formationService) {
        this.formationService = formationService;
    }

    @GetMapping("/retrieve-all-formations")
    public List<Formation> getAllFormations() {
        return formationService.getAllFormations();
    }
    @GetMapping("/retrieve-formations-by-program/{program-id}")
    public List<Formation> getFormationsByProgramId(@PathVariable("program-id") Long programId) {
        return formationService.getFormationsByProgramId(programId);
    }

    @GetMapping("/retrieve-formation/{formation-id}")
    public Formation getFormationById(@PathVariable("formation-id") Long formationId) {
        return formationService.getFormationById(formationId);
    }

    @PostMapping("/add-formation")
    public Formation addFormation(@RequestBody Formation formation) {
        return formationService.addFormation(formation);
    }

    @PutMapping("/update-formation/{formation-id}")
    public Formation updateFormation(@PathVariable("formation-id") Long formationId, @RequestBody Formation formationDetails) {
        return formationService.updateFormation(formationId, formationDetails);
    }

    @DeleteMapping("/delete-formation/{formation-id}")
    public void deleteFormation(@PathVariable("formation-id") Long formationId) {
        formationService.deleteFormation(formationId);
    }
}