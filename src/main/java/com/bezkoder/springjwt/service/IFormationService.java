package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.Formation;

import java.util.List;

public interface IFormationService {
    List<Formation> retrieveAllFormations();

    Formation retrieveFormation(Long formationId);

    Formation addFormation(Formation formation);

    Formation modifyFormation(Formation formation);

    void removeFormation(Long formationId);
}
