package org.example.spring_oauth_authorization_server.service;

import java.util.UUID;

import org.example.spring_oauth_authorization_server.dto.RegisterRequest;
import org.example.spring_oauth_authorization_server.entity.RegisterEntity;
import org.example.spring_oauth_authorization_server.repository.RegisterRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegisterService {

	private final RegisterRepository registerRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public RegisterEntity register(RegisterRequest registerRequest) {

		RegisterEntity registerEntity = RegisterEntity.builder()
			.id(UUID.randomUUID().toString())
			.clientId(UUID.randomUUID().toString())
			.clientSecret(bCryptPasswordEncoder.encode(UUID.randomUUID().toString()))
			.clientAuthenticationMethods("client_secret_basic")
			.authorizationGrantTypes("refres_token,authorization_code")
			.clientName(registerRequest.clientName())
			.redirectUris(registerRequest.redirectUris())
			.postLogoutRedirectUris(registerRequest.postLogoutRedirectUris())
			.scopes(registerRequest.scopes())
			.clientSettings(
				"{\"@class\":\"java.util.Collections$UnmodifiableMap\",\"settings.client.require-proof-key\":false,\"settings.client.require-authorization-consent\":true}")
			.tokenSettings(
				"{\"@class\":\"java.util.Collections$UnmodifiableMap\",\"settings.token.reuse-refresh-tokens\":true,\"settings.token.x509-certificate-bound-access-tokens\":false,\"settings.token.id-token-signature-algorithm\":[\"org.springframework.security.oauth2.jose.jws.SignatureAlgorithm\",\"RS256\"],\"settings.token.access-token-time-to-live\":[\"java.time.Duration\",300.000000000],\"settings.token.access-token-format\":{\"@class\":\"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat\",\"value\":\"self-contained\"},\"settings.token.refresh-token-time-to-live\":[\"java.time.Duration\",3600.000000000],\"settings.token.authorization-code-time-to-live\":[\"java.time.Duration\",300.000000000],\"settings.token.device-code-time-to-live\":[\"java.time.Duration\",300.000000000]}")
			.build();

		return registerRepository.save(registerEntity);
	}

}
