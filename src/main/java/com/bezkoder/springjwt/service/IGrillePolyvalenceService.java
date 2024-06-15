package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.GrillePolyvalence;
import com.bezkoder.springjwt.payload.request.GrillePolyvalenceDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IGrillePolyvalenceService {
    List<GrillePolyvalence> retrieveAllGrillePolyvalences();

    Optional<GrillePolyvalence> retrieveGrillePolyvalence(Long grillePolyvalenceId);

    GrillePolyvalence addGrillePolyvalence(GrillePolyvalenceDTO grillePolyvalenceDTO);

    GrillePolyvalence modifyGrillePolyvalence(GrillePolyvalenceDTO grillePolyvalenceDTO);

    void removeGrillePolyvalence(Long grillePolyvalenceId);

    List<GrillePolyvalence> getGrillePolyvalencesByMetierId(Long metierId);

    List<GrillePolyvalence> getGrillePolyvalencesByUserId(Long userId);
}
