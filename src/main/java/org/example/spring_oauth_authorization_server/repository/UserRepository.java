package org.example.spring_oauth_authorization_server.repository;

import java.util.Optional;

import org.example.spring_oauth_authorization_server.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);
}
