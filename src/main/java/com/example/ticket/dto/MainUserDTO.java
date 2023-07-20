package com.example.ticket.dto;


import com.example.ticket.model.Permission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MainUserDTO {

	private Long id;

	private String email;

	private String password;

	private String name;

	private String imgLink;

	private String surname;

	private String citizenship;

	private String numberOfDocument;

	private String phoneNumber;
	private int balance;

	private List<Permission> permissions;
}
