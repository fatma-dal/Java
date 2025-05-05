package com.GoTogether.auth;
import com.GoTogether.models.Role;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequest {
    /**
     * Data Transfer Object (DTO) for handling user registration requests.
     * Contains the necessary information for creating a new user, including
     * full name, email, password, and role.
     */
    String firstName;
    String lastName;
    String email;
    String password;
    Role role;
	public Object getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getRole() {
		// TODO Auto-generated method stub
		return null;
	}
	public CharSequence getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
