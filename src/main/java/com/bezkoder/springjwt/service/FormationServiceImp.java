package com.bezkoder.springjwt.service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bezkoder.springjwt.models.Formation;
import com.bezkoder.springjwt.models.Metier;
import com.bezkoder.springjwt.repository.FormationRepository;
import com.bezkoder.springjwt.repository.MetierRepository;

@Service
public class FormationServiceImp {

    private final FormationRepository formationRepository;
    private final MetierRepository metierRepository;

    @Autowired
    public FormationServiceImp(FormationRepository formationRepository, MetierRepository metierRepository) {
        this.formationRepository = formationRepository;
        this.metierRepository = metierRepository;
    }

    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    public Formation getFormationById(Long formationId) {
        Optional<Formation> formation = formationRepository.findById(formationId);
        if (formation.isPresent()) {
            return formation.get();
        } else {
            throw new RuntimeException("Formation not found with id: " + formationId);
        }
    }

    public List<Formation> getFormationsByProgramId(Long programId) {
        // Assuming there's a method in your formationRepository to retrieve formations by programId
        return formationRepository.findByProgramFId(programId);
    }

    @Transactional
    public Formation addFormation(Formation formation) {
        Set<Metier> metiers = new HashSet<>();

        for (Metier metier : formation.getMetiers()) {
            metiers.add(metierRepository.findById(metier.getId())
                    .orElseThrow(() -> new RuntimeException("Metier not found with id: " + metier.getId())));
        }
        formation.setMetiers(metiers);
        return formationRepository.save(formation);
    }

    @Transactional
    public Formation updateFormation(Long formationId, Formation formationDetails) {
        Formation formation = formationRepository.findById(formationId)
                .orElseThrow(() -> new RuntimeException("Formation not found with id: " + formationId));

        formation.setEcole(formationDetails.getEcole());
        formation.setTitle(formationDetails.getTitle());
        formation.setFabrication(formationDetails.getFabrication());
        formation.setCritereQualite(formationDetails.getCritereQualite());
        formation.setProgramF(formationDetails.getProgramF());
        formation.setMetiers(formationDetails.getMetiers()); // Update metiers

        return formationRepository.save(formation);
    }

    public void deleteFormation(Long formationId) {
        formationRepository.deleteById(formationId);
    }
}
