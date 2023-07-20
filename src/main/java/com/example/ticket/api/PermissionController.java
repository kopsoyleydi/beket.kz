package com.example.ticket.api;



import com.example.ticket.dto.PermissionDTO;
import com.example.ticket.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PermissionController {

	private final PermissionService service;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping(value = "/getAllPermissions")
	public List<PermissionDTO> getAllPermissions(){
		return service.getAllPermissions();
	}


}
