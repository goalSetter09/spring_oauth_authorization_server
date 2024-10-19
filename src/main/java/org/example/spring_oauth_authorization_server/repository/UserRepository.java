package org.example.spring_oauth_authorization_server.repository;

import java.util.Optional;

import org.example.spring_oauth_authorization_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
