package com.generation.localpro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.localpro.model.OperationType;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OperationTypeService 
{
    @Autowired
    private OperationTypeRepository operationTypeRepository;


    
    public List<OperationType> findAll() {
        return operationTypeRepository.findAll();
    }

    public OperationType findById(Long id) {
        return operationTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OperationType not found with id: " + id));
    }

    public OperationType save(OperationType operationType) {
        return operationTypeRepository.save(operationType);
    }

    public void deleteById(Long id) {
        operationTypeRepository.deleteById(id);
    }


}
