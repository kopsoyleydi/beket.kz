package com.example.ticket.service;


import com.example.ticket.BodySample.Balance;
import com.example.ticket.BodySample.ImgUpdateBody;
import com.example.ticket.BodySample.SamplePermissionId;
import com.example.ticket.dto.MainUserDTO;
import com.example.ticket.dto.UserDTO;
import com.example.ticket.impl.PermissionRepoImpl;
import com.example.ticket.impl.UserRepoImpl;
import com.example.ticket.mapper.MainUserMapper;
import com.example.ticket.mapper.UserMapper;
import com.example.ticket.model.Permission;
import com.example.ticket.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDetailsService {

	@Autowired
	private UserRepoImpl userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MainUserMapper mapper;

	@Autowired
	private PermissionRepoImpl repo;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private MainUserMapper mainUserMapper;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.getUserByEmail(username);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("User Not found");
		}
	}

	public User addUser(User user) {
		User checkUser = userRepo.getUserByEmail(user.getEmail());
		if (checkUser == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepo.addUser(user);
		}
		return null;
	}

	public User updatePassword(String newPassword, String oldPassword) {
		User currentUser = getCurrentSessionUser();
		if (passwordEncoder.matches(oldPassword, currentUser.getPassword())) {
			currentUser.setPassword(passwordEncoder.encode(newPassword));
			return userRepo.addUser(currentUser);
		}
		return null;
	}

	public User getCurrentSessionUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			User user = (User) authentication.getPrincipal();
			if (user != null) {
				return user;
			}
		}
		return null;
	}

	public MainUserDTO topToBalance(Balance balance) {
		User user = userRepo.getUserById(balance.getUser_id());
		user.setBalance(balance.getBalance() + user.getBalance());
		return mapper.toDtoUser(userRepo.addUser(user));
	}

	public MainUserDTO updateImgInProfile(ImgUpdateBody imgUpdateBody) {
		User user = (User) loadUserByUsername(imgUpdateBody.userEmail);
		user.setImgLink(imgUpdateBody.link);
		return mapper.toDtoUser(userRepo.addUser(user));
	}

	public UserDTO getUserById(Long id) {
		return userMapper.toDtoUser(userRepo.getUserById(id));
	}

	public String signUpService(String email, String password, String repeatPassword, String name,String surname,
	                            String phoneNumber,String citizenship,String numberOfDocument) {
		if (password.equals(repeatPassword)) {
			User user = new User();
			user.setEmail(email);
			user.setName(name);
			user.setSurname(surname);
			user.setCitizenship(citizenship);
			user.setBalance(0);
			user.setNumberOfDocument(numberOfDocument);
			user.setPhoneNumber(phoneNumber);
			user.setPassword(password);
			user.setImgLink(
					"https://yt3.ggpht.com/a/AGF-l78RCnBXwItPz7NOMEmGVDdZ6Qaoss63865a8Q=s900-c-k-c0xffffffff-no-rj-mo");
			Permission permission = repo.getPermissionById(1L);
			List<Permission> permissionList = new ArrayList<>();
			permissionList.add(permission);
			user.setPermissions(permissionList);
			User newUser = addUser(user);
			if (newUser != null) {
				return "redirect:/sign-up-page?success";
			} else {
				return "redirect:/sign-up-page?emailerror";
			}
		} else {
			return "redirect:/sign-up-page?passworderror";
		}
	}

	public String updatePassword(String oldPassword, String newPassword, String repeatNewPassword) {
		if (newPassword.equals(repeatNewPassword)) {
			User user = updatePassword(newPassword, oldPassword);
			if (user != null) {
				return "redirect:/update-password-page?success";
			} else {
				return "redirect:/update-password-page?oldpassworderror";
			}

		} else {
			return "redirect:/update-password-page?passwordmismatch";
		}
	}

	public List<MainUserDTO> getAllUsers(){
		return mapper.toDtoListUser(userRepo.getAllUsers());
	}

	public MainUserDTO assign(SamplePermissionId samplePermissionId){
		User user = userRepo.getUserById(samplePermissionId.getUser_id());
		Permission permission = repo.getPermissionById(samplePermissionId.getPermission_id());
		List<Permission> permissionList = new ArrayList<>(user.getPermissions());
		permissionList.add(permission);
		user.setPermissions(permissionList);
		return mainUserMapper.toDtoUser(userRepo.updateParam(user));
	}

	public MainUserDTO deletePer(SamplePermissionId samplePermissionId){
		User user = userRepo.getUserById(samplePermissionId.getUser_id());
		Permission permission = repo.getPermissionById(samplePermissionId.getPermission_id());
		int index = 0;
		for(int i = 0;i<user.getPermissions().size();i++){
			if(permission.equals(user.getPermissions().get(i))){
				index = i;
			}
		}
		user.getPermissions().remove(index);
		return mainUserMapper.toDtoUser(userRepo.updateParam(user));
	}
}
