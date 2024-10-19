package org.example.spring_oauth_authorization_server.entity;

import org.antlr.v4.runtime.misc.NotNull;
import org.example.spring_oauth_authorization_server.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_entity")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String username;

	@NotNull
	private String password;

	@NotNull
	@Enumerated(EnumType.STRING)
	private UserRole role;

	@NotNull
	private String nickname;

	@NotNull
	private String phone;

	@Builder
	public UserEntity(String username, String password, UserRole role, String nickname, String phone) {

		this.username = username;
		this.password = password;
		this.role = role;
		this.nickname = nickname;
		this.phone = phone;
	}

}
