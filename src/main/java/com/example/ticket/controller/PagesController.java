package com.example.ticket.controller;


import com.example.ticket.model.ListOfRoads;
import com.example.ticket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PagesController {



	private final UserService userService;


	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/home")
	public String indexPage(Model model) {
		return "index";
	}

	@GetMapping(value = "/403-page")
	public String accessDenied() {
		return "403";
	}

	@GetMapping(value = "/sign-in-page")
	public String signinPage() {
		return "signin";
	}
	@GetMapping(value = "/sign-up-page")
	public String signupPage() {
		return "signup";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/update-password-page")
	public String updatePasswordPage() {
		return "update-password";
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/add-balance")
	public String addBalanceToUser() {
		return "Balance";
	}

	@GetMapping(value = "/roads")
	public String roads(){
		return "roads";
	}

}
