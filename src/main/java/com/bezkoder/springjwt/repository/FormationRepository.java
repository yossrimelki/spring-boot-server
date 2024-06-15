package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
    List<Formation> findByProgramFId(Long programId);
    // You can add custom query methods here if needed
}
