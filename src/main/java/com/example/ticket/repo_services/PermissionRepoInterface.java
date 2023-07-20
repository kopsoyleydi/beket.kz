package com.example.ticket.repo_services;



import com.example.ticket.model.Permission;

import java.util.List;


public interface PermissionRepoInterface {
	Permission getPermissionById(Long id);

	Permission addPermission(Permission permission);

	List<Permission> getAllPermissions();
}
