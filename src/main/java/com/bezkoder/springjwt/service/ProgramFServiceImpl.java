package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.ProgramF;
import com.bezkoder.springjwt.repository.ProgramFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramFServiceImpl implements IProgramFService {

    private final ProgramFRepository programFRepository;

    @Autowired
    public ProgramFServiceImpl(ProgramFRepository programFRepository) {
        this.programFRepository = programFRepository;
    }

    @Override
    public List<ProgramF> retrieveAllPrograms() {
        return programFRepository.findAll();
    }
    
    @Override
    public ProgramF retrieveProgram(Long programId) {
        return programFRepository.findById(programId).orElse(null);
    }

    @Override
    public ProgramF addProgram(ProgramF program) {
        return programFRepository.save(program);
    }

    @Override
    public ProgramF modifyProgram(ProgramF program) {
        return programFRepository.save(program);
    }

    @Override
    public void removeProgram(Long programId) {
        programFRepository.deleteById(programId);
    }

}
