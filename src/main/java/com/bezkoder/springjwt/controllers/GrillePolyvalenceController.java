package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.GrillePolyvalence;
import com.bezkoder.springjwt.payload.request.GrillePolyvalenceDTO;
import com.bezkoder.springjwt.service.GrillePolyvalenceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/grille-polyvalence")
public class GrillePolyvalenceController {
    public static String UPLOAD_DIRECTORY = "Y:/pfe/jwt-angular/src/assets/";

    private final GrillePolyvalenceServiceImpl grillePolyvalenceService;

    @Autowired
    public GrillePolyvalenceController(GrillePolyvalenceServiceImpl grillePolyvalenceService) {
        this.grillePolyvalenceService = grillePolyvalenceService;
    }
    @GetMapping("/retrieve-by-metier/{metierId}")
    public ResponseEntity<List<GrillePolyvalence>> retrieveGrillePolyvalencesByMetierId(@PathVariable("metierId") Long metierId) {
        List<GrillePolyvalence> grillePolyvalences = grillePolyvalenceService.getGrillePolyvalencesByMetierId(metierId);
        return ResponseEntity.ok(grillePolyvalences);
    }

        @GetMapping("/retrieve-by-user/{userId}")
    public ResponseEntity<List<GrillePolyvalence>> retrieveGrillePolyvalencesByUserId(@PathVariable("userId") Long userId) {
        List<GrillePolyvalence> grillePolyvalences = grillePolyvalenceService.getGrillePolyvalencesByUserId(userId);
        return ResponseEntity.ok(grillePolyvalences);
    }


    @GetMapping("/retrieve-all-grille-polyvalences")
    public List<GrillePolyvalence> getGrillePolyvalences() {
        return grillePolyvalenceService.retrieveAllGrillePolyvalences();
    }


    @GetMapping("/retrieve-grille-polyvalence/{grillePolyvalenceId}")
    public ResponseEntity<GrillePolyvalence> retrieveGrillePolyvalence(@PathVariable("grillePolyvalenceId") Long grillePolyvalenceId) {
        Optional<GrillePolyvalence> grillePolyvalence = grillePolyvalenceService.retrieveGrillePolyvalence(grillePolyvalenceId);
        return grillePolyvalence
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add-grille-polyvalence")
    public ResponseEntity<String> addGrillePolyvalence(
            @RequestPart("grillePolyvalenceDTO") String grillePolyvalenceDTOString,
            @RequestPart("file") MultipartFile file) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            GrillePolyvalenceDTO grillePolyvalenceDTO = objectMapper.readValue(grillePolyvalenceDTOString, GrillePolyvalenceDTO.class);

            // Save the file
            String savedFilePath = saveFile(file);
            grillePolyvalenceDTO.setFilePath(savedFilePath);

            GrillePolyvalence newGrillePolyvalence = grillePolyvalenceService.addGrillePolyvalence(grillePolyvalenceDTO);

            // Return success message with the saved GrillePolyvalence details
            return ResponseEntity.ok("GrillePolyvalence added successfully with ID: " + newGrillePolyvalence.getId());
        } catch (Exception e) {
            // Return error message if any exception occurs
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add GrillePolyvalence: " + e.getMessage());
        }
    }



    private String saveFile(MultipartFile file) throws IOException {
        try {
            String currentDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = currentDate + "_" + UUID.randomUUID().toString() + fileExtension; // Use UUID to ensure unique file names
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIRECTORY + fileName);
            Files.write(path, bytes);
            return fileName;
        } catch (IOException e) {
            throw new IOException("Failed to save file: " + e.getMessage());
        }
    }


    @PutMapping("/modify-grille-polyvalence")
    public ResponseEntity<GrillePolyvalence> modifyGrillePolyvalence(@RequestBody GrillePolyvalenceDTO grillePolyvalenceDTO) {
        GrillePolyvalence modifiedGrillePolyvalence = grillePolyvalenceService.modifyGrillePolyvalence(grillePolyvalenceDTO);
        return ResponseEntity.ok(modifiedGrillePolyvalence);
    }

    @DeleteMapping("/remove-grille-polyvalence/{grillePolyvalenceId}")
    public ResponseEntity<?> removeGrillePolyvalence(@PathVariable("grillePolyvalenceId") Long grillePolyvalenceId) {
        grillePolyvalenceService.removeGrillePolyvalence(grillePolyvalenceId);
        return ResponseEntity.ok().build();
    }
}
