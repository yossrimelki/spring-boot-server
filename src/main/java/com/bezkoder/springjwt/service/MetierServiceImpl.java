package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.Metier;
import com.bezkoder.springjwt.repository.MetierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetierServiceImpl implements IMetierService {

    private final MetierRepository metierRepository;

    @Autowired
    public MetierServiceImpl(MetierRepository metierRepository) {
        this.metierRepository = metierRepository;
    }

    @Override
    public List<Metier> retrieveAllMetiers() {
        return metierRepository.findAll();
    }

    @Override
    public Optional<Metier> retrieveMetier(Long metierId) {
        return metierRepository.findById(metierId);
    }

    @Override
    public Metier addMetier(Metier metier) {
        return metierRepository.save(metier);
    }

    @Override
    public Metier modifyMetier(Metier metier) {
        return metierRepository.save(metier);
    }

    @Override
    public void removeMetier(Long metierId) {
        metierRepository.deleteById(metierId);
    }
}
