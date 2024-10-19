package org.example.spring_oauth_authorization_server.controller;

import org.example.spring_oauth_authorization_server.dto.UserJoinRequest;
import org.example.spring_oauth_authorization_server.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/join")
	public String joinPage() {

		return "joinPage";
	}

	@PostMapping("/join")
	@ResponseBody
	public String join(UserJoinRequest userJoinRequest) {

		userService.JoinUser(userJoinRequest);

		return "ok";
	}
}
