package com.generation.localpro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.generation.localpro.model.PortalUser;


@Mapper (componentModel = "spring")
public interface PortalUserMapper {

     PortalUserDTO toDTO(PortalUser portaluser);
     List<PortalUserDTO> toDTOs(List<PortalUser> portalusers);

     PortalUser toEntity(PortalUserDTO portaluserDTO);
     List<PortalUser> toEntities(List<PortalUserDTO> portalusersDTO);

    
}
