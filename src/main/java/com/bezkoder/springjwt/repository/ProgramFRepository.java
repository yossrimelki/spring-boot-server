package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.ProgramF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramFRepository extends JpaRepository<ProgramF, Long> {
    boolean existsByTitle(String title);
    // You can add custom query methods here if needed
}
