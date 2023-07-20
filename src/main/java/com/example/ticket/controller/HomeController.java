package com.example.ticket.controller;


import com.example.ticket.model.User;
import com.example.ticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	@Autowired
	private UserService userService;

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/profile")
	public String profilePage(Model model) {
		User user = userService.getCurrentSessionUser();
		model.addAttribute("user", user);
		return "profile";
	}

	@PostMapping(value = "/to-sign-up")
	public String toSignUp(@RequestParam(name = "user_email") String email,
	                       @RequestParam(name = "user_password") String password,
	                       @RequestParam(name = "user_repeat_password") String repeatPassword,
	                       @RequestParam(name = "user_name") String name,
	                       @RequestParam(name = "user_surname") String surname,
	                       @RequestParam(name = "user_phoneNumber") String phoneNumber,
	                       @RequestParam(name = "user_citizenship") String citizenship,
	                       @RequestParam(name = "user_numberOfDocument") String numberOfDocument) {
		return userService.signUpService(email,password,repeatPassword,name,surname,phoneNumber
				,citizenship, numberOfDocument);
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/to-update-password")
	public String toUpdatePassword(
			@RequestParam(name = "user_old_password") String oldPassword,
			@RequestParam(name = "user_new_password") String newPassword,
			@RequestParam(name = "user_repeat_new_password") String repeatNewPassword) {

		return userService.updatePassword(oldPassword,newPassword,repeatNewPassword);
	}
}
