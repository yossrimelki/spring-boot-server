package com.bezkoder.springjwt.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	User findById(int id);

	@Override
	List<User> findAll();

	@Query("SELECT NEW Map(u.id as id, u.username as username, u.aleas as aleas, r.name as role) FROM User u JOIN u.roles r")
	List<Map<String, Object>> findUsernameAleasAndRole();
}
