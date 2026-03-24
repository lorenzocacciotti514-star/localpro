package com.generation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.localpro.model.OperationTypeByVendor;

public interface OprationTypeByVendorRepository extends JpaRepository<OperationTypeByVendor, Integer>
{
    List<OperationTypeByVendor> findByVendorId(Integer vendorId);
    List<OperationTypeByVendor> findByOperationTypeId(Integer operationTypeId);
}
