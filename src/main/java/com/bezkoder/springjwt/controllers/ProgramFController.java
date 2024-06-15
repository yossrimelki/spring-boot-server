package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.ProgramF;
import com.bezkoder.springjwt.service.ProgramFServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/programF")
public class ProgramFController {

    private final ProgramFServiceImpl programFService;

    @Autowired
    public ProgramFController(ProgramFServiceImpl programFService) {
        this.programFService = programFService;
    }


    @GetMapping("/retrieve-all-programs")
    public List<ProgramF> getPrograms() {
        return programFService.retrieveAllPrograms();
    }

    @GetMapping("/retrieve-program/{program-id}")
    public ProgramF retrieveProgram(@PathVariable("program-id") Long programId) {
        return programFService.retrieveProgram(programId);
    }

    @PostMapping("/add-program")
    public ProgramF addProgram(@RequestBody ProgramF program) {

        return programFService.addProgram(program);
    }

    @PutMapping("/modify-program")
    public ProgramF modifyProgram(@RequestBody ProgramF program) {
        return programFService.modifyProgram(program);
    }

    @DeleteMapping("/remove-program/{program-id}")
    public void removeProgram(@PathVariable("program-id") Long programId) {
        programFService.removeProgram(programId);
    }
}
