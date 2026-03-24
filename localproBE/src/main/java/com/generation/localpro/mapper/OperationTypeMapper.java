package com.generation.localpro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.generation.localpro.model.OperationType;



@Mapper (componentModel = "spring")
public interface OperationTypeMapper {
    
       OperationTypeDTO toDTO( OperationType operatyontype);
       List<OperationTypeDTO> toDTOs(List< OperationType> operatyontypes);

      OperationType toEntity( OperationTypeDTO operatyontypeDTO);
      List< OperationType> toEntities(List< OperationTypeDTO> operatyontypesDTO);

}
