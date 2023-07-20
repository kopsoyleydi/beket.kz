package com.example.ticket.service;



import com.example.ticket.dto.PermissionDTO;
import com.example.ticket.impl.PermissionRepoImpl;
import com.example.ticket.mapper.PermissionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionService {

	private final PermissionRepoImpl repo;

	private final PermissionMapper mapper;


	public List<PermissionDTO> getAllPermissions(){
		return mapper.toDtoList(repo.getAllPermissions());
	}
}
