package com.example.ticket.api;



import com.example.ticket.BodySample.Balance;
import com.example.ticket.BodySample.ImgUpdateBody;
import com.example.ticket.BodySample.SamplePermissionId;
import com.example.ticket.dto.MainUserDTO;
import com.example.ticket.dto.UserDTO;
import com.example.ticket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;

	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/set-img")
	public MainUserDTO updateProfileImg(@RequestBody ImgUpdateBody imgUpdateBody) {
		return userService.updateImgInProfile(imgUpdateBody);
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/plusBalance")
	public MainUserDTO plusBalance(@RequestBody Balance balance) {
		return userService.topToBalance(balance);
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/getCurrentUser/{id}")
	public UserDTO getCurrentSessionUser(@PathVariable(name = "id") Long id){
		return userService.getUserById(id);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping(value = "/getAllUsers")
	public List<MainUserDTO> getAllUsers(){
		return userService.getAllUsers();
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PutMapping(value = "/assign")
	public MainUserDTO assign(@RequestBody SamplePermissionId samplePermissionId){
		return userService.assign(samplePermissionId);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/deletePer")
	public MainUserDTO deletePer(@RequestBody SamplePermissionId samplePermissionId){
		return userService.deletePer(samplePermissionId);
	}

}
