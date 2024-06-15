package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.ProgramF;

import java.util.List;

public interface IProgramFService {
    List<ProgramF> retrieveAllPrograms();

    ProgramF retrieveProgram(Long programId);

    ProgramF addProgram(ProgramF program);

    ProgramF modifyProgram(ProgramF program);

    void removeProgram(Long programId);
}
