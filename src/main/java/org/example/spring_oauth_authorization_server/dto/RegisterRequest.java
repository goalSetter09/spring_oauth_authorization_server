package org.example.spring_oauth_authorization_server.dto;

public record RegisterRequest(
	String clientName,
	String redirectUris,
	String postLogoutRedirectUris,
	String scopes
) {
}
