package com.example.ticket.mapper;



import com.example.ticket.dto.PermissionDTO;
import com.example.ticket.model.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
	PermissionDTO toDto(Permission permission);

	Permission toModel(PermissionDTO permissionDTO);

	List<PermissionDTO> toDtoList(List<Permission> list);

	List<Permission> toPermissionList(List<PermissionDTO> list);
}
