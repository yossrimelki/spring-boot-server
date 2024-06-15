// GrillePolyvalenceServiceImpl.java

package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.GrillePolyvalence;
import com.bezkoder.springjwt.models.Metier;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.GrillePolyvalenceDTO;
import com.bezkoder.springjwt.repository.GrillePolyvalenceRepository;
import com.bezkoder.springjwt.repository.MetierRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class GrillePolyvalenceServiceImpl implements IGrillePolyvalenceService {

    private final GrillePolyvalenceRepository grillePolyvalenceRepository;
    private final UserRepository userRepository;
    private final MetierRepository metierRepository;

    @Autowired
    public GrillePolyvalenceServiceImpl(GrillePolyvalenceRepository grillePolyvalenceRepository,
                                        UserRepository userRepository,
                                        MetierRepository metierRepository) {
        this.grillePolyvalenceRepository = grillePolyvalenceRepository;
        this.userRepository = userRepository;
        this.metierRepository = metierRepository;
    }

    @Override
    public List<GrillePolyvalence> retrieveAllGrillePolyvalences() {
        return grillePolyvalenceRepository.findAll();
    }

    @Override
    public Optional<GrillePolyvalence> retrieveGrillePolyvalence(Long grillePolyvalenceId) {
        return grillePolyvalenceRepository.findById(grillePolyvalenceId);
    }

    @Override
    public List<GrillePolyvalence> getGrillePolyvalencesByMetierId(Long metierId) {
        Optional<Metier> optionalMetier = metierRepository.findById(metierId);
        if (optionalMetier.isPresent()) {
            Metier metier = optionalMetier.get();
            return grillePolyvalenceRepository.findByMetier(metier);
        } else {
            throw new IllegalArgumentException("Metier not found");
        }
    }

    @Override
    public List<GrillePolyvalence> getGrillePolyvalencesByUserId(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return grillePolyvalenceRepository.findByUser(user);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }
    @Override
    public GrillePolyvalence addGrillePolyvalence(GrillePolyvalenceDTO grillePolyvalenceDTO) {
        Optional<User> optionalUser = userRepository.findById(grillePolyvalenceDTO.getUserId());
        Optional<Metier> optionalMetier = metierRepository.findById(grillePolyvalenceDTO.getMetierId());

        if (optionalUser.isPresent() && optionalMetier.isPresent()) {
            User user = optionalUser.get();
            Metier metier = optionalMetier.get();

            // Save the file path
            String filePath = grillePolyvalenceDTO.getFilePath();
            if (filePath != null && !filePath.isEmpty()) {
                // You may want to validate and sanitize the file path before saving
                // For simplicity, let's assume the file path is valid and save it as it is
            }

            GrillePolyvalence grillePolyvalence = new GrillePolyvalence(user, metier, grillePolyvalenceDTO.getNiveau(), filePath);
            grillePolyvalence.setFilePath(filePath); // Set the file path

            return grillePolyvalenceRepository.save(grillePolyvalence);
        } else {
            throw new IllegalArgumentException("User or Metier not found");
        }
    }

    @Override
    public GrillePolyvalence modifyGrillePolyvalence(GrillePolyvalenceDTO grillePolyvalenceDTO) {
        Optional<GrillePolyvalence> optionalGrillePolyvalence = grillePolyvalenceRepository.findById(grillePolyvalenceDTO.getId());
        Optional<User> optionalUser = userRepository.findById(grillePolyvalenceDTO.getUserId());
        Optional<Metier> optionalMetier = metierRepository.findById(grillePolyvalenceDTO.getMetierId());

        if (optionalGrillePolyvalence.isPresent() && optionalUser.isPresent() && optionalMetier.isPresent()) {
            GrillePolyvalence grillePolyvalence = optionalGrillePolyvalence.get();
            User user = optionalUser.get();
            Metier metier = optionalMetier.get();

            grillePolyvalence.setUser(user);
            grillePolyvalence.setMetier(metier);
            grillePolyvalence.setNiveau(grillePolyvalenceDTO.getNiveau());
            return grillePolyvalenceRepository.save(grillePolyvalence);
        } else {
            throw new IllegalArgumentException("GrillePolyvalence, User, or Metier not found");
        }
    }

    @Override
    public void removeGrillePolyvalence(Long grillePolyvalenceId) {
        grillePolyvalenceRepository.deleteById(grillePolyvalenceId);
    }
}
