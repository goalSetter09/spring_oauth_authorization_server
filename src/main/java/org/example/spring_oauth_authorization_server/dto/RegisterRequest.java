package org.example.spring_oauth_authorization_server.dto;

public record RegisterRequest(
	String clientName,
	String clientSecret,
	String redirectUris,
	String postLogoutRedirectUris,
	String scopes
) {
}
