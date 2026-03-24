package com.generation.localpro.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.localpro.exception.ResourceNotFoundException;
import com.generation.localpro.model.PortalUser;
import com.generation.localpro.model.Role;
import com.generation.repository.UserRepository;

@Service
public class PortalUserService {

    private final UserRepository userRepository;

    public PortalUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<PortalUser> findAll() {
        return userRepository.findAll();
    }

    public List<PortalUser> findByRole(Role role) {
        return userRepository.findByRole(role);
    }

    public PortalUser findById(Integer id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public PortalUser save(PortalUser portalUser) {
        if (portalUser.getEmail() != null && !userRepository.findByEmail(portalUser.getEmail()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email " + portalUser.getEmail() + " already in use");
        }
        return userRepository.save(portalUser);
    }

    public PortalUser update(Integer id, PortalUser portalUser) {
        PortalUser existing = findById(id);
        existing.setFirstName(portalUser.getFirstName());
        existing.setLastName(portalUser.getLastName());
        existing.setEmail(portalUser.getEmail());
        existing.setPassword(portalUser.getPassword());
        existing.setCity(portalUser.getCity());
        existing.setAddress(portalUser.getAddress());
        existing.setRole(portalUser.getRole());
        existing.setBio(portalUser.getBio());
        existing.setX(portalUser.getX());
        existing.setY(portalUser.getY());
        return userRepository.save(existing);
    }

    public void deleteById(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
