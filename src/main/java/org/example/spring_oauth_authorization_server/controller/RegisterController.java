package org.example.spring_oauth_authorization_server.controller;

import org.example.spring_oauth_authorization_server.dto.RegisterRequest;
import org.example.spring_oauth_authorization_server.entity.RegisterEntity;
import org.example.spring_oauth_authorization_server.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegisterController {

	private final RegisterService registerService;

	@GetMapping("/register")
	public String registerPage() {

		return "register";
	}

	@PostMapping("/register")
	@ResponseBody
	public RegisterEntity register(RegisterRequest registerRequest) {

		return registerService.register(registerRequest);
	}
}
