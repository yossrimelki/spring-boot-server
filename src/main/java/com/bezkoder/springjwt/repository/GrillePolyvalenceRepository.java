package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.GrillePolyvalence;
import com.bezkoder.springjwt.models.Metier;
import com.bezkoder.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrillePolyvalenceRepository extends JpaRepository<GrillePolyvalence, Long> {
    List<GrillePolyvalence> findByMetier(Metier metier);
    List<GrillePolyvalence> findByUser(User user);
    List<GrillePolyvalence> getGrillePolyvalencesByMetierId(Long metierId);

}
