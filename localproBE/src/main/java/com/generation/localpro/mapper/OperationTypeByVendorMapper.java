package com.generation.localpro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.generation.localpro.model.OperationTypeByVendor;



@Mapper (componentModel = "spring")
public interface OperationTypeByVendorMapper {
    
      OperationTypeByVendorDTO toDTO( OperationTypeByVendor operatyontypebyvendor);
      List<OperationTypeByvendorDTO> toDTOs(List<OperationTypeByVendor> operatyontypebyvendors);

      OperationTypeByVendor toEntity( OperationTypeByvendorDTO operatyontypeDTO);
      List< OperationTypeByVendor> toEntities(List< OperationTypeByvendorDTO> operatyontypebyvendorsDTO);
      

} 
