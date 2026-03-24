package com.generation.localpro.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.generation.localpro.exception.ResourceNotFoundException;
import com.generation.localpro.model.OperationType;
import com.generation.localpro.model.Status;
import com.generation.repository.OperationTypeRepository;

@Service
public class OperationTypeService {

    private final OperationTypeRepository operationTypeRepository;

    public OperationTypeService(OperationTypeRepository operationTypeRepository) {
        this.operationTypeRepository = operationTypeRepository;
    }

    public List<OperationType> findAll() {
        return operationTypeRepository.findAll();
    }

    public List<OperationType> findByStatus(Status status) {
        return operationTypeRepository.findByStatus(status);
    }

    public OperationType findById(Integer id) {
        return operationTypeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("OperationType not found with id: " + id));
    }

    public OperationType save(OperationType operationType) {
        return operationTypeRepository.save(operationType);
    }

    public OperationType update(Integer id, OperationType operationType) {
        OperationType existing = findById(id);
        existing.setName(operationType.getName());
        existing.setUserId(operationType.getUserId());
        existing.setDescription(operationType.getDescription());
        existing.setTags(operationType.getTags());
        existing.setStatus(operationType.getStatus());
        return operationTypeRepository.save(existing);
    }

    public void deleteById(Integer id) {
        if (!operationTypeRepository.existsById(id)) {
            throw new ResourceNotFoundException("OperationType not found with id: " + id);
        }
        operationTypeRepository.deleteById(id);
    }
}
