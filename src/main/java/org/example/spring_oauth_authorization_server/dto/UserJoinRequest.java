package org.example.spring_oauth_authorization_server.dto;

public record UserJoinRequest(
	String username,
	String password,
	String role,
	String nickname,
	String phone
) {
}
