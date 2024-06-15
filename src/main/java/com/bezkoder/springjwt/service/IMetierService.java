package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.Metier;

import java.util.List;
import java.util.Optional;

public interface IMetierService {
    List<Metier> retrieveAllMetiers();

    Optional<Metier> retrieveMetier(Long metierId);

    Metier addMetier(Metier metier);

    Metier modifyMetier(Metier metier);

    void removeMetier(Long metierId);
}
