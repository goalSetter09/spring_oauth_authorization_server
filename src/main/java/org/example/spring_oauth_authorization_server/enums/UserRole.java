package org.example.spring_oauth_authorization_server.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserRole {
	ROLE_ADMIN("ADMIN"),
	ROLE_USER("USER");

	private final String value;

	public String getValue() {
		return value;
	}

}
