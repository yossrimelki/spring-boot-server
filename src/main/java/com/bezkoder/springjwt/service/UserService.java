package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;
import org.codehaus.plexus.resource.loader.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Map<String, Object>> getUsersByUsernameAleasAndRole() {
        return userRepository.findUsernameAleasAndRole();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User partialUser) throws ResourceNotFoundException {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        // Update only the fields that are not null in partialUser
        if (partialUser.getUsername() != null) {
            existingUser.setUsername(partialUser.getUsername());
        }
        if (partialUser.getMat() != null) {
            existingUser.setMat(partialUser.getMat());
        }
        if (partialUser.getAleas() != null) {
            existingUser.setAleas(partialUser.getAleas());
        }

        if (partialUser.getEmail() != null) {
            existingUser.setEmail(partialUser.getEmail());
        }
        // Repeat this for other fields as needed

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
