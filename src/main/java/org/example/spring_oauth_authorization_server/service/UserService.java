package org.example.spring_oauth_authorization_server.service;

import org.example.spring_oauth_authorization_server.dto.UserJoinRequest;
import org.example.spring_oauth_authorization_server.entity.UserEntity;
import org.example.spring_oauth_authorization_server.enums.UserRole;
import org.example.spring_oauth_authorization_server.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public void JoinUser(UserJoinRequest userJoinRequest) {
		UserEntity userEntity = UserEntity.builder()
			.username(userJoinRequest.username())
			.password(bCryptPasswordEncoder.encode(userJoinRequest.password()))
			.nickname(userJoinRequest.nickname())
			.phone(userJoinRequest.phone())
			.role(UserRole.ROLE_ADMIN)
			.build();

		userRepository.save(userEntity);
	}
}
