package com.generation.localpro.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.localpro.exception.ResourceNotFoundException;
import com.generation.localpro.model.OperationTypeByVendor;
import com.generation.repository.OperationTypeByVendorRepository;

@Service
public class OperationTypeByVendorService {

    private final OperationTypeByVendorRepository operationTypeByVendorRepository;

    public OperationTypeByVendorService(OperationTypeByVendorRepository operationTypeByVendorRepository) {
        this.operationTypeByVendorRepository = operationTypeByVendorRepository;
    }

    public List<OperationTypeByVendor> findAll() {
        return operationTypeByVendorRepository.findAll();
    }

    public List<OperationTypeByVendor> findByVendorId(Integer vendorId) {
        return operationTypeByVendorRepository.findByVendorId(vendorId);
    }

    public List<OperationTypeByVendor> findByOperationTypeId(Integer operationTypeId) {
        return operationTypeByVendorRepository.findByOperationTypeId(operationTypeId);
    }

    public OperationTypeByVendor findById(Integer id) {
        return operationTypeByVendorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("OperationTypeByVendor not found with id: " + id));
    }

    public OperationTypeByVendor save(OperationTypeByVendor otbv) {
        if (otbv.getPrice() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Price cannot be negative");
        }
        if (operationTypeByVendorRepository.existsByVendorIdAndOperationTypeId(otbv.getVendorId(), otbv.getOperationTypeId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Vendor already offers this operation type");
        }
        return operationTypeByVendorRepository.save(otbv);
    }

    public OperationTypeByVendor update(Integer id, OperationTypeByVendor otbv) {
        OperationTypeByVendor existing = findById(id);
        existing.setVendorId(otbv.getVendorId());
        existing.setOperationTypeId(otbv.getOperationTypeId());
        existing.setPrice(otbv.getPrice());
        return operationTypeByVendorRepository.save(existing);
    }

    public void deleteById(Integer id) {
        if (!operationTypeByVendorRepository.existsById(id)) {
            throw new ResourceNotFoundException("OperationTypeByVendor not found with id: " + id);
        }
        operationTypeByVendorRepository.deleteById(id);
    }
}
