package com.generation.localpro.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import com.generation.localpro.model.PortalUser;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PortalUserService 
{

    @Autowired
    PortalUserRepository portalUserRepository;

    @Autowired
    PortalUserMapper portalUserMapper;

    
    
    public List<PortalUser> findAll() {
        return portalUserRepository.findAll();
    }

    public PortalUserDTO findById(Long id) {
        PortalUser portalUser = PortalUserRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return portalUserMapper.toDTO(portalUser);
    }

    public PortalUser save(PortalUser portalUser) {
        if (portalUserRepository.existsByEmail(portalUser.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Email " + portalUser.getEmail() + " già in uso");
        }
        return portalUserRepository.save(portalUser);
    }


    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    

    

}
