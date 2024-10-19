package org.example.spring_oauth_authorization_server.repository;

import java.util.Optional;

import org.example.spring_oauth_authorization_server.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<RegisterEntity, String> {
	Optional<RegisterEntity> findByClientId(String clientId);
}
