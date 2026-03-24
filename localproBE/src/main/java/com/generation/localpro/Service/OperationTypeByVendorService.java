package com.generation.localpro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.localpro.model.OperationType;
import com.generation.localpro.model.OperationTypeByVendor;
import com.generation.localpro.model.PortalUser;
import com.generation.localpro.repository.OperationTypeByVendorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OperationTypeByVendorService 
{
    @Autowired
    private OperationTypeByVendorRepository operationTypeByVendorRepository;
 
    @Autowired
    private PortalUserService portalUserService;
 
    @Autowired
    private OperationTypeService operationTypeService;

    

    public List<OperationTypeByVendor> findAll() {
        return operationTypeByVendorRepository.findAll();
    }


    public OperationTypeByVendor findById(Long id) {
        return operationTypeByVendorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OperationTypeByVendor not found with id: " + id));
    }

    public void delete(Long id) {
        if (!operationTypeByVendorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Servizio con id " + id + " non trovato");
        }
        operationTypeByVendorRepository.deleteById(id);
    }

    public OperationTypeByVendor save(OperationTypeByVendor otbv) {
        PortalUser vendor = portalUserService.findById(otbv.getVendor().getId());
        OperationType opType = operationTypeService.findById(otbv.getOperationType().getId());
        if (operationTypeByVendorRepository.existsByVendorIdAndOperationTypeId(
                vendor.getId(), opType.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Il vendor offre già questo servizio");
        }
        if (otbv.getPrice() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Il prezzo non può essere negativo");
        }
        otbv.setVendor(vendor);
        otbv.setOperationType(opType);
        return operationTypeByVendorRepository.save(otbv);
    }
    
}
