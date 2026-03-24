package com.generation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.localpro.model.OperationType;

public interface OperationTypeRepository extends JpaRepository<OperationType, Integer>
{
    List<OperationType> findByVendorId(Integer vendorId);
    List<OperationType> findByOperationTypeId(Integer operationTypeId);
}
