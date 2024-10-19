package org.example.spring_oauth_authorization_server.service;

import org.example.spring_oauth_authorization_server.entity.UserEntity;
import org.example.spring_oauth_authorization_server.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity userEntity = userRepository.findByUsername(username).orElseThrow();

		UserDetails userDetails = User.builder()
			.username(userEntity.getUsername())
			.password(userEntity.getPassword())
			.roles(userEntity.getRole().getValue())
			.build();

		return userDetails;
	}
}